package com.test.applications.qmclotserver;

import net.sf.json.JSONObject;

import java.io.File;

/**
 * created by xiapf on 2017/11/30
 */
public class login {
    public  void login(File file) {
        String[][] s = readExcel.readExcelReturnarrArr(file);
        String message="";
        for(int i=1; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                if (j == s[0].length - 1 && s[0][j].equals("userName")) {
                    message = message + "\"" + s[0][j] + "\":\"" + s[i][j] + "\"";
                   /*下面的方法是拼接成a=a&b=b的*/
                    // message = message +  s[0][j] + "=" + s[i][j] ;
                }else if (j == s[0].length - 1 && s[0][j].equals("password")){
                    message = message + "\"" + s[0][j] + "\":\"" + s[i][j] + "\"";
                   /*下面的方法是拼接成a=a&b=b的*/
                    // message = message +  s[0][j] + "=" + s[i][j] ;
                } else if(s[0][j].equals("userName")  || s[0][j].equals("password")){
                    message = message + "\"" + s[0][j] + "\":\"" + s[i][j] + "\",";
                   /*下面的方法是拼接成a=a&b=b的*/
                    //message = message +  s[0][j] + "=" + s[i][j] + "&";
                }else{
                    message = message ;                                                                          ;
                }
            }
            login(message);
            message = "";
        }
    }

    public   String  login(String message){
        testPost tp = new testPost();
        String url = "http://192.168.1.34:8080/lotserver/test/sendRequest";
        String data = "content={\"command\":\"login\"," +
                "\"platform\":\"android\"," +
                "\"imei\":\"3434343434534534\"," +
                "\"version\":\"2.3.0\"," +
                "\"machineId\":\"HTC Desire\"," +
                "\"channel\":\"1\","+message+"}&urlAddress=http://127.0.0.1:8080/lotserver/lotserverServlet";
        //System.out.println(data);
        String s1 = tp.transport(url,data);
        //System.out.println(s1+"\n");
        return s1;
    }

    public   String  login(JSONObject message){
        testPost tp = new testPost();
        JSONObject login = new JSONObject();
        login.put("command","login");
        login.put("platform","android");
        login.put("imei","3434343434534534");
        login.put("version","2.3.0");
        login.put("machineId","HTC Desire");
        login.put("channel","1");
        login.putAll(message);
        String url = "http://192.168.1.34:8080/lotserver/test/sendRequest";
        String data ="content=" +login.toString()+"&urlAddress=http://127.0.0.1:8080/lotserver/lotserverServlet" ;
        //System.out.println(data);
        String s1 = tp.transport(url,data);
        JSONObject s2 = new JSONObject();

        //System.out.println(s1+"\n");
        return s1;
    }

    public static void  main (String[] args){
        File file = new File("C:\\Users\\user\\Desktop\\test1.xlsx");
//        login(file);
        String s = "123456789";
        int a = s.indexOf("username");
        System.out.println(a);
    }
}
