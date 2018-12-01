package com.totalo.moreinfo.bbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.totalo.moreinfo.R;

public class BBSdetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbsdetail);
        TextView title = findViewById(R.id.bbsdetail_header_tv_title);
        TextView user  = findViewById(R.id.bbsdetail_header_tv_user);
        TextView time = findViewById(R.id.bbsdetail_header_tv_time);
        TextView main = findViewById(R.id.bbsdetail_header_tv_content);
        BBSbean bbSbean = (BBSbean) getIntent().getSerializableExtra("context");
        title.setText(bbSbean.getProblem());
        user.setText(bbSbean.getUser());
        time.setText(bbSbean.getFbtime());
        main.setText(bbSbean.getDes());
    }
}
