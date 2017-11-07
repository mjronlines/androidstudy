package com.glandroid.lifecycletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private SharedPreferences sp;
//    private EditText et_content;
    private TextView tv_blood;
    private int blood = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_game);
//        sp = getSharedPreferences("config", MODE_PRIVATE);
//        et_content = (EditText) findViewById(R.id.et_content);
//        et_content.setText(sp.getString("content", ""));

        tv_blood = (TextView) findViewById(R.id.tv_blood);
    }

    public void click(View view) {
        blood -= 7;
        if (blood > 0) {
            tv_blood.setText("剩余生命值：" + blood);
        } else {
            tv_blood.setText("K.O. 你胜利了");
        }
    }

    @Override
    protected void onStart() {
        System.out.println("继续播放视频");
        // 继续播放
        super.onStart();
    }

    @Override
    protected void onStop() {
        System.out.println("暂停播放视频，记录当前播放的位置");
        // 记录
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        String content =  et_content.getText().toString().trim();
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("content", content);
//        editor.commit();
    }
}
