package org.jarling;

import com.google.gson.Gson;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.accounts.AccountBalance;
import org.jarling.v2.ApiService;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class StarlingExceptionTests {
    private static final Gson gson = new Gson();
    private ApiService goodApiService = null;

    @Before
    public void setUp(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./cfg/sandbox.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.goodApiService = new ApiService(StarlingBankEnvironment.SANDBOX, properties.getProperty("starling.access.token"));
    }

    @Test
    public void testStarlingBadRequestException(){
        try {
            gson.fromJson(goodApiService.get("%").asString(), AccountBalance.class);
        } catch (StarlingBankRequestException e) {
            assertEquals(400, e.getStatusCode());
            assertEquals("Bad Request", e.getErrorMessage());
            assertEquals("Something was wrong with the request made, check the request to address the error included in the response", e.getErrorDescription());
        }
    }

    @Test
    public void testStarlingNotFoundException(){
        try {
            gson.fromJson(goodApiService.get("/this/doesnt/exist").asString(), AccountBalance.class);
        } catch (StarlingBankRequestException e) {
            assertEquals(404, e.getStatusCode());
            assertEquals("Not Found", e.getErrorMessage());
            assertEquals("The requested resource does not exist", e.getErrorDescription());
        }
    }

    @Test
    public void testStarlingUnauthorizedException(){
        try {
            goodApiService = new ApiService(StarlingBankEnvironment.SANDBOX, "lol");
            gson.fromJson(goodApiService.get("/accounts/balance").asString(), AccountBalance.class);
        } catch (StarlingBankRequestException e) {
            assertEquals(403, e.getStatusCode());
            assertEquals("Forbidden", e.getErrorMessage());
            assertEquals("Your authentication failed, usually due to the access token being expired or an attempt to access a resource beyond the scope of the token", e.getErrorDescription());
        }
    }

}
