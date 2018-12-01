package com.totalo.moreinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class contextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);
        TextView tile = findViewById(R.id.title);
        TextView main = findViewById(R.id.main);
        Info info = (Info)getIntent().getSerializableExtra("main");
        tile.setText(info.getTitle());
        main.setText(Html.fromHtml(info.getBrief()));
        main.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
