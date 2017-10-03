package org.jarling.http;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class HttpParameter {

    private String name;
    private String value;

    public HttpParameter(String name, String value){
        this.name = name;
        this.value = value;
    }

    public HttpParameter(String name, Integer value){
        this.name = name;
        this.value = String.valueOf(value);
    }

    public HttpParameter(String name, Long value){
        this.name = name;
        this.value = String.valueOf(value);
    }

    public HttpParameter(String name, Double value){
        this.name = name;
        this.value = String.valueOf(value);
    }

    public HttpParameter(String name, BigDecimal value){
        this.name = name;
        this.value = String.valueOf(value);
    }

    public HttpParameter(String name, Boolean value){
        this.name = name;
        this.value = String.valueOf(value);
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String encodeParameters(HttpParameter[] httpParameters){
        if (null == httpParameters) { return ""; }

        StringBuilder paramBuff = new StringBuilder();

        for (int i = 0; i < httpParameters.length; i++){
            try {
                paramBuff.append(URLEncoder.encode(httpParameters[i].getName(), "UTF-8"))
                        .append("=")
                        .append(URLEncoder.encode(httpParameters[i].getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (i != httpParameters.length - 1){
                paramBuff.append("&");
            }
        }
        return paramBuff.toString();
    }

    public static List<HttpParameter> decodeParameters(String queryParameters){
        List<HttpParameter> result = new ArrayList<>();
        for (String paramPair: queryParameters.split("&")){
            String[] keyval = paramPair.split("=", 2);
            if(keyval.length == 2){
                try {
                    String name = URLDecoder.decode(keyval[0], "UTF-8");
                    String value = URLDecoder.decode(keyval[1], "UTF-8");
                    if (!name.equals("") && !value.equals("")){
                        result.add(new HttpParameter(name, value));
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HttpParameter that = (HttpParameter) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
