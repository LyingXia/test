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


}
