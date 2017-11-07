package com.glandroid.sdstatusreceiver;

import android.Manifest;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        performCodeWithPermission("接收短信和发送短信权限申请", new PermissionCallback() {
            @Override
            public void hasPermission() {

            }

            @Override
            public void noPermission() {

            }
        }, Manifest.permission.RECEIVE_SMS, Manifest.permission.SEND_SMS);
    }
}
