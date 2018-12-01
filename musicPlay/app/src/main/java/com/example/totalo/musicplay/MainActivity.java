package com.example.totalo.musicplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button btn_open;
    private boolean status=false;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent=new Intent(this,MusicService.class);
        btn_open= (Button) findViewById(R.id.btn_open);
        btn_open.setText("播放 ");
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!status){
                    btn_open.setText("暂停");
                    startService(intent);//调用onCreate的方法
                    status=true;
                }else{
                    btn_open.setText("播放");
                    stopService(intent);//调用onDestory方法
                    status=false;
                }
            }
        });
    }
}
