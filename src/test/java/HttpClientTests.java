import org.jarling.http.HttpParameter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class HttpClientTests {

    @Test
    public void testEncodeWithNull(){
        assertEquals(HttpParameter.encodeParameters(null), "");
    }

    @Test
    public void testEncodeWithOneParameter(){
        HttpParameter[] httpParameters = new HttpParameter[1];
        httpParameters[0] = new HttpParameter("test", "123456");
        assertEquals(HttpParameter.encodeParameters(httpParameters), "test=123456");
    }

    @Test
    public void testEncodeWithTwoParameter(){
        HttpParameter[] httpParameters = new HttpParameter[2];
        httpParameters[0] = new HttpParameter("test", "123456");
        httpParameters[1] = new HttpParameter("test2", "654321");
        assertEquals(HttpParameter.encodeParameters(httpParameters), "test=123456&test2=654321");
    }
}
