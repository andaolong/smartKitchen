package com.example.smartKitchen.huaweiHttp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
用project_id和device_id构造Device,可以进行查看影子和命令下发的操作
 */
public class DeviceController {
    private String url = "https://iotda.cn-north-4.myhuaweicloud.com";
    private String project_id = null;
    private String device_id = null;
    public static int opt;
    final public static int GET_SHADOW = 0;
    final public static int ISSUE_COMMAND = 1;
    public static Bundle b= new Bundle();

    public DeviceController(String project_id, String device_id) {
        super();
        this.project_id = project_id;
        this.device_id = device_id;
    }

    public void setDeviceId(String device_id) {
        this.device_id = device_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getDevice_id() {
        return this.device_id;
    }

    public String getProject_id() {
        return this.project_id;
    }

    public void getShadow() {
        opt = GET_SHADOW;
        this.url = this.url + "/v5/iot/" + this.project_id + "/devices/" + this.device_id + "/shadow";
        HttpClient httpClient = new HttpClient();
        httpClient.doGet(url);
    }

    public void issueCommand(String command_name, String parameter, String value) {
        opt = ISSUE_COMMAND;
        this.url = this.url + "/v5/iot/" + this.project_id + "/devices/" + this.device_id + "/commands";
        String content =
                "{\n" +
                        "  \"service_id\" : \"Refrigerator\",\n" +
                        "  \"command_name\" : \"" + command_name + "\",\n" +
                        "  \"paras\" : {\n" +
                        "    \"" + parameter + "\" : \"" + value + "\"\n" +
                        "  }\n" +
                        "}\n";
        HttpClient httpClient = new HttpClient();
        httpClient.doPost(url, content);
    }

    @SuppressLint("HandlerLeak")
    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
//            String json_str = msg.obj.toString();
//            Log.d("handler", json_str);

            switch (opt) {
                case GET_SHADOW:
                    //解析json
                    try {
                        String json_str = msg.obj.toString();
                        Log.d("handler", json_str);
                        JSONObject jsonObject = new JSONObject(json_str);
                        //取出device_id
                        String device_id = jsonObject.getString("device_id");
                        System.out.println("\n第一层的device_id:" + device_id);
                        //取出整个shadow，现在还是一个json数组
                        JSONArray jsonArrayShadow = jsonObject.getJSONArray("shadow");
                        System.out.println("\n第一层的shadow:" + jsonArrayShadow);
                        //从shadow这个json数组中取出service_id,reported数组，我们要的信息在report数组里面
                        for (int i = 0; i < jsonArrayShadow.length(); i++) {
                            //新建一个jsonObject存储json数组中解析出来的json对象
                            JSONObject jsonObject02 = (JSONObject) jsonArrayShadow.get(i);
                            //解析出service_id
                            String service_id = jsonObject02.getString("service_id");
                            System.out.println("第二层的service_id:" + service_id);
                            //解析出report
                            JSONObject reportedJson = jsonObject02.getJSONObject("reported");
                            System.out.println("第二层的reported:" + reportedJson);
                            //从report中解析出properties
                            JSONObject propertiesJson = reportedJson.getJSONObject("properties");
                            System.out.println("第三层的properties:" + propertiesJson);
                            //从properties中解析出温度，食物等我们需要的信息
                            String Temperature = propertiesJson.getString("Temperature");
                            String AllFood = propertiesJson.getString("AllFood");
                            String MainFood = propertiesJson.getString("MainFood");
                            System.out.println("第四层的Temperature:" + Temperature);
                            System.out.println("第四层的AllFood:" + AllFood);
                            System.out.println("第四层的MainFood:" + MainFood);
                            System.out.println("解析完成");
                            b.putString("httpInfo",json_str);
                            b.putString("service_id",service_id);
                            b.putString("Temperature",Temperature);
                            b.putString("AllFood",AllFood);
                            b.putString("MainFood",MainFood);
                        }
                        break;
//                        case ISSUE_COMMAND:
//                            break;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
            }

        }
    };
}
