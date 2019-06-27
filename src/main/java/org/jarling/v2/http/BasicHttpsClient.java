package org.jarling.v2.http;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.http.HttpResponse;
import org.jarling.http.RequestMethod;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BasicHttpsClient {
    private HttpResponse request(HttpRequest httpRequest) throws StarlingBankRequestException {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpRequest.getFullUrl().openConnection();
            httpsURLConnection.setRequestMethod(httpRequest.getRequestMethod().getValue());
            setRequestHeaders(httpsURLConnection, getHeaders(httpRequest));
            if (httpRequest.getBody() != null){
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.getOutputStream().write(httpRequest.getBody().getBytes("UTF-8"));
            }
            return new HttpResponse(httpsURLConnection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected Map<String, String> getAuthorizationHeaders(HttpRequest request) {
        return null;
    }

    private Map<String, String> getHeaders(HttpRequest request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Jarling/0.1 (Starling Bank Java Client Library)");
        headers.put("Accept", "application/json");
        if (request.getBody() != null) {
            headers.put("Content-Type", "application/json; charset=utf-8");
        }

        if (request.getHeaders() != null) {
            headers.putAll(request.getHeaders());
        }

        Map<String, String> authHeaders = getAuthorizationHeaders(request);
        if (authHeaders != null) {
            headers.putAll(authHeaders);
        }

        return headers;
    }

    private void setRequestHeaders(HttpsURLConnection httpsURLConnection, Map<String, String> requestHeaders){
        if (requestHeaders == null) {
            return;
        }

        requestHeaders.forEach(httpsURLConnection::setRequestProperty);
    }


    public HttpResponse get(String url, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.GET, url, queryParameters, requestHeaders, null));
    }

    public HttpResponse post(String url, String body, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.POST, url, queryParameters, requestHeaders, body));
    }

    public HttpResponse put(String url, String body, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.PUT, url, queryParameters, requestHeaders, body));
    }

    public HttpResponse delete(String url, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request(new HttpRequest(RequestMethod.DELETE, url, queryParameters, requestHeaders, null));
    }
}
