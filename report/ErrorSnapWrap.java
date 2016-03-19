
/**
	处理，发送逻辑异常，捕获的异常到服务器，以统计
**/
public class ErrorSnapWrapper {

   public static void notify(Throwable throwable) {
	// 发送一个exception到服务器.	
   	ErrorSnapImpl.getInstance().notify(throwable.toString());
   }

   class Error {
	Throwable mThrowable;
	public Error(Throwable t) {
		mThrowable = t;
	}
	
   }
}
