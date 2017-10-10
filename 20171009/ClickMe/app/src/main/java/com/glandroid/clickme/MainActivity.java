package com.glandroid.clickme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity/* implements View.OnClickListener */{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置内容UI，把界面加载出来
        setContentView(R.layout.activity_main);
        // 1.找到界面上按钮
//        Button bt_click = (Button) findViewById(R.id.bt_click);
        // 2.点击按钮的时候触发相应点击事件
        /*bt_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("hhh,我被点击了");
                // context 默认的上下文，代表的是吐司显示在哪个界面上
                Toast.makeText(MainActivity.this, "hhh, 我被点击了", Toast.LENGTH_SHORT).show();
            }
        });*/
        // 第二种点击监听实现方式
//        bt_click.setOnClickListener(new MyClickListener());

        // 第三种点击监听实现方式
//        bt_click.setOnClickListener(this);
    }

    // 第三种点击监听实现方式
    /*@Override
    public void onClick(View v) {
        System.out.println("hhh,我被点击了");
        Toast.makeText(this,"hhh,我被点击了", Toast.LENGTH_SHORT).show();
    }*/

    // 第二种点击监听实现方式
    /*class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            System.out.println("hhh,我被点击了");
            Toast.makeText(MainActivity.this,"hhh,我被点击了", Toast.LENGTH_SHORT).show();
        }
    }*/

    public void click(View view) {
        System.out.println("hhh,我被点击了");
        Toast.makeText(this,"hhh,我被点击了", Toast.LENGTH_SHORT).show();
    }
}
