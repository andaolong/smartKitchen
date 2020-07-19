package com.example.smartKitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartKitchen.huaweiHttp.DeviceController;

public class CommandsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commands);

        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
        Button bt3 = findViewById(R.id.bt3);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化一个DeviceController类下发命令
                DeviceController deviceController = new DeviceController("08f56a11b38025802f99c01e5292c354", "5f056b6969c46102cb1986e0_20200714");
                deviceController.issueCommand("ControlCooling","Cooling","ON");
                Toast.makeText(CommandsActivity.this,"cooling on",Toast.LENGTH_SHORT).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化一个DeviceController类下发命令
                DeviceController deviceController = new DeviceController("08f56a11b38025802f99c01e5292c354", "5f056b6969c46102cb1986e0_20200714");
                deviceController.issueCommand("ControlCooling","Cooling","OFF");
                Toast.makeText(CommandsActivity.this,"cooling off",Toast.LENGTH_SHORT).show();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化一个DeviceController类下发命令
                DeviceController deviceController = new DeviceController("08f56a11b38025802f99c01e5292c354", "5f056b6969c46102cb1986e0_20200714");
                deviceController.issueCommand("ControlCamera","Camera","SHOOT");
                Toast.makeText(CommandsActivity.this,"shoot success",Toast.LENGTH_SHORT).show();
            }
        });
    }
}