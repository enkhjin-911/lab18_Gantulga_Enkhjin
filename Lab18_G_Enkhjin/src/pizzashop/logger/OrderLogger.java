package pizzashop.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderLogger {
    private static OrderLogger instance;
    private List<String> history = new ArrayList<>();
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Private constructor — гаднаас үүсгэхийг хориглоно
    private OrderLogger() {}

    // Thread-safe getInstance
    public static synchronized OrderLogger getInstance() {
        if (instance == null) {
            instance = new OrderLogger();
        }
        return instance;
    }

    public void log(String event) {
        String time = LocalDateTime.now().format(fmt);
        String line = "[" + time + "] " + event;
        history.add(line);
        System.out.println(line);
    }

    public List<String> getHistory() { return history; }
    public int size()                { return history.size(); }
}
