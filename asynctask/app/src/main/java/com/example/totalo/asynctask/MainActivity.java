package com.example.totalo.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private static ProgressBar pb;
    private static TextView tv1;
    private MyAsyncTask mtask;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button)findViewById(R.id.bt1);
        pb = (ProgressBar)findViewById(R.id.pb);
        tv1 = (TextView)findViewById(R.id.tv1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实例化内部类MyAsyncTask
                mtask = new MyAsyncTask();
                //启动异步加载
                mtask.execute();
            }
        });
    }

    @Override
    protected void onPause() {
        //判断MyAsyncTask不为空，且状态是运行状态
        if(mtask!=null && mtask.getStatus() == AsyncTask.Status.RUNNING ){
            //AsyncTask标记为cancel状态，并不是真正地取消线程的执行。
            mtask.cancel(true);
        }
        super.onPause();
    }
    //创建一个异步加载内部类，继承AsyncTask
    public static class MyAsyncTask extends AsyncTask<Void,Integer,Void>{
        //实现doInBackground方法
        @Override
        protected Void doInBackground(Void... voids) {
            //循环产生下载的效果
            for(int i=0;i<=100;i++){
                //判断是否被标记为true
                if(isCancelled()){
                    //被标记则中断循环
                    break;
                }
                //调用周期的下一个方法，传值进度
                publishProgress(i);
                //睡眠50毫秒，模拟下载
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //展示进度
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //判断是否被标记，如果被标记则终止
            if(isCancelled()){
                return;
            }
            //进度赋值给Pd
            pb.setProgress(values[0]);
            //tv1显示进度
            tv1.setText("Loading..."+values[0]+"%");
        }
    }

}