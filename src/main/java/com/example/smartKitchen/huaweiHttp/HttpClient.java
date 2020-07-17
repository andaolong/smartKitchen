package com.example.smartKitchen.huaweiHttp;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpClient {
    public static void doGet(final String httpurl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String token = "MIIZDgYJKoZIhvcNAQcCoIIY-zCCGPsCAQExDTALBglghkgBZQMEAgEwghcgBgkqhkiG9w0BBwGgghcRBIIXDXsidG9rZW4iOnsiZXhwaXJlc19hdCI6IjIwMjAtMDctMThUMDI6Mjk6MTIuNzU3MDAwWiIsIm1ldGhvZHMiOlsicGFzc3dvcmQiXSwiY2F0YWxvZyI6W10sImRvbWFpbiI6eyJuYW1lIjoiaHcyMDk5ODYxNiIsImlkIjoiMDhlZTQwNjY2OTAwMjU4MjBmZTJjMDFlMDg2NWVkMDAifSwicm9sZXMiOlt7Im5hbWUiOiJ0ZV9hZG1pbiIsImlkIjoiMCJ9LHsibmFtZSI6InNlY3VfYWRtaW4iLCJpZCI6IjAifSx7Im5hbWUiOiJ0ZV9hZ2VuY3kiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9laXBfaXB2NiIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX3YyeCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19zcG90X2luc3RhbmNlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfaXZhc192Y3JfdmNhIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfaWVmX25vZGVncm91cCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19hc2NlbmRfa2FpMSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19rYWUxIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZGJzX3JpIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYm1zX2hwY19oMmxhcmdlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZXZzX2Vzc2QiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9pb2RwcyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2JhdGNoX2Vjc19jbHVzdGVyIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZWNzX2dwdV92MTAwIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfY2JzX3FpIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZHdzX3BvYyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19rYzFfdXNlcl9kZWZpbmVkIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfbWVldGluZ19lbmRwb2ludF9idXkiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9tZWVldGluZ193aGl0ZWJvYXJkX2J1eSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX3Npc19zYXNyX2VuIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfVklTX0ludGwiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9lY3NfZ3B1X3AycyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2V2c192b2x1bWVfcmVjeWNsZV9iaW4iLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF92Y2MiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF92Y3AiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9kcHAiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9jdnIiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9lY3NfYzZuZSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX29jc21hcnRjYW1wdXMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9ia3MiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9hcHBjdWJlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfbWVldGluZ19oYXJkYWNjb3VudF9idXkiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9tdWx0aV9iaW5kIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfbmxwX210IiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfY3NlXzJuZCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2VpcF9wb29sIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfbWVlZXRpbmdfY3VycmVudF9idXkiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9pZWZfZnVuY3Rpb24iLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9hX2FwLXNvdXRoZWFzdC0zZCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX3Byb2plY3RfZGVsIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfbTZtdCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2V2c19yZXR5cGUiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9hYWRfZnJlZSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2VsYl9ndWFyYW50ZWVkIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYV9jbi1zb3V0aHdlc3QtMmIiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9zZnN0dXJibyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2h2X3ZlbmRvciIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FfY24tbm9ydGgtNGUiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9hX2NuLW5vcnRoLTRkIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfSUVDIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfdGFzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZGF5dV9kbG1fY2x1c3RlciIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2ludGxfY29uZmlndXJhdGlvbiIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX3Npc19hc3Nlc3NfbXVsdGltb2RlbCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NjZV9tY3BfdGhhaSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX25scF9sZ190ZyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX3NlcnZpY2VzdGFnZV9tZ3JfZHRtIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYV9jbi1ub3J0aC00ZyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FfY24tbm9ydGgtNGYiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9jcGgiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9Nb2RlbEFydHNBc2NlbmQ5MTAiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9tZWV0aW5nX2hpc3RvcnlfY3VzdG9tX2J1eSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX3dzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZWNzX2dwdV9nNXIiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF93a3Nfa3AiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9jY2lfa3VucGVuZyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX3JpX2R3cyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2lvdGVkZ2VfY2FtcHVzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZWNzX29mZmxpbmVfZDYiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF92Z3ZhcyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX3ZwY19mbG93X2xvZyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX29wX2dhdGVkX2ljcyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FhZF9iZXRhX2lkYyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NzYnNfcmVwX2FjY2VsZXJhdGlvbiIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2llZl9lZGdlbWVzaCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Fpc19hcGlfaW1hZ2VfYW50aV9hZCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Rzc19tb250aCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NzZyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19jNngiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9zaXNfYXNzZXNzX2F1ZGlvIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfdWZzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZGVjX21vbnRoX3VzZXIiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF92aXBfYmFuZHdpZHRoIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZWNzX29sZF9yZW91cmNlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZGNzX3JpIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfdmdpdnMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9vYnNfZHVhbHN0YWNrIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZWRjbSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NzYnNfcmVzdG9yZSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2l2c2NzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfaXB2Nl9kdWFsc3RhY2siLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF92cG5fdmd3IiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfaXJ0YyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NjZV9ibXMyIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfcGNhIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfdmd3cyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NjZV9hc21faGsiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9jb25maWd1cmF0aW9uIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfY3Nic19wcm9ncmVzc2JhciIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2lvdi10cmlhbCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19jNnhfdmlydGlvX25ldCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2V2c19wb29sX2NhIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZGRzX2FybSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FfQ04tU09VVEgtMyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19vZmZsaW5lX2Rpc2tfNCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2JzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZ3NzX2ZyZWVfdHJpYWwiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9tZWV0aW5nX2Nsb3VkX2J1eSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2VwcyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NzYnNfcmVzdG9yZV9hbGwiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF8xMjMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9sMmNnIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfV2VMaW5rX2VuZHBvaW50X2J1eSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FfY24tZWFzdC0yMDFiIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfcXVpY2tidXkiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9mY3NfcGF5IiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfaW90YW5hbHl0aWNzIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfbWF4aHViX2VuZHBvaW50X2J1eSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FfYXAtc291dGhlYXN0LTFlIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfYV9hcC1zb3V0aGVhc3QtMWQiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9ubHBfa2ciLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9hX2FwLXNvdXRoZWFzdC0xZiIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2llZl9kZXZpY2VfZGlyZWN0IiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfZGNzX2RjczJfcHJveHkiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9lY3NfdmdwdV9nNSIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2NzX2FybV9wb2MiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9lY3NfcmkiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9hX2FwLXNvdXRoZWFzdC0xYyIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2FfcnUtbm9ydGh3ZXN0LTJjIiwiaWQiOiIwIn0seyJuYW1lIjoib3BfZ2F0ZWRfdWxiX21paXRfdGVzdCIsImlkIjoiMCJ9LHsibmFtZSI6Im9wX2dhdGVkX2Vjc19hc2NlbmRfa2FpMXMiLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9pZWZfcGxhdGludW0iLCJpZCI6IjAifSx7Im5hbWUiOiJvcF9nYXRlZF9WaWRlb19DYW1wdXMiLCJpZCI6IjAifV0sImlzc3VlZF9hdCI6IjIwMjAtMDctMTdUMDI6Mjk6MTIuNzU3MDAwWiIsInVzZXIiOnsiZG9tYWluIjp7Im5hbWUiOiJodzIwOTk4NjE2IiwiaWQiOiIwOGVlNDA2NjY5MDAyNTgyMGZlMmMwMWUwODY1ZWQwMCJ9LCJuYW1lIjoiaHcyMDk5ODYxNiIsInBhc3N3b3JkX2V4cGlyZXNfYXQiOiIiLCJpZCI6IjA4ZWU0MDY3Mjg4MGYzOGExZjNhYzAxZWVhMWY3NjBlIn19fTGCAcEwggG9AgEBMIGXMIGJMQswCQYDVQQGEwJDTjESMBAGA1UECAwJR3VhbmdEb25nMREwDwYDVQQHDAhTaGVuWmhlbjEuMCwGA1UECgwlSHVhd2VpIFNvZnR3YXJlIFRlY2hub2xvZ2llcyBDby4sIEx0ZDEOMAwGA1UECwwFQ2xvdWQxEzARBgNVBAMMCmNhLmlhbS5wa2kCCQDcsytdEGFqEDALBglghkgBZQMEAgEwDQYJKoZIhvcNAQEBBQAEggEALyigHuDfKlS+uYreoZ4CK-oYynGTA+YDGiVz4LXA2roSPmq97paPugkvPbsjO3wFsLWy62JmDSNBXpelUP8wJ5i04qckG5oEnGtk-kuOZ6F0vzcgmDbY2jkM-dPp9FFvmEj5BclUU4I1XbPO5e1-fEnmhiyGJigUQiysR51BGAl2LW7KSqsAnygIHaPKtRH0gwE2snfiPQf-Vkgk-v6D-SsQlkCb5p62cXMykUxmCeCJGec2X5fASyZnnkt5KQSAxJR+Uk2ZUzYkFmzpm+h+dZEyrFiMm1tZaOmx8EMvdoOSwhVBn9C-V1tlaUh9U5qKckK6TkL51GpZ9PCynw8wiQ==";
                HttpURLConnection connection = null;
                InputStream inputStream = null;
                BufferedReader bufferedReader = null;
                String result = null;// 返回结果字符串
                try {
                    Log.d("DEBUG","Try to connect...");
                    // 创建远程url连接对象
                    URL url = new URL(httpurl);
                    // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
                    connection = (HttpURLConnection) url.openConnection();
                    // 设置连接方式：get
                    connection.setRequestMethod("GET");
                    // 设置连接主机服务器的超时时间：15000毫秒
                    connection.setConnectTimeout(15000);
                    // 设置读取远程返回的数据时间：60000毫秒
                    connection.setReadTimeout(60000);

                    // 设置鉴权信息：
                    connection.setRequestProperty("X-Auth-Token", token);
                    // 设置传入参数的格式:
                    connection.setRequestProperty("Content-Type", "application/json");
                    // 发送请求
                    connection.connect();
                    // 通过connection连接，获取输入流
                    if (connection.getResponseCode() == 200) {
                        Log.d("DEBUG","Connection success.");
                        inputStream = connection.getInputStream();
                        // 封装输入流inputStream，并指定字符集
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        // 存放数据
                        StringBuffer sbf = new StringBuffer();
                        String temp = null;
                        while ((temp = bufferedReader.readLine()) != null) {
                            sbf.append(temp);
                            sbf.append("\r\n");
                        }
                        result = sbf.toString();
                        //call back method
                        Message message = new Message();
                        message.obj=result;
                        Looper.prepare();//新线程中调用handler必须用looper包裹
                        DeviceController.handler.handleMessage(message);
                        Looper.loop();
                    } else {
                        Log.d("DEBUG: ResponseCode:", String.valueOf(connection.getResponseCode()));
                        Log.d("DEBUG","connection fail.");

                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // 关闭资源
                    if (null != bufferedReader) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (null != inputStream) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    connection.disconnect();// 关闭远程连接
                }
            }
        }).start();
    }



