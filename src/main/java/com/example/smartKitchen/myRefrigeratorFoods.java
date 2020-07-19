package com.example.smartKitchen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.smartKitchen.huaweiHttp.DeviceController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class myRefrigeratorFoods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_refrigerator_foods);


        //实例化一个DeviceController类然后调用它的方法获取设备影子
        DeviceController deviceController = new DeviceController("08f56a11b38025802f99c01e5292c354", "5f056b6969c46102cb1986e0_20200714");
        deviceController.getShadow();
        String httpInfo = DeviceController.b.getString("httpInfo");
        final String[] Temperature = {DeviceController.b.getString("Temperature")};
        String AllFood = DeviceController.b.getString("AllFood");
        String MainFood = DeviceController.b.getString("MainFood");

//          试了试，发现，只有主线程中才能操作view，然后主线程中的值来自新线程，新线程定义的值主线程又获取不到，而且把调用设备影子那部分放到新线程里面也会报错。。
//        //开启一个新线程一直动态获取实时数据
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    //休眠间隔两秒,时限定为10min
//                    for(int i=0;i<300;i++) {
//                        //
//                        Thread.sleep(2000);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

        //获取不到最新的值就一直获取
        while (httpInfo == null || Temperature[0] == null || AllFood == null || MainFood == null) {
            httpInfo = DeviceController.b.getString("httpInfo");
            Temperature[0] = DeviceController.b.getString("Temperature");
            AllFood = DeviceController.b.getString("AllFood");
            MainFood = DeviceController.b.getString("MainFood");
        }
        //用完重置，避免获取到过期值
        DeviceController.b_clear();
//        System.out.println("httpInfo:" + httpInfo);
//        System.out.println("Temperature:" + Temperature[0]);
//        System.out.println("AllFood:" + AllFood);
//        System.out.println("MainFood:" + MainFood);

        //根据获取到的值动态生成控件元素
        final TextView textView = (TextView) findViewById(R.id.currentTemperatureTV);
        textView.setText(Temperature[0] + "℃");

        //添加元素
        ConstraintLayout allFood = (ConstraintLayout) findViewById(R.id.AllFood);
        ConstraintLayout mainFood = (ConstraintLayout) findViewById(R.id.MainFood);
//        RelativeLayout allFoodRelativeLayout=(RelativeLayout) findViewById(R.id.AllFoodRelativeLayout);

        //获取元素
        TextView allFoodTitle = (TextView) findViewById(R.id.AllFoodTitle);
        TextView mainFoodTitle = (TextView) findViewById(R.id.MainFoodTitle);
        TextView allFoodContent = (TextView) findViewById(R.id.AllFoodContent);
        TextView mainFoodContent = (TextView) findViewById(R.id.MainFoodContent);
        Button commands = findViewById(R.id.bt);
        commands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myRefrigeratorFoods.this, CommandsActivity.class);
                startActivity(intent);
            }
        });

        //拆分字符串
        String[] allFoodArray = AllFood.split(",");
        String allFoodOutString = "";
        int i = 1;
        int j = 1;
        for (String string : allFoodArray) {
            //System.out.println(string);
            allFoodOutString = allFoodOutString + "\t" + i + "." + string + "\n";
            i = i + 1;
        }
        String[] mainFoodArray = MainFood.split(",");
        String mainFoodOutString = "";
        for (String string : mainFoodArray) {
            //System.out.println(string);
            mainFoodOutString = mainFoodOutString + "\t" + j + "." + string + "\n";
            i = i + 1;
        }

        //显示数据
        //System.out.println(allFoodOutString);
        allFoodContent.setText(" \n " + allFoodOutString);
        mainFoodContent.setText(" \n " + mainFoodOutString);


        //在类里声明一个Handler
        final String finalTemperature = Temperature[0];
        @SuppressLint("HandlerLeak") Handler mTimeHandler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                if (msg.what == 0) {

                    DeviceController deviceController = new DeviceController("08f56a11b38025802f99c01e5292c354", "5f056b6969c46102cb1986e0_20200714");
                    deviceController.getShadow();
                    Temperature[0] = DeviceController.b.getString("Temperature");
                    //更新温度
                    textView.setText(Temperature[0] + "℃");

                    //获取当前时间
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
                    Date date = new Date(System.currentTimeMillis());

                    //打印输出信息
                    System.out.println("这是新线程更新温度值输出的打印信息"+simpleDateFormat.format(date)+"当前温度值为"+Temperature[0]);
                    //延时2s获取一次
                    sendEmptyMessageDelayed(0, 2000);
                }
            }
        };

        //在你的onCreate的类似的方法里面启动这个Handler就可以了：
        mTimeHandler.sendEmptyMessageDelayed(0, 2000);


//        //在handler中更新UI,没反应、、。。
//        final String finalTemperature = Temperature;
//        final Handler mHandler = new Handler(){
//            public void handleMessage(Message msg) {
//                textView.setText("1222222");
//                System.out.println("这是第次更新温度值");
//            }
//        };
//        new Thread(){
//            public void run() {
//                Message message = new Message();
//
//                for (int z=0;z<300;z++){
//                    try {
//                        mHandler.sendMessage(message);
//                        Thread.sleep(1000);
//                        System.out.println("这是第"+z+"次更新温度值");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };


        //不知道为什么只能添加一个view。。。。,看来还是用字符串展示吧
//        View viewItem=LayoutInflater.from(this).inflate(R.layout.activity_food_template,allFoodRelativeLayout,false);
//
//        for(int i=0;i<10;i++){
//            layoutInflater.inflate(R.layout.activity_food_template,allFoodRelativeLayout,true);
//            System.out.println("1111");
        //  allFoodRelativeLayout.addView(viewItem);
//        }

    }
}


