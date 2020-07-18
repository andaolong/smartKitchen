package com.example.smartKitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class ChangeInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);
        final EditText editText1 = findViewById(R.id.tv1);
        final EditText editText2 = findViewById(R.id.tv2);
        final EditText editText3 = findViewById(R.id.tv3);

        Button change = findViewById(R.id.bt_change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height = Float.parseFloat(String.valueOf(editText1.getText()));
                float weight = Float.parseFloat(String.valueOf(editText2.getText()));
                float BMI = (weight/((height/100)*(height/100)));
                //保留小数点后两位
                DecimalFormat decimalFormat=new DecimalFormat(".00");
                float BMI2=Float.parseFloat(decimalFormat.format(BMI));
                float BFR = Float.parseFloat(String.valueOf(editText3.getText()));
                //保存用户信息
                SharedPreferences sp = ChangeInfoActivity.this.getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putFloat("height", height);
                editor.putFloat("weight", weight);
                editor.putFloat("BMI", BMI2);
                editor.putFloat("BFR", BFR);
                editor.commit();
                finish();
            }
        });
    }
}