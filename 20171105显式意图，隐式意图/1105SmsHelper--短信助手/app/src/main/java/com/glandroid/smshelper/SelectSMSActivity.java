package com.glandroid.smshelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectSMSActivity extends AppCompatActivity {

    private ListView lv;
    private String[] smscontents = {"羊年大吉", "羊年happy", "哈哈哈，新年快乐", "新春快乐", "天天发财", "彩票中奖"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sms);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_textview, smscontents));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = smscontents[position];

                Intent data = new Intent();
                data.putExtra("text", text);
                setResult(0, data);
                finish();
            }
        });
    }
}
