package alex.demo.common.utils;

/***************************************************
	http://drops.wooyun.org/tips/3812

  有些人认为任何log都不应该在发行版本打印。但是为了app的错误采集，异常反馈，必要的日志还是要被输出的，只要遵循安全编码规范就可以将风险控制在最小范围。

Log.e()/w()/i()：建议打印操作日志

Log.d()/v()：建议打印开发日志

1、敏感信息不应用Log.e()/w()/i(), System.out/err 打印。

2、如果需要打印一些敏感信息建议使用 Log.d()/v()。（前提：release版本将被自动去除）



 * Created by alex on 15/12/12.
 ****************************************************/
public class Logger {

    private static final ThreadLocal<LogEntry> f = new Logger.Build();

    final static class Build extends ThreadLocal<LogEntry> {
        @Override
        protected LogEntry initialValue() {
            return new LogEntry();
        }
    }
    public static void e(){
        // ...
    }

    public static void v(){

    }

    public static LogEntry Build(){
	// 配置 初始化 LogEntry
    }
}
