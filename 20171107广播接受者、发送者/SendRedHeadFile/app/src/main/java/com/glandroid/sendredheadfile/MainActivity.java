package com.glandroid.sendredheadfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 中央发送一个红头文件，文件是一级一级往下传达的
     *
     * @param view
     */
    public void click(View view) {
        Intent intent = new Intent();
        intent.setAction("com.glandroid.sendredheadfile.BTNM");
        ReporterReceiver receiver = new ReporterReceiver();
        sendOrderedBroadcast(intent, null, receiver, null, 1, "给每个农村户口补贴10000块钱", null);
    }
}
