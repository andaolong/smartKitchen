package com.example.smartKitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

import com.example.smartKitchen.huaweiHttp.DeviceController;

public class SmartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart);

        TextView tv_bmi = findViewById(R.id.tv_bmi);
        TextView tv_food = findViewById(R.id.tv_food);
        ConstraintLayout food1 = findViewById(R.id.food1);
        ConstraintLayout food2 = findViewById(R.id.food2);
        ConstraintLayout food3 = findViewById(R.id.food3);
        //实例化一个DeviceController类然后调用它的方法获取设备影子
        DeviceController deviceController = new DeviceController("08f56a11b38025802f99c01e5292c354", "5f056b6969c46102cb1986e0_20200714");
        deviceController.getShadow();
        String allFood = DeviceController.b.getString("AllFood");
        //获取不到最新的值就一直获取
        while (allFood == null) {
            allFood = DeviceController.b.getString("AllFood");
        }
        //用完重置，避免获取到过期值
        DeviceController.b.clear();
        tv_food.setText(allFood);

    }
}