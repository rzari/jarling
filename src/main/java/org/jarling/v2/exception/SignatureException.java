package org.jarling.v2.exception;

import org.jarling.exceptions.StarlingBankRequestException;

public class SignatureException extends StarlingBankRequestException {
    public SignatureException(String message) {
        super(0, message, null, null);
    }

    public static SignatureException notConfiguredException() {
        return new SignatureException("Signed requests have not been configured");
    }
}
