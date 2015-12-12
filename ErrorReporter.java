package alex.demo.common.utils;

/**
 * Created by alex on 15/12/12.
 */
public class ErrorReporter implements Thread.UncaughtExceptionHandler{

    private static ErrorReporter mInstanceSingleton;

    public static ErrorReporter getInstance(){
        if(mInstanceSingleton==null){
            mInstanceSingleton = new ErrorReporter();
        }
        return mInstanceSingleton;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

    }

    /**
     *
     * @see {@code facebook} NodexBaseActivity.java
     *
     *  protected void onStart()
     {
     int i = Logger.a(2, LogEntry.EntryType.LIFECYCLE_ACTIVITY_START, 637534221);
     super.onStart();
     ErrorReporter.getInstance().putCustomData("app_backgrounded", "false");
     Logger.a(2, LogEntry.EntryType.LIFECYCLE_ACTIVITY_END, -1417503180, i);
     }

     protected void onStop()
     {
     int i = Logger.a(2, LogEntry.EntryType.LIFECYCLE_ACTIVITY_START, 2092256564);
     super.onStop();
     ErrorReporter.getInstance().putCustomData("app_backgrounded", "true");
     Logger.a(2, LogEntry.EntryType.LIFECYCLE_ACTIVITY_END, 288312968, i);
     }
     * */
    public void putCustomData(String key, String value){

    }
}
