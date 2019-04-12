package com.capim.welcome;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest  {
    private TextView info;
    private Button btn;
    private MainActivity mainActivity;

    public MainActivityTest(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Before
    public void setUp() throws Exception {
        info = mainActivity.findViewById(R.id.tv_info);
        btn = mainActivity.findViewById(R.id.btn_click);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testisFirst() {
    String result=info.toString();
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mainActivity.isFirst(false,2);
        }
    });
    assertEquals("欢迎经常使用",result);
    }

    @Test
    public void sharedPreferences() {
    }
}