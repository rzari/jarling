package org.jarling.v2.http;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter @Setter
public class BearerHttpsClient extends BasicHttpsClient {
    @NonNull
    private String accessToken;

    @Override
    protected Map<String, String> getAuthorizationHeaders(HttpRequest request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + accessToken);
        return headers;
    }
}
