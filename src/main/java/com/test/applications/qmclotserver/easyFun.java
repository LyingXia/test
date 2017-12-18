package com.test.applications.qmclotserver;

import net.sf.json.JSONObject;

import java.io.File;

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

    public String login(File file){
        readExcel r1 = new readExcel();
        testPost tp = new testPost();
        String message = readExcel.readExcelReturnArr(file);
        String url = "http://192.168.1.34:8080/lotserver/test/sendRequest";
        String data = "content={"+message+"}&urlAddress=http://127.0.0.1:8080/lotserver/lotserverServlet";
        String resp1 = tp.transport(url,data);
        return getToken(resp1);
    }

    public String arrArrToArr(String[][] resp){
        String message="";
        //System.out.println(resp);
        for(int i=1; i < resp.length; i++) {
            for (int j = 0; j < resp[0].length; j++) {
                if (j == resp[0].length - 1) {
                    message = message + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\"";
                   /*下面的方法是拼接成a=a&b=b的*/
                    // message = message +  resp[0][j] + "=" + resp[i][j] ;
                } else {
                    message = message + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\",";
                   /*下面的方法是拼接成a=a&b=b的*/
                    //message = message +  resp[0][j] + "=" + resp[i][j] + "&";
                }
            }
        }
        return message;
    }

}
