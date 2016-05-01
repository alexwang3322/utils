


public class ThreadPoolUtil {

    public static Executor singleTaskQueue = Executors.newSingleThreadExecutor();

    public static void enque(Runnable r) {
	singleTaskQueue.execute(r);
    }    

}


