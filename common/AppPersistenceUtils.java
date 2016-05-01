


public class AppPersistenceUtils {
    // 在华为荣耀机器上，当应用退到后台（home键），reciver还会收到定时的消息
    // alarm cycle a receiver	
    public static void alarmCycle(Context context) {
	AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
	PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, new Intent(this, MyAndroidReceiver.class), PendingIntent.FLAG_CANCEL_CURRENT);
	alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				System.currentTimeMillis() + 1000 * 60,
				1000 * 60 * 60,//1 hour
				pendingIntent);
    }

    // 需要测试此方法的可行性
    public static void makeForeground(Service service) {
	Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notification = new Notification.Builder(service).setContentTitle("hi").build();
        }else{
            notification = new Notification();
        }
        PendingIntent contentIntent = PendingIntent.getActivity(service, 0,
                new Intent(service, MainActivity.class), 0);
        notification.contentIntent = contentIntent;
        service.startForeground(0, notification);
    }    

}
