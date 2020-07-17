package com.example.smartKitchen.huaweiHttp;

public class Query {
    public void queryShadow() {
//        获取token
//        String url ="https://iam.myhuaweicloud.com/v3/auth/tokens";
//        String content = "{\"auth\":{\"identity\":{\"methods\":[\"password\"],\"password\":{\"user\":{\"domain\":{\"name\":\"hw20998616\"},\"name\":\"hw20998616\",\"password\":\"Lt110011001\"}}},\"scope\":{\"domain\":{\"name\":\"hw20998616\"}}}}";
//        HttpClient httpClient = new HttpClient();
//        System.out.println(httpClient.doPost(url,content));

        //查询设备影子
        DeviceController deviceController = new DeviceController("08f56a11b38025802f99c01e5292c354","5f056b6969c46102cb1986e0_20200714");
        deviceController.getShadow();

        //解析json


        //下发命令
        //Device device = new Device("08f56a11b38025802f99c01e5292c354","5f056b6969c46102cb1986e0_20200714");
        //System.out.println(device.issueCommand("ControlCamera","Camera","SHOOT"));
    }





}
