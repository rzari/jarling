package org.jarling.http;

import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
class HttpRequest {

    private final RequestMethod requestMethod;
    private final String url;
    private final HttpParameter[] httpParameters;
    private final Map<String, String> requestHeaders;
    private final String body;
    private static final HttpParameter[] EMPTY_PARAMETER = new HttpParameter[0];

    public HttpRequest(RequestMethod requestMethod, String url, HttpParameter[] httpParameters, Map<String, String> requestHeaders, String body){
        this.requestMethod = requestMethod;
        this.requestHeaders = requestHeaders;
        this.body = body;
        if (this.requestMethod != RequestMethod.POST && httpParameters != null && httpParameters.length != 0){
            this.url = url + "?" + HttpParameter.encodeParameters(httpParameters);
            this.httpParameters = EMPTY_PARAMETER;
        }
        else{
            this.url = url;
            this.httpParameters = httpParameters;
        }
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public String getUrl() {
        return url;
    }

    public HttpParameter[] getHttpParameters() {
        return httpParameters;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HttpRequest that = (HttpRequest) o;

        if (requestMethod != that.requestMethod) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(httpParameters, that.httpParameters)) return false;
        return requestHeaders != null ? requestHeaders.equals(that.requestHeaders) : that.requestHeaders == null;

    }

    @Override
    public int hashCode() {
        int result = requestMethod != null ? requestMethod.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(httpParameters);
        result = 31 * result + (requestHeaders != null ? requestHeaders.hashCode() : 0);
        return result;
    }
}
