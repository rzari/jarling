package org.jarling.http;

import org.jarling.exceptions.StarlingBankRequestException;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class BasicHttpsClient implements HttpClient{

    private final Map<String,String> requestHeaders;

    public BasicHttpsClient(Map<String, String> defaultRequestHeaders){
        if (defaultRequestHeaders != null) {
            this.requestHeaders = defaultRequestHeaders;
        }
        else{
            this.requestHeaders = new HashMap<>();
        }
    }

    public Map<String, String> getDefaultRequestHeaders() {
        return this.requestHeaders;
    }

    private HttpResponse request(HttpRequest httpRequest) throws StarlingBankRequestException {
        HttpsURLConnection httpsURLConnection = null;
        URL requestUrl = null;
        HttpResponse httpResponse;
        try {
            requestUrl = new URL(httpRequest.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            httpsURLConnection = (HttpsURLConnection) (requestUrl != null ? requestUrl.openConnection() : null);
            assert httpsURLConnection != null;
            httpsURLConnection.setRequestMethod(httpRequest.getRequestMethod().getValue());
            setRequestHeaders(httpsURLConnection, this.getDefaultRequestHeaders());
            setRequestHeaders(httpsURLConnection, httpRequest.getRequestHeaders());
            if (httpRequest.getBody() != null){
                this.requestHeaders.put("Accept", "application/json");
                this.requestHeaders.put("Content-Type", "application/json; charset=utf-8");
                setRequestHeaders(httpsURLConnection, this.getDefaultRequestHeaders());
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.getOutputStream().write(httpRequest.getBody().getBytes("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpResponse = new HttpResponse(httpsURLConnection);

        return httpResponse;
    }

    private void setRequestHeaders(HttpsURLConnection httpsURLConnection, Map<String, String> requestHeaders){
        if (requestHeaders != null) {
            for (Map.Entry<String, String> requestHeader : requestHeaders.entrySet()) {
                httpsURLConnection.setRequestProperty(requestHeader.getKey(), requestHeader.getValue());
            }
        }
    }

    public HttpResponse get(String url) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.GET, url, null, this.requestHeaders, null));
    }

    public HttpResponse get(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.GET, url, httpParameters, this.requestHeaders, null));
    }

    public HttpResponse get(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.GET, url, httpParameters, requestHeaders, null));
    }

    public HttpResponse post(String url) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.POST, url, null, null, null));
    }

    public HttpResponse post(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.POST, url, httpParameters, null, null));
    }

    public HttpResponse post(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.POST, url, httpParameters, requestHeaders, null));
    }

    public HttpResponse post(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders, String body) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.POST, url, httpParameters, requestHeaders, body));
    }

    public HttpResponse put(String url) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.PUT, url, null, null, null));
    }

    public HttpResponse put(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.PUT, url, httpParameters, null, null));
    }

    public HttpResponse put(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.PUT, url, httpParameters, requestHeaders, null));
    }

    public HttpResponse put(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders, String body) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.PUT, url, httpParameters, requestHeaders, body));
    }

    public HttpResponse delete(String url) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.DELETE, url, null, null, null));
    }

    public HttpResponse delete(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.DELETE, url, httpParameters, null, null));
    }

    public HttpResponse delete(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.DELETE, url, httpParameters, requestHeaders, null));
    }
}
