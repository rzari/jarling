package org.jarling.v2;

import org.jarling.StarlingBankEnvironment;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.http.CertificateType;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Properties;
import java.util.UUID;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

public abstract class BaseTest {
    protected StarlingBank starling;

    @Before
    public void setUp() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./cfg/sandbox.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.starling = new Starling(StarlingBankEnvironment.SANDBOX, properties.getProperty("starling.access.token"));

        try {
            // Should be in PKCS8 (DER) format
            Path path = Paths.get(properties.getProperty("starling.signing.private-key"));
            String algorithm = properties.getProperty("starling.signing.key-algorithm");
            byte[] privateKeyBytes = Files.readAllBytes(path);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            UUID publicKeyUid = UUID.fromString(properties.getProperty("starling.signing.public-key-uid"));

            this.starling.configureRequestSigning(privateKey, publicKeyUid, CertificateType.fromString(algorithm));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void failOnStarlingBankException(StarlingBankRequestException se) {
        assumeFalse(se.getReason().equals("{\"errors\":[{\"message\":\"endpoint called with non-business account\"}],\"success\":false}\n"));
        assumeFalse(se.getReason().equals("{\"errors\":[{\"message\":\"endpoint called with non-joint account\"}],\"success\":false}\n"));
        fail("StarlingBankRequestException: " + se.getReason() + ":" + se.getErrorDescription());
    }

}
