A basic android utilty <a href="https://travis-ci.org/alexwang3322/utils">
<img src="https://travis-ci.org/alexwang3322/utils.svg?branch=master" alt="build status" class="build-status"></a>
============================

1.facebook update "ACRA" libaray , so there is quite lot thing could learn . 	
such as   		
asList =  String[] ALL_PERMISSIONS_SAMPLES = 
new String[]{"android.permission.READ_CALENDAR",
      "android.permission.CAMERA",
      "android.permission.READ_CONTACTS",
      "android.permission.ACCESS_FINE_LOCATION",
      "android.permission.RECORD_AUDIO",
      "android.permission.READ_PHONE_STATE", 
      "android.permission.BODY_SENSORS",
      "android.permission.SEND_SMS", 
      "android.permission.READ_EXTERNAL_STORAGE"}; 

(CrashTimeDataCollector.java)
if (VERSION.SDK_INT >= 23 && 
asList.contains(ReportField.RUNTIME_PERMISSIONS)) {
      errorReporter.put(ReportField.RUNTIME_PERMISSIONS,
      PermissionsReporter.getAppGrantedPermissions(context), crashReportData, writer);
}
