package org.jarling;

/**
 *
 * Enum representing the starling bank environment endpoints
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum StarlingBankEnvironment {
    PRODUCTION("https://api.starlingbank.com"),
    SANDBOX("https://api-sandbox.starlingbank.com");

    private final String path;

    StarlingBankEnvironment(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
