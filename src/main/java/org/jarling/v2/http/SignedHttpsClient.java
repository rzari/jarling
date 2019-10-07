package org.jarling.v2.http;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class SignedHttpsClient extends BasicHttpsClient {
    @Getter @Setter @NonNull
    private String accessToken;

    @Getter @Setter @NonNull
    private PrivateKey privateKey;

    @Getter @Setter @NonNull
    private UUID publicKeyUid;

    @Getter @Setter @NonNull
    private CertificateType keyType;

    @Override
    protected Map<String, String> getAuthorizationHeaders(HttpRequest request) {
        Map<String, String> headers = new HashMap<>();
        Instant date = Instant.now();
        String digest = getDigest(request);
        headers.put("Date", date.toString());
        headers.put("Digest", digest);
        headers.put("Authorization",
            "Bearer " + accessToken
            + ";Signature keyid=\""
            + publicKeyUid
            + "\",algorithm=\""
            + keyType.getStarlingAlgorithm()
                + "\",headers=\""
                + "(request-target) Date Digest"
                + "\",signature=\""
                + getSignature(request, date, digest)
                + "\""
        );
        return headers;

    }

    private String getSignature(HttpRequest request, Instant date, String digest) {
        try {
            Signature instance = Signature.getInstance(keyType.getJavaAlgorithm());
            instance.initSign(privateKey);
            instance.update(getSignatureMessage(request, date, digest).getBytes());
            return Base64.getEncoder().encodeToString(instance.sign());
        } catch (SignatureException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private String getSignatureMessage(HttpRequest request, Instant date, String digest) {
        try {
            String path = request.getFullUrl().getPath();
            String method = request.getRequestMethod().getValue().toLowerCase();
            return "(request-target): " + method + " " + path + "\nDate: " + date + "\nDigest: " + digest;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getDigest(HttpRequest request) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            String body = request.getBody() != null
                ? request.getBody()
                : "";
            byte[] payload = body.getBytes(StandardCharsets.UTF_8);
            return Base64.getEncoder().encodeToString(messageDigest.digest(payload));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
