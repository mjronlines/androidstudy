package com.glandroid.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // 当界面被创建时调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate");
    }

    // 应用程序界面用户可见时调用
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    // 应用程序界面获得焦点时调用
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    // 当界面再次可见时被调用
    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }

    // 界面失去焦点时调用
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    // 当界面不可见时调用
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");
    }

    // 当界面被销毁时调用
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    public void click(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
