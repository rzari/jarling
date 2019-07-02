package org.jarling.v2;

import org.jarling.StarlingBankEnvironment;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.http.HttpResponse;
import org.jarling.v2.exception.SignatureException;
import org.jarling.v2.http.BearerHttpsClient;
import org.jarling.v2.http.CertificateType;
import org.jarling.v2.http.SignedHttpsClient;

import java.security.PrivateKey;
import java.util.Map;
import java.util.UUID;

/**
 *
 * Service to manage the API requests to Starling Bank API Endpoints
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public final class ApiService {
    private static final String API_BASE_PATH = "/api/v2";
    private final BearerHttpsClient authenticatedRequest;
    private SignedHttpsClient signedRequest;
    private final String starlingBankEndpoint;

    public ApiService(StarlingBankEnvironment starlingBankEnvironment, String accessToken) {
        this.starlingBankEndpoint = starlingBankEnvironment.getPath() + API_BASE_PATH;
        this.authenticatedRequest = new BearerHttpsClient(accessToken);
    }

    public void configureRequestSigning(PrivateKey privateKey, UUID publicKeyUid, CertificateType certificateType) {
        this.signedRequest = new SignedHttpsClient(authenticatedRequest.getAccessToken(), privateKey, publicKeyUid, certificateType);
    }

    public boolean canSignRequests() {
        return signedRequest != null;
    }

    public HttpResponse get(String url) throws StarlingBankRequestException {
        return get(url, null);
    }

    public HttpResponse get(String url, Map<String, String> queryParameters) throws StarlingBankRequestException {
        return get(url, queryParameters,  null);
    }

    public HttpResponse get(String url, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return authenticatedRequest.get(this.starlingBankEndpoint + url, queryParameters, requestHeaders);
    }

    public HttpResponse getSigned(String url) throws StarlingBankRequestException {
        return getSigned(url, null);
    }

    public HttpResponse getSigned(String url, Map<String, String> queryParameters) throws StarlingBankRequestException {
        return getSigned(url, queryParameters,  null);
    }

    public HttpResponse getSigned(String url, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        if (signedRequest == null) {
            throw SignatureException.notConfiguredException();
        }

        return signedRequest.get(this.starlingBankEndpoint + url, queryParameters, requestHeaders);
    }

    public HttpResponse postSigned(String url) throws StarlingBankRequestException {
        return postSigned(url, null);
    }

    public HttpResponse postSigned(String url, String body) throws StarlingBankRequestException {
        return postSigned(url, body, null, null);
    }

    public HttpResponse postSigned(String url, String body, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        if (signedRequest == null) {
            throw SignatureException.notConfiguredException();
        }

        return signedRequest.post(this.starlingBankEndpoint + url, body, queryParameters, requestHeaders);
    }

    public HttpResponse post(String url) throws StarlingBankRequestException {
        return post(url, null);
    }

    public HttpResponse post(String url, String body) throws StarlingBankRequestException {
        return post(url, body, null, null);
    }

    public HttpResponse post(String url, String body, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return authenticatedRequest.post(this.starlingBankEndpoint + url, body, queryParameters, requestHeaders);
    }

    public HttpResponse putSigned(String url) throws StarlingBankRequestException {
        return putSigned(url, null);
    }

    public HttpResponse putSigned(String url, String body) throws StarlingBankRequestException {
        return putSigned(url, body, null, null);
    }

    public HttpResponse putSigned(String url, String body, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        if (signedRequest == null) {
            throw SignatureException.notConfiguredException();
        }

        return signedRequest.put(this.starlingBankEndpoint + url, body, queryParameters, requestHeaders);
    }

    public HttpResponse put(String url) throws StarlingBankRequestException {
        return put(url, null);
    }

    public HttpResponse put(String url, String body) throws StarlingBankRequestException {
        return put(url, body, null, null);
    }

    public HttpResponse put(String url, String body, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return authenticatedRequest.put(this.starlingBankEndpoint + url, body, queryParameters, requestHeaders);
    }


    public HttpResponse delete(String url) throws StarlingBankRequestException {
        return delete(url, null);
    }

    public HttpResponse delete(String url, Map<String, String> queryParameters) throws StarlingBankRequestException {
        return delete(url, queryParameters, null);
    }

    public HttpResponse delete(String url, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        return authenticatedRequest.delete(this.starlingBankEndpoint + url, queryParameters, requestHeaders);
    }

    public HttpResponse deleteSigned(String url) throws StarlingBankRequestException {
        return deleteSigned(url, null);
    }

    public HttpResponse deleteSigned(String url, Map<String, String> queryParameters) throws StarlingBankRequestException {
        return deleteSigned(url, queryParameters, null);
    }

    public HttpResponse deleteSigned(String url, Map<String, String> queryParameters, Map<String, String> requestHeaders) throws StarlingBankRequestException {
        if (signedRequest == null) {
            throw SignatureException.notConfiguredException();
        }

        return signedRequest.delete(this.starlingBankEndpoint + url, queryParameters, requestHeaders);
    }
}
