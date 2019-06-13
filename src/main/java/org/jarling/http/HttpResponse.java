package org.jarling.http;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jarling.exceptions.StarlingBankRequestException;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class HttpResponse {

    private final HttpsURLConnection httpsURLConnection;
    private int statusCode;
    private InputStream is;
    private URL request;
    private Long expiration;
    private Long lastModified;
    private Map<String, List<String>> responseHeaders;
    private String contentType;
    private String contentEncoding;

    public HttpResponse(HttpsURLConnection httpsURLConnection) throws StarlingBankRequestException {
        this.httpsURLConnection = httpsURLConnection;
        try {
            if (httpsURLConnection.getResponseCode() < HttpsURLConnection.HTTP_BAD_REQUEST){
                this.is = httpsURLConnection.getInputStream();
            }else {
                this.is = httpsURLConnection.getErrorStream();
                processStatusCode(httpsURLConnection);
            }
            this.statusCode = httpsURLConnection.getResponseCode();
            this.expiration = httpsURLConnection.getExpiration();
            this.request = httpsURLConnection.getURL();
            this.expiration = httpsURLConnection.getExpiration();
            this.lastModified = httpsURLConnection.getLastModified();
            this.responseHeaders = httpsURLConnection.getHeaderFields();
            this.contentType = httpsURLConnection.getContentType();
            this.contentEncoding = httpsURLConnection.getContentEncoding();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processStatusCode(HttpsURLConnection httpsURLConnection) throws StarlingBankRequestException {
        try {
            switch (httpsURLConnection.getResponseCode()){
                case 400:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), toString(this.is), "Bad Request", "Something was wrong with the request made, check the request to address the error included in the response");
                case 401:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), toString(this.is), "Unauthorized", "You are not authorised to access the requested data");
                case 403:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), toString(this.is), "Forbidden", "Your authentication failed, usually due to the access token being expired or an attempt to access a resource beyond the scope of the token");
                case 404:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), toString(this.is), "Not Found", "The requested resource does not exist");
                case 500:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), toString(this.is), "Internal Server Error", "Something went wrong on our side - get in touch so we can look into it!");
                default:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), toString(this.is), "Unknown Error", "Looks like something might be wrong jarling");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public URL getRequest() {
        return this.request;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public long getExpiration() {
        return this.expiration;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getResponseHeader(String name) {
        return this.httpsURLConnection.getHeaderField(name);
    }

    public InputStream getInputStream() {
        return this.is;
    }

    public JsonObject asJsonObject() {
        JsonObject json = null;
        if (this.contentType.equals("application/json")) {
            JsonParser jsonParser = new JsonParser();
            try {
                json = (JsonObject) jsonParser.parse(new InputStreamReader(this.is, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return json;
    }

    private String toString(InputStream is){
        final StringBuilder stringBuilder = new StringBuilder();
        String responseString;
        if (this.is != null){
            BufferedReader reader;
            try {
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while (null != (responseString = reader.readLine())){
                    stringBuilder.append(responseString).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return stringBuilder.toString();
    }

    public String asString(){
        return toString(this.is);
    }

    public byte[] asBytes() {
        try {
            byte[] targetArray = new byte[this.is.available()];
            this.is.read(targetArray);
            return targetArray;
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public void disconnect() {
        this.httpsURLConnection.disconnect();
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public Map<String, List<String>> getHeaders() {
        return this.responseHeaders;
    }
}
