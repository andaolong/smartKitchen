package com.example.smartKitchen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MyInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        //提取用户信息
        SharedPreferences sp = MyInfoActivity.this.getSharedPreferences("user", Context.MODE_PRIVATE);
        float height = sp.getFloat("height",0),
                weight = sp.getFloat("weight",0),
                BMI = sp.getFloat("BMI",0),
                BFR = sp.getFloat("BFR",0);
        TextView textView1 = findViewById(R.id.tv1),
                textView2 = findViewById(R.id.tv2),
                textView3 = findViewById(R.id.tv3),
                textView4 = findViewById(R.id.tv4);
        textView1.setText(String.valueOf(height)+"cm");
        textView2.setText(String.valueOf(weight)+"kg");
        textView3.setText(String.valueOf(BMI));
        textView4.setText(String.valueOf(BFR));
        Button change = findViewById(R.id.bt_change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyInfoActivity.this,ChangeInfoActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SharedPreferences sp = MyInfoActivity.this.getSharedPreferences("user", Context.MODE_PRIVATE);
        float height = sp.getFloat("height",0),
                weight = sp.getFloat("weight",0),
                BMI = sp.getFloat("BMI",0),
                BFR = sp.getFloat("BFR",0);
        TextView textView1 = findViewById(R.id.tv1),
                textView2 = findViewById(R.id.tv2),
                textView3 = findViewById(R.id.tv3),
                textView4 = findViewById(R.id.tv4);
        textView1.setText(String.valueOf(height)+"cm");
        textView2.setText(String.valueOf(weight)+"kg");
        textView3.setText(String.valueOf(BMI));
        textView4.setText(String.valueOf(BFR));
    }
}