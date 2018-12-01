package com.totalo.caulter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText edt1;
    private EditText edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(edt1.getText().toString());
                int num2 = Integer.parseInt(edt2.getText().toString());
                Intent intent = new Intent(MainActivity.this,resultActivity.class);
                int sum = num1+num2;
                intent.putExtra("sum",sum);
                startActivity(intent);
            }
        });
    }
}
