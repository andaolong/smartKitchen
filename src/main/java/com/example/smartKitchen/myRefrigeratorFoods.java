package com.example.smartKitchen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartKitchen.huaweiHttp.Query;

public class myRefrigeratorFoods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_refrigerator_foods);

        //因为安卓4.0以后不允许在主线程中加载http，加上这几句好像是允许了，但是http长的话最好还是开一个线程在线程中加载，还是不行。。。
//        if (android.os.Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }


        //进入到这个activity就执行华为云的http查询设备影子，然后将数据解析出来显示在页面上
                Query queryShadow = new Query();
                queryShadow.queryShadow();
//        startNewThreadToGetShadow();


//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                Query queryShadow = new Query();
//                queryShadow.queryShadow();
//            }
//        }.start();
    }



//
//
//    //新定义一个线程
//    Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Bundle data = msg.getData();
//            String val = data.getString("value");
//        }
//    };
//    Runnable runnable = new Runnable(){
//        @Override
//        public void run() {
//            // TODO: http request.
//            Message msg = new Message();
//            Bundle data = new Bundle();
//            data.putString("value","请求结果");
//            msg.setData(data);
//            handler.sendMessage(msg);
//        }
//    };
//
//
//
//    public void startNewThreadToGetShadow() {
//
//        // Android 4.0 之后不能在主线程中请求HTTP请求
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                //进入到这个activity就执行华为云的http查询设备影子，然后将数据解析出来显示在页面上
//                Query queryShadow = new Query();
//                queryShadow.queryShadow();
//            }
//        }).start();
//
//
//    }


    //解析获得的json字符串，用的是安卓自带的json解析类，不用另外导入什么东西
//    private void parseDiffJson(String json) {
//        try {
//            //定义一个json对象
//            JSONObject jsonObject1 = new JSONObject(json);
//            //把json打印一下
//            Log.e("Json", json);
//            //定义一个json数组
//            JSONArray jsonArray = jsonObject1.getJSONArray("ch");
//            //逐步解析json数组中的值
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//                //取出name
////                String sname = jsonObject.getString("names");
////                JSONArray jarray1 = jsonObject.getJSONArray("data");
////                JSONArray jarray2 = jsonObject.getJSONArray("times");
////                Log.e("Json", sname);
////                Log.e("Json", jarray1.toString());
////                Log.e("Json", jarray2.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}