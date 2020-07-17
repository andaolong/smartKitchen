package com.example.smartKitchen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartKitchen.huaweiHttp.DeviceController;

public class myRefrigeratorFoods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_refrigerator_foods);
        DeviceController deviceController = new DeviceController("08f56a11b38025802f99c01e5292c354","5f056b6969c46102cb1986e0_20200714");
        deviceController.getShadow();
    }
}