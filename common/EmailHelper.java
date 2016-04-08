

public class EmailHelper {

    public static void send(Context context, String address, String subject, CharSequeue body) {
	Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/html");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{address});
        if (!TextUtils.isEmpty(subject)) {
            intent.putExtra("android.intent.extra.SUBJECT", subject);
        }
        if (!TextUtils.isEmpty(body)) {
            intent.putExtra("android.intent.extra.TEXT", body);
        }
        try {
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.send_mail)));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, R.string.no_email_client, 0).show();
        }	
    }

}
