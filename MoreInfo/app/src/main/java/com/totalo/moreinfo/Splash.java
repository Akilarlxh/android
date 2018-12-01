package com.totalo.moreinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.totalo.moreinfo.Utils.SharePreference;

public class Splash extends AppCompatActivity {
    private boolean isLogin ;
    private SharePreference sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                    Intent intent;
                    if(true){
                        intent = new Intent(getApplicationContext(),MainActivity.class);
                    }else{
                        sp.setStatus();
                        intent = new Intent(getApplicationContext(),LoginActivity.class);
                    }
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
