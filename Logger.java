package alex.demo.common.utils;

/**
 * Created by alex on 15/12/12.
 */
public class Logger {

    private static final ThreadLocal<LogEntry> f = new Logger.Build();

    final static class Build extends ThreadLocal<LogEntry> {
        @Override
        protected LogEntry initialValue() {
            return new LogEntry();
        }
    }
    // error
    public static void e(){
        // ...
    }
    // debug
    public static void d(){
        // ...
    }
    // verbse
    public static void v(){

    }
}
