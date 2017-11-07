package com.glandroid.dangyuan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "我在学习马列主义", Toast.LENGTH_SHORT).show();
        String money = intent.getStringExtra("money");
        System.out.println("我领到了：" + money);
    }
}
