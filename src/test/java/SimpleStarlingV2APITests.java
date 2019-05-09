import org.jarling.StarlingBankEnvironment;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.Starling;
import org.jarling.v2.models.Identity;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SimpleStarlingV2APITests {
    private Starling starling;

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

    @Test
    public void testIdentity() {
        try {
            Identity identity = starling.getTokenIdentity();
            assertTrue(identity.getCustomerUid().matches(TestUtils.regexUUID));
        } catch (StarlingBankRequestException se) {
            fail("StarlingBankRequestException: " + se.getReason() + ":" + se.getErrorDescription());
        }
    }
}
