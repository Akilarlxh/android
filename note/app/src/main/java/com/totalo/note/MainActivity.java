package com.totalo.note;


import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Note> noteList = new ArrayList<Note>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        NoteAdapter adapter = new NoteAdapter(MainActivity.this,R.layout.listcontent,noteList);
        ListView lsi = findViewById(R.id.list);
        lsi.setAdapter(adapter);
    }

    private void init(){

        for(int i = 0;i<10;i++) {
            Note note = new Note();
            note.setTitle("测试");
            note.setTime("2018/9/9");
            note.setAdd("123");
            noteList.add(note);
        }
    }
}
