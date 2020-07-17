package com.example.smartKitchen;


import android.app.Application;


//设置一个全局的类用来传递信息
public class GlobalApplication extends Application {
    public String httpGetMessage;

    public String getHttpGetMessage() {
        return httpGetMessage;
    }

    public void setHttpGetMessage(String httpGetMessage) {
        this.httpGetMessage = httpGetMessage;
    }

}