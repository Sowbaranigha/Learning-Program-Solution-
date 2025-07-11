package singleton;

public final class Logger {
    private static final Logger INSTANCE = new Logger();

    private Logger() {
        System.out.println("Logger instance created");
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
