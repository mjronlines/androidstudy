package com.glandroid.screenreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.SCREEN_ON".equals(action)) {
            Toast.makeText(context, "屏幕解锁了", Toast.LENGTH_SHORT).show();
            System.out.println("屏幕解锁了");
        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
            Toast.makeText(context, "屏幕锁定了，可以做清理内存的操作", Toast.LENGTH_SHORT).show();
            System.out.println("屏幕锁定了，可以做清理内存的操作");
        }
    }
}
