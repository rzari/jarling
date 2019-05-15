package org.jarling.v2;

import org.jarling.StarlingBankEnvironment;
import org.jarling.exceptions.StarlingBankRequestException;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.fail;

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
    }

    public void failOnStarlingBankException(StarlingBankRequestException se) {
        fail("StarlingBankRequestException: " + se.getReason() + ":" + se.getErrorDescription());
    }

}
