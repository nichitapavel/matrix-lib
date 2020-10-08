package matrix.lib;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


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

        // Mock a HttpURLConnection or HTTPDataTest or URL object
        // When method sendData() is invoked
        // Return response code 200
        //
        // When req.sendData() a new HttpURLConnection is returned by
        // URL.openConnection() and the getResponse() is executed by it
        // and not by the mocked HttpURLConnection...
        // study more...
        HttpURLConnection httpURLConnectionMock = Mockito.mock(HttpURLConnection.class);

        TimeController tc = new TimeController();
        tc.snapStart();

        req.setData(tc.getStart(), Operation.AS);

        try {
            when(httpURLConnectionMock.getResponseCode()).thenReturn(200);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // TODO the server must be running, learn tu make mocks you moth.....
        assertTrue(req.sendData());
        try {
            verify(httpURLConnectionMock.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
