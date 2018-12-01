package com.totalo.activityintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("H", "resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("D","Destory");
    }
}
