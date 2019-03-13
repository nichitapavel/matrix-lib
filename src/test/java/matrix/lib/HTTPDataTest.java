package matrix.lib;

import org.junit.*;

import static org.junit.Assert.*;


public class HTTPDataTest {



    @Test
    public void TestConstructor() {
        String base_url = "http://192.168.0.65:5000/message";
        HTTPData req = new HTTPData(base_url);

        // TODO assertion is not portable, maybe using mock is a better option
        assertEquals(base_url, req.base_url);
    }

    @Test
    public void TestsetData() {
        String base_url = "http://192.168.0.65:5000/message";
        HTTPData req = new HTTPData(base_url);
        long timestamp = 1_552_388_559_539L;
        req.setData(timestamp, Operation.AS);


        // TODO the device hostname now is dependent of the implementation, this should be heavily refactored
        String expected = "http://192.168.0.65:5000/message?device=Generic&timestamp=1552388559539&operation=AS";
        assertEquals(expected, req.full_url);
    }

    @Test
    public void TestsendData() {
        String base_url = "http://localhost:5000/message";
        HTTPData req = new HTTPData(base_url);

        TimeController tc = new TimeController();
        tc.snapStart();

        req.setData(tc.getStart(), Operation.AS);

        // TODO the server must be running, learn tu make mocks you moth.....
        assertTrue(req.sendData());

    }
}
