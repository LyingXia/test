package com.test.applications.qmclotserver;

import java.io.File;

/**
 * created by xiapf on 2017/12/1
 */
public class otherPost {
    public  void otherRqt(File file){
        String[][] resp = readExcel.readExcelReturnarrArr(file);
        String message="";
        String loginmessage="";
        String userno= "";
        String actoken = "";
        //System.out.println(resp);
        for(int i=1; i < resp.length; i++){
            for (int j=0; j < resp[0].length; j++){
                if (j == resp[0].length - 1 && resp[0][j].equals("userName")) {
                    loginmessage = loginmessage + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\"";
                   /*下面的方法是拼接成a=a&b=b的*/
                    // loginmessage = loginmessage +  s[0][j] + "=" + s[i][j] ;
                }else if (j == resp[0].length - 1 && resp[0][j].equals("password")){
                    loginmessage = loginmessage + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\"";
                   /*下面的方法是拼接成a=a&b=b的*/
                    // loginmessage = loginmessage +  resp[0][j] + "=" + resp[i][j] ;
                }else if(resp[0][j].equals("userName")  || resp[0][j].equals("password")){
                    loginmessage = loginmessage + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\",";
                    /*下面的方法是拼接成a=a&b=b的*/
                    // loginmessage = loginmessage +  resp[0][j] + "=" + resp[i][j] + "&";
                }else if(j == resp[0].length - 1 && resp[0][j].equals("userNo")) {
                    userno = userno + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\"";
                    /*下面的方法是拼接成a=a&b=b的*/
                    // userno = userno +  resp[0][j] + "=" + resp[i][j] + "&";
                }else if( resp[0][j].equals("userNo")) {
                    userno = userno + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\",";
                    /*下面的方法是拼接成a=a&b=b的*/
                    // userno = userno +  resp[0][j] + "=" + resp[i][j] + "&";
                }else if(j == resp[0].length - 1 && resp[0][j].equals("accessToken")) {
                    actoken = actoken + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\"";
                    /*下面的方法是拼接成a=a&b=b的*/
                    // actoken = actoken +  resp[0][j] + "=" + resp[i][j] + "&";
                }else if( resp[0][j].equals("accessToken")) {
                    actoken = actoken + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\",";
                    /*下面的方法是拼接成a=a&b=b的*/
                    // actoken = actoken +  resp[0][j] + "=" + resp[i][j] + "&";
                }else if(j==resp[0].length-1 ){
                    message = message + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\"";
                   /*下面的方法是拼接成a=a&b=b的*/
                    // message = message +  resp[0][j] + "=" + resp[i][j] ;
                }else{
                    message = message + "\"" + resp[0][j] + "\":\"" + resp[i][j] + "\",";
                   /*下面的方法是拼接成a=a&b=b的*/
                    //message = message +  resp[0][j] + "=" + resp[i][j] + "&";
                }
            }
            if(loginmessage.length() != 0 && loginmessage.contains("userName") && loginmessage.contains("password")) {
                easyFun ez = new easyFun();
                actoken = ez.getToken(loginmessage);
                userno = ez.getuserNo(loginmessage);
                message = message + userno + "," + actoken ;
                otherRqt(message);
                message = "";
                loginmessage = "";
            }else{
                message = message + userno+ "," + actoken;
                otherRqt(message);
                message = "";
                loginmessage = "";
            }
        }
    }
    
    private   void otherRqt (String message){
        testPost res1 = new testPost();
        /*System.out.println("{"+message+"}");*/
        String url = "http://192.168.1.31:8080/lotserver/test/sendRequest";
        /*String url = "http://192.168.1.35:8080/lottery-order/"*/
        String data = "content={"+message+"}&urlAddress=http://127.0.0.1:8080/lotserver/lotserverServlet";
        System.out.println(data);
        //String type = "post";
        //postWay res = new postWay();
        //发送到sendRequest
        //String s = res.transRequest(url,type,data);
        //发送的是json格式
        //String s = res.transRequest(url,type,"{"+message+"}");
        //测试message，此处直接用的是message赋值
        //String s = res.transRequest(url,type,message);EE
        //System.out.println(s);
        String s1 = res1.transport(url,data);
        System.out.println(s1+"\n");
    }
}
