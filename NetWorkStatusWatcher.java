package alex.demo.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by alex on 15/12/15.
 */
public class NetWorkStatusWatcher extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")){

        }
    }
}
