package com.example.smartKitchen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.smartKitchen.huaweiHttp.DeviceController;

public class myRefrigeratorFoods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_refrigerator_foods);
        //实例化一个DeviceController类然后调用它的方法获取设备影子
        DeviceController deviceController = new DeviceController("08f56a11b38025802f99c01e5292c354", "5f056b6969c46102cb1986e0_20200714");
        deviceController.getShadow();
        String httpInfo = DeviceController.b.getString("httpInfo");
        String Temperature = DeviceController.b.getString("Temperature");
        String AllFood = DeviceController.b.getString("AllFood");
        String MainFood =DeviceController.b.getString("MainFood");
        //获取不到最新的值就一直获取
        while (httpInfo == null||Temperature==null||AllFood==null||MainFood==null) {
            httpInfo = DeviceController.b.getString("httpInfo");
            Temperature = DeviceController.b.getString("Temperature");
            AllFood = DeviceController.b.getString("AllFood");
            MainFood =DeviceController.b.getString("MainFood");
        }
        //用完重置，避免获取到过期值
        DeviceController.b_clear();
        System.out.println("httpInfo:" + httpInfo);
        System.out.println("Temperature:" + Temperature);
        System.out.println("AllFood:" + AllFood);
        System.out.println("MainFood:" + MainFood);

        //根据获取到的值动态生成控件元素
        TextView textView=(TextView)findViewById(R.id.currentTemperatureTV);
        textView.setText("冰箱当前温度为：   "+Temperature+"℃");

        //添加元素
        ConstraintLayout allFood=(ConstraintLayout) findViewById(R.id.AllFood);
        ConstraintLayout mainFood=(ConstraintLayout) findViewById(R.id.MainFood);
//        RelativeLayout allFoodRelativeLayout=(RelativeLayout) findViewById(R.id.AllFoodRelativeLayout);

        //获取元素
        TextView allFoodTitle = (TextView) findViewById(R.id.AllFoodTitle);
        TextView mainFoodTitle = (TextView) findViewById(R.id.MainFoodTitle);
        TextView allFoodContent = (TextView) findViewById(R.id.AllFoodContent);
        TextView mainFoodContent = (TextView) findViewById(R.id.MainFoodContent);

        //拆分字符串
        String[] allFoodArray=AllFood.split(",");
        String allFoodOutString="";
        int i=1;
        int j=1;
        for(String string:allFoodArray){
            System.out.println(string);
            allFoodOutString=allFoodOutString+"\t"+i+"."+string+"\n";
            i=i+1;
        }
        String[] mainFoodArray=MainFood.split(",");
        String mainFoodOutString="";
        for(String string:mainFoodArray){
            System.out.println(string);
            mainFoodOutString=mainFoodOutString+"\t"+j+"."+string+"\n";
            i=i+1;
        }

        //显示数据
        System.out.println(allFoodOutString);
        allFoodContent.setText(" \n "+allFoodOutString);
        mainFoodContent.setText(" \n "+mainFoodOutString);


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