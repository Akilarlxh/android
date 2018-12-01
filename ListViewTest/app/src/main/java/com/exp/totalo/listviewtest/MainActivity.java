package com.exp.totalo.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple","Banana","Orange","Watermelon","Pear",
    "Grape","Pineapple","Strawberry","Cherry","Mango","Apple","Banana","Orange","Watermelon","Pear",
            "Grape","Pineapple","Strawberry","Cherry","Mango"};

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void  initFruits(){
        for(int i = 0;i<8;i++){
            Fruit apple = new Fruit("1",R.drawable.ic_launcher_background);
            fruitList.add(apple);
            Fruit ball = new Fruit("12",R.drawable.ic_launcher_background);
            fruitList.add(ball);
            Fruit bn = new Fruit("122",R.drawable.ic_launcher_background);
            fruitList.add(bn);

        }
    }
}
