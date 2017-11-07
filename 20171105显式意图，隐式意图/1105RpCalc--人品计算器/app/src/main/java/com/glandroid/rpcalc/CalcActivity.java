package com.glandroid.rpcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_result = (TextView) findViewById(R.id.tv_result);

        try {
            Intent intent = getIntent();
            int sex = intent.getIntExtra("sex", 0);
            System.out.println("sex:" + sex);
            String name = intent.getStringExtra("name");
            byte[] result;
            switch (sex) {
                case Sex.MAIL:
                    result = name.getBytes();
                    showArray(result, Sex.MAIL);
                    break;
                case Sex.FEMAIL:
                    result = name.getBytes();
                    showArray(result, Sex.FEMAIL);
                    break;

                default:
                    result = name.getBytes();
                    showArray(result, Sex.UNKNOW);
                    break;
            }
            int score = 0;
            for (byte b  : result) {
                score += b & 0xff;
            }
            score = Math.abs(score) % 100;
            tv_name.setText(name);
            tv_result.setText("人品值为：" + score);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showArray(byte[] arr,int sex) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += sex;
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
