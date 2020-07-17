package com.example.smartKitchen.huaweiHttp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONArray;
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

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String json_str = msg.obj.toString();
            Log.d("handler", json_str);
            try {
                JSONObject jsonObject = new JSONObject(json_str);
//                String cmd = jsonObject.getString("cmd");
//                String code = jsonObject.getString("code");
//                //用户名密码保存到shared preference
//                SharedPreferences sp = context.getSharedPreferences("user", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sp.edit();
//                String username;
//                String password;
                //返回成功通过opt判断各种操作
                switch (opt) {
                    case GET_SHADOW:
                        //解析json
//                        String temp = jsonObject.getJSONArray("shadow").getJSONObject(0).getJSONObject("reported").getJSONObject("properties").getString("Temperature");
//                        System.out.println(temp);
                        break;
                    case ISSUE_COMMAND:
                        break;
                }
//                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}
