package matrix.lib;

import java.io.IOException;
import java.net.*;

public class HTTPData {
    String base_url;
    String full_url;
    String hostname = "Generic";

    public HTTPData(String url) {
        this.base_url = url;
    }

    public void setData(long timestamp, Operation op) {
        StringBuilder url = new StringBuilder();

        url.append(this.base_url)
                .append("?")
                .append("device=")
                .append(this.hostname)
                .append("&")
                .append("timestamp=")
                .append(timestamp)
                .append("&")
                .append("operation=")
                .append(op);

        this.full_url = url.toString();
    }

    public void setName(String name) {
        this.hostname = name;
    }

    public boolean sendData(){
        URL url;
        HttpURLConnection con;
        int responseCode = 0;

        try {
            url = new URL(this.full_url);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            responseCode = con.getResponseCode();
        } catch (MalformedURLException e) {
            System.out.println("The URL where to send message is malformed");
        } catch (IOException e) {
            System.out.println("HTTP open connection/request has failed");
        }

        if (responseCode != 200) {
            return false;
        }
        return true;
    }
}
