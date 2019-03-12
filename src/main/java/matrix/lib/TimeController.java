package matrix.lib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeController {
    private long start = 0;
    private long finish = 0;
    private String name = "Time";

    public TimeController(){}

    public void snapStart() {
        this.start = new Date().getTime();
    }

    public void snapFinish() {
        this.finish = new Date().getTime();
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStart() {
        return this.start;
    }

    public long getFinish() {
        return this.finish;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSSS");
        StringBuilder message = new StringBuilder();
        message.append(this.name)
                .append("\n")
                .append("Start device time: ")
                .append(dateFormat.format(new Date(this.start)))
                .append("\n")
                .append("Finish device time: ")
                .append(dateFormat.format(new Date(this.finish)))
                .append("\n")
                .append("Estimated time: ")
                .append((float) (finish - start) / 1000)
                .append("s")
                .append("\n");

        return message.toString();
    }

}
