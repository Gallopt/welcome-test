package com.capim.welcome;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private long currentTime = System.currentTimeMillis();
    private TextView info;
    private SharedPreferences.Editor editor;

    @SuppressLint({"SetTextI18n", "CommitPrefEdits"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.tv_info);
        Button btn = findViewById(R.id.btn_click);

        sharedPreferences();
        SharedPreferences preferences = getSharedPreferences("date", MODE_PRIVATE);
        long saveTime = preferences.getLong("time", Long.parseLong("0"));
//        Log.i("saveTime", String.valueOf(saveTime));
        final long timeGap = (currentTime - saveTime) / (1000 * 60 * 60 * 24);//换算为天
//         判断是否为第一次启动app
        final boolean isfirst = preferences.getBoolean("First", true);
        editor = preferences.edit();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFirst(isfirst, timeGap);
            }
        });
    }

    public void isFirst(boolean first, long gap) {
        if (first) {
            info.setText("欢迎初次使用");
            editor.putBoolean("First", false);
            editor.apply();
        } else if (gap >= 3) {
            info.setText("好久不见，欢迎再次使用");
        } else {
            info.setText("欢迎经常使用");
        }
    }

    public void sharedPreferences() {
        SharedPreferences.Editor data = getSharedPreferences("date", 0).edit();
        data.putLong("time", currentTime);
        data.apply();
        Log.w("MainActivity", String.valueOf(currentTime));
//        Toast.makeText(this, String.valueOf(currentTime), Toast.LENGTH_LONG).show();
    }
}
