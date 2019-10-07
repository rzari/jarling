package org.jarling.http;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.util.StreamUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author Nav Roudsari (nav@rzari.co.uk)
 */
public class HttpResponse {

    private int statusCode;
    private InputStream is;
    private URL request;
    private Map<String, List<String>> responseHeaders;
    private String contentType;

    public HttpResponse(HttpsURLConnection httpsURLConnection) throws StarlingBankRequestException {
        try {
            if (httpsURLConnection.getResponseCode() < HttpsURLConnection.HTTP_BAD_REQUEST) {
                this.is = httpsURLConnection.getInputStream();
            } else {
                this.is = httpsURLConnection.getErrorStream();
                processStatusCode(httpsURLConnection);
            }
            this.statusCode = httpsURLConnection.getResponseCode();
            this.request = httpsURLConnection.getURL();
            this.responseHeaders = httpsURLConnection.getHeaderFields();
            this.contentType = httpsURLConnection.getContentType();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processStatusCode(HttpsURLConnection httpsURLConnection) throws StarlingBankRequestException {
        try {
            switch (httpsURLConnection.getResponseCode()) {
                case 400:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), this.asString(), "Bad Request", "Something was wrong with the request made, check the request to address the error included in the response");
                case 401:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), this.asString(), "Unauthorized", "You are not authorised to access the requested data");
                case 403:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), this.asString(), "Forbidden", "Your authentication failed, usually due to the access token being expired or an attempt to access a resource beyond the scope of the token");
                case 404:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), this.asString(), "Not Found", "The requested resource does not exist");
                case 500:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), this.asString(), "Internal Server Error", "Something went wrong on our side - get in touch so we can look into it!");
                default:
                    throw new StarlingBankRequestException(httpsURLConnection.getResponseCode(), this.asString(), "Unknown Error", "Looks like something might be wrong jarling");
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

    public String getContentType() {
        return this.contentType;
    }

    public JsonObject asJsonObject() {
        JsonObject json = null;
        if (this.contentType.equals("application/json")) {
            JsonParser jsonParser = new JsonParser();
            json = (JsonObject) jsonParser.parse(new InputStreamReader(this.is, StandardCharsets.UTF_8));
        }
        return json;
    }

    public String asString() {
        if (this.is == null) {
            return "";
        }

        try {
            return StreamUtils.toString(this.is);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public byte[] asBytes() {
        try {
            return StreamUtils.toByteArray(this.is);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public Map<String, List<String>> getHeaders() {
        return this.responseHeaders;
    }
}
