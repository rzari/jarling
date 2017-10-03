package org.jarling.http;

import org.jarling.exceptions.StarlingBankRequestException;

import java.util.Map;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface HttpClient {

    HttpResponse get(String url) throws StarlingBankRequestException;
    HttpResponse get(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException;
    HttpResponse get(String url, HttpParameter[] httpParameters, Map<String,String> requestHeaders) throws StarlingBankRequestException;
    HttpResponse post(String url) throws StarlingBankRequestException;
    HttpResponse post(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException;
    HttpResponse post(String url, HttpParameter[] httpParameters, Map<String,String> requestHeaders) throws StarlingBankRequestException;
    HttpResponse put(String url) throws StarlingBankRequestException;
    HttpResponse put(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException;
    HttpResponse put(String url, HttpParameter[] httpParameters, Map<String,String> requestHeaders) throws StarlingBankRequestException;
    HttpResponse delete(String url) throws StarlingBankRequestException;
    HttpResponse delete(String url, HttpParameter[] httpParameters) throws StarlingBankRequestException;
    HttpResponse delete(String url, HttpParameter[] httpParameters, Map<String,String> requestHeaders) throws StarlingBankRequestException;

}