//    public String doPost(String httpUrl, String content) {
//
//        HttpURLConnection connection = null;
//        InputStream inpusStream = null;
//        OutputStream os = null;
//        BufferedReader bufferedReader = null;
//        String result = null;
//        try {
//            Log.d("DEBUG: Try to connect...");
//
//            URL url = new URL(httpUrl);
//            // 通过远程url连接对象打开连接
//            connection = (HttpURLConnection) url.openConnection();
//            // 设置连接请求方式
//            connection.setRequestMethod("POST");
//            // 设置连接主机服务器超时时间：15000毫秒
//            connection.setConnectTimeout(15000);
//            // 设置读取主机服务器返回数据超时时间：60000毫秒
//            connection.setReadTimeout(60000);
//
//            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
//            connection.setDoOutput(true);
//            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
//            connection.setDoInput(true);
//
//            // 设置传入参数的格式:
//            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//            // 设置鉴权信息：
//            connection.setRequestProperty("X-Auth-Token", token);
//
//            // 通过连接对象获取一个输出流
//            os = connection.getOutputStream();
//            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
//            os.write(content.getBytes());
//            // 通过连接对象获取一个输入流，向远程读取
//
//            Log.d("DEBUG: ResponseCode: " + connection.getResponseCode());
//            //获取响应头 header
//            Map<String, LinpusStreamt<String>> map = connection.getHeaderFields();
//            for (Map.Entry<String, LinpusStreamt<String>> entry : map.entrySet()) {
//                Log.d("Key : " + entry.getKey() + " ,Value : " + entry.getValue());
//            }
//
//            inpusStream = connection.getInputStream();
//            // 对输入流对象进行包装:charset根据工作项目组的要求来设置
//            bufferedReader = new BufferedReader(new InputStreamReader(inpusStream, "UTF-8"));
//
//            StringBuffer sbf = new StringBuffer();
//            String temp = null;
//            // 循环遍历一行一行读取数据
//            while ((temp = bufferedReader.readLine()) != null) {
//                sbf.append(temp);
//                sbf.append("\r\n");
//            }
//            result = sbf.toString();
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭资源
//            if (null != bufferedReader) {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null != os) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null != inpusStream) {
//                try {
//                    inpusStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            // 断开与远程地址url的连接
//            connection.disconnect();
//        }
//        return result;
//    }

}