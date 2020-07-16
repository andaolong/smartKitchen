package com.example.smartKitchen.huaweiHttp;

/*
用project_id和device_id构造Device,可以进行查看影子和命令下发的操作
 */
public class Device {
    private String url = "https://iotda.cn-north-4.myhuaweicloud.com";
    private String project_id = null;
    private String device_id = null;

    public Device(String project_id, String device_id){
        super();
        this.project_id = project_id;
        this.device_id  = device_id;
    }

    public void setDeviceId(String device_id){
        this.device_id = device_id;
    }

    public void setProject_id(String project_id){
        this.project_id = project_id;
    }

    public String getDevice_id(){
        return this.device_id;
    }

    public String getProject_id(){
        return this.project_id;
    }

    public String getShadow(){
        this.url = this.url+"/v5/iot/"+this.project_id+"/devices/"+this.device_id+"/shadow";
        HttpClient httpClient = new HttpClient();
        return httpClient.doGet(url);

    }

    public String issueCommand(String command_name, String parameter, String value){
        this.url = this.url+"/v5/iot/"+this.project_id+"/devices/"+this.device_id+"/commands";
        String content =
                "{\n" +
                "  \"service_id\" : \"Refrigerator\",\n" +
                "  \"command_name\" : \""+command_name+"\",\n" +
                "  \"paras\" : {\n" +
                "    \""+parameter+"\" : \""+value+"\"\n" +
                "  }\n" +
                "}\n";
        HttpClient httpClient = new HttpClient();
        return httpClient.doPost(url,content);
    }
}
