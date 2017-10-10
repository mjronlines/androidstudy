package com.glandroid.phone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private EditText mBt_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 加载布局
        setContentView(R.layout.activity_main);
        // 1.寻找关心的控件
        mBt_phone = (EditText) findViewById(R.id.et_phone);
        Button bt_dail = (Button) findViewById(R.id.bt_dail);
        bt_dail.setOnClickListener(new MyButtonListener());
    }

    public void callPhone() {
        // 2.当用户点击按钮的时候获取里面的电话号码
        String phone =  mBt_phone.getText().toString().trim();

        if ("".equals(phone)) {
            Toast.makeText(MainActivity.this,"电话号码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            // 1.创建一个意图对象
            Intent intent = new Intent();
            // 2.设置动作
            intent.setAction(Intent.ACTION_CALL);
            // 3.指定动作的数据
            intent.setData(Uri.parse("tel://" + phone));
            // 4.开启一个界面，根据程序员指定的行为来做事情
            startActivity(intent);
        }
    }

    private class MyButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
            } else {
                callPhone();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhone();
            } else {
                // Permission Denied
                Toast.makeText(MainActivity.this,"Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
