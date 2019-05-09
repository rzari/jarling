package org.jarling;

/**
 *
 * Enum representing the starling bank API versions
 *
 */
public enum StarlingBankApiVersion {
    V1("/api/v1"),
    V2("/api/v2");

    private final String path;

    StarlingBankApiVersion(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
