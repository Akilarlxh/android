package com.exp.totalo.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","This id is "+getTaskId());
        setContentView(R.layout.second_layout);
        Button buuton2 = (Button) findViewById(R.id.button_2);
        buuton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                //startActivity(intent);
                SecondActivity.actionStart(FirstActivity.this,"date1","data2");
            }

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }

    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }
}
