package com.exp.totalo.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {




    public static void actionStart(Context context,String newsTitle,String newsContent){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        //获取传入的新闻标题
        String newTitle = getIntent().getStringExtra("news_title");
        //获取传入的新闻内容
        String newsContent = getIntent().getStringExtra("news_content");
        //刷新NesContentFragment界面
        NewsContentFragment newsContentFragment = (NewsContentFragment)
                getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newTitle,newsContent);
    }
}
