package org.jarling.services;

import org.jarling.StarlingBankApiVersion;
import org.jarling.StarlingBankEnvironment;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.http.BasicHttpsClient;
import org.jarling.http.HttpClient;
import org.jarling.http.HttpParameter;
import org.jarling.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Service to manage the API requests to Starling Bank API Endpoints
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public final class ApiService implements HttpClient{

    private final Map<String, String> defaultRequestHeaders = new HashMap<>();
    private final BasicHttpsClient request;
    private final String STARLING_BANK_API_VERSION;
    private final String STARLING_BANK_ENDPOINT;
    private final String ACCESS_TOKEN;

    public ApiService(StarlingBankApiVersion starlingApiVersion, StarlingBankEnvironment starlingBankEnvironment, String accessToken) {
        this.STARLING_BANK_API_VERSION = starlingApiVersion.getPath();
        this.STARLING_BANK_ENDPOINT = starlingBankEnvironment.getPath() + STARLING_BANK_API_VERSION;
        this.ACCESS_TOKEN = accessToken;
        setDefaultRequestHeaders();
        this.request = new BasicHttpsClient(getDefaultRequestHeaders());
    }

    private void setDefaultRequestHeaders(){
        defaultRequestHeaders.put("User-Agent", "Jarling/0.1 (Starling Bank Java Client Library)");
        defaultRequestHeaders.put("Authorization", "Bearer " + this.ACCESS_TOKEN);
    }

    private String removeApiVersionFromUrl(String url){
        return url.replace(STARLING_BANK_API_VERSION, "");
    }

    public String getLocationHeader(HttpResponse httpResponse){
        return removeApiVersionFromUrl(httpResponse.getHeaders().get("Location").get(0));
    }

    public Map<String,String> getDefaultRequestHeaders(){
        return defaultRequestHeaders;
    }

    public HttpResponse get(String url) throws StarlingBankRequestException {
        return request.get(this.STARLING_BANK_ENDPOINT + url);
    }

    public HttpResponse get(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException {
        return request.get(this.STARLING_BANK_ENDPOINT + url, httpParameters);
    }

    public HttpResponse get(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request.get(this.STARLING_BANK_ENDPOINT + url, httpParameters, requestHeaders);
    }

    public HttpResponse post(String url) throws StarlingBankRequestException {
        return request.post(this.STARLING_BANK_ENDPOINT + url);
    }

    public HttpResponse post(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException {
        return request.post(this.STARLING_BANK_ENDPOINT + url, httpParameters);
    }

    public HttpResponse post(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request.post(this.STARLING_BANK_ENDPOINT + url, httpParameters, requestHeaders);
    }

    public HttpResponse post(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders, String body) throws StarlingBankRequestException {
        return request.post(this.STARLING_BANK_ENDPOINT + url, httpParameters, requestHeaders, body);
    }

    public HttpResponse put(String url) throws StarlingBankRequestException {
        return request.put(this.STARLING_BANK_ENDPOINT + url);
    }

    public HttpResponse put(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException {
        return request.put(this.STARLING_BANK_ENDPOINT + url, httpParameters);
    }

    public HttpResponse put(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request.put(this.STARLING_BANK_ENDPOINT + url, httpParameters, requestHeaders);
    }

    public HttpResponse put(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders, String body) throws StarlingBankRequestException {
        return request.put(this.STARLING_BANK_ENDPOINT + url, httpParameters, requestHeaders, body);
    }

    public HttpResponse delete(String url) throws StarlingBankRequestException {
        return request.delete(this.STARLING_BANK_ENDPOINT + url);
    }

    public HttpResponse delete(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException {
        return request.delete(this.STARLING_BANK_ENDPOINT + url, httpParameters);
    }

    public HttpResponse delete(String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return request.delete(this.STARLING_BANK_ENDPOINT + url, httpParameters, requestHeaders);
    }
}
