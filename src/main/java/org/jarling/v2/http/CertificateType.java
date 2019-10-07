package org.jarling.v2.http;

public enum CertificateType {
    RSA {
        public String getStarlingAlgorithm() {
            return "rsa-sha512";
        }

        public String getJavaAlgorithm() {
            return "SHA512withRSA";
        }
    },

    ECDSA {
        public String getStarlingAlgorithm() {
            return "rsa-sha512";
        }

        public String getJavaAlgorithm() {
            return "SHA512withRSA";
        }
    };

    public abstract String getStarlingAlgorithm();
    public abstract String getJavaAlgorithm();

    public static CertificateType fromString(String string) {
        switch (string) {
            case "RSA":
                return RSA;
            case "ECDSA":
                return ECDSA;
            default:
                throw new RuntimeException();
        }
    }
}
