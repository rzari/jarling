package org.jarling.http;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum RequestMethod {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private final String value;

    RequestMethod(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }
}
