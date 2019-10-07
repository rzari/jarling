package org.jarling.v2.http;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import org.jarling.http.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.stream.Collectors;

@Value
@ToString(onlyExplicitlyIncluded = true)
class HttpRequest {
    @NonNull RequestMethod requestMethod;
    @NonNull String url;
    Map<String, String> queryParameters;
    Map<String, String> headers;
    String body;

    public URL getFullUrl() throws MalformedURLException {
        return new URL(url + "?" + getQueryString());
    }

    private String getQueryString() {
        if (queryParameters == null || queryParameters.isEmpty()) {
            return "";
        }

        return queryParameters.entrySet().stream()
            .map(HttpRequest::getStringForQueryParameter)
            .collect(Collectors.joining("&"));
    }

    private static String getStringForQueryParameter(Map.Entry<String, String> queryParameter) {
        try {
            return URLEncoder.encode(queryParameter.getKey(), "UTF-8")
                + "="
                + URLEncoder.encode(queryParameter.getValue(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
