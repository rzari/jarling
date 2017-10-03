package org.jarling.exceptions;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class StarlingBankRequestException extends Exception {

    private final int statusCode;
    private final String reason;
    private final String errorMessage;
    private final String errorDescription;

    public StarlingBankRequestException(int statusCode, String reason, String errorMessage, String errorDescription){
        this.statusCode = statusCode;
        this.reason = reason;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReason() {
        return reason;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

}
