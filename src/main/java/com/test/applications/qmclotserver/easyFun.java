package com.test.applications.qmclotserver;

import net.sf.json.JSONObject;

public class easyFun {
    public  String getToken(String loginmessage){
        System.out.println(loginmessage);
        //3是","  11是accessToken  32是需要取的长度
        login lg = new login();
        String s = lg.login(loginmessage);
        System.out.println(s+"\n");
        String errorcode = s.substring(s.indexOf("errorCode")+3+9,s.indexOf("errorCode")+3+9+4);
        String result="";
        if (errorcode.equals("0000")) {
            String accessToken = s.substring(s.indexOf("accessToken") + 3 + 11, s.indexOf("accessToken") + 3 + 11 + 32);
            result = "\"accessToken\":" + "\"" + accessToken + "\"";
        }else {
            result = "loginErr";
        }
        return result;
    }

    public  String getToken(JSONObject loginmessage){
        System.out.println(loginmessage);
        login lg = new login();
        String s = lg.login(loginmessage);
        System.out.println(s+"\n");
        String errorcode = s.substring(s.indexOf("errorCode")+3+9,s.indexOf("errorCode")+3+9+4);
        String result="";
        if (errorcode.equals("0000")) {
            String accessToken = s.substring(s.indexOf("accessToken") + 3 + 11, s.indexOf("accessToken") + 3 + 11 + 32);
            result = accessToken;
        }else {
            result = "loginErr";
        }
        return result;
    }

    public  String getuserNo(String loginmessage){
        //3是","  6是userNo  16是需要取的长度
        login lg = new login();
        String s = lg.login(loginmessage);
        String errorcode = s.substring(s.indexOf("errorCode")+3+9,s.indexOf("errorCode")+3+9+4);
        String result="";
        if (errorcode.equals("0000")) {
            String userNo = s.substring(s.indexOf("userNo") + 3 + 6, s.indexOf("userNo") + 3 + 6 + 16);
            result = "\"userNo\":" + "\"" + userNo + "\"";
        }else {
            result = "loginErr";
        }
        return result;
    }

    public  String getuserNo(JSONObject loginmessage){
        //3是","  6是userNo  16是需要取的长度
        login lg = new login();
        String s = lg.login(loginmessage);
        String errorcode = s.substring(s.indexOf("errorCode")+3+9,s.indexOf("errorCode")+3+9+4);
        String result="";
        if (errorcode.equals("0000")) {
            String userNo = s.substring(s.indexOf("userNo") + 3 + 6, s.indexOf("userNo") + 3 + 6 + 16);
            result = userNo ;
        }else {
            result = "loginErr";
        }
        return result;
    }

    public void register(String username,int num,String productName) {
        String s = username ;
        JSONObject message = new JSONObject();
        testPost tp = new testPost();
        String url = "http://192.168.1.11/lotserver/test/sendRequest";

        message.put("command","register");
        message.put("platform","android");
        message.put("imei","3434343434534534");
        message.put("version","6.2.36");
        message.put("machineId","HTC Desire");
        message.put("channel","1");
        message.put("productName",productName);
        message.put("password","123456");
        for (int i = 0 ; i <=  num; i ++){
            if (i == 0){
                message.put("userName",s);
            }else{
                message.put("userName",s+i);
            }
            System.out.println(message.toString());
            System.out.println(tp.transport(url,"content="+message.toString()+ "&urlAddress=http://127.0.0.1:8080/lotserver/lotserverServlet"));
        }
    }

}
