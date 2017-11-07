package com.glandroid.sdstatusreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SDStatusReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
            Toast.makeText(context,"sd卡被挂载，微信头像可以使用了", Toast.LENGTH_SHORT).show();
        } else if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)){
            Toast.makeText(context,"sd卡被卸载，微信头像不能使用了", Toast.LENGTH_SHORT).show();
        }
    }
}
