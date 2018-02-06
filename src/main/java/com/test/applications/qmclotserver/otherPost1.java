package com.test.applications.qmclotserver;

import net.sf.json.JSONObject;

import java.io.File;

/**
 * created by xiapf on 2017/12/1
 */
public class otherPost1 {
    public  void otherRqt(File file)  {
        String[][] resp = readExcel.readExcelReturnarrArr(file);
        String actoken = "";
        String userno = "";
        JSONObject a = new JSONObject();
        JSONObject b = new JSONObject();
        JSONObject c = new JSONObject();
        JSONObject d = new JSONObject();
        JSONObject e = new JSONObject();
       // b.put("a",new int[] {111,222});
        //System.out.println(resp);
        for(int i=1; i < resp.length; i++){
            for (int j=0; j < resp[0].length; j++){
                if (resp[0][j].equals("productName")){

                    e.put(resp[0][j],resp[i][j]);

                } else if(resp[0][j].equals("userName")  || resp[0][j].equals("password")){

                   b.put(resp[0][j],resp[i][j]);

                }else if( resp[0][j].equals("userNo")) {

                    c.put(resp[0][j],resp[i][j]);

                }else if( resp[0][j].equals("accessToken")) {

                   d.put(resp[0][j],resp[i][j]);

                }else{
                    a.put(resp[0][j],resp[i][j]);
                }
            }
            if (b.containsKey("userName") && b.containsKey("password") ){
                easyFun ez = new easyFun();
                b.putAll(e);
                actoken = ez.getToken(b);
                userno = ez.getuserNo(b);
                a.put("userNo",userno);
                a.put("accessToken",actoken);
                a.putAll(e);
                otherRqt(a);
            }else{
                a.putAll(c);
                a.putAll(d);
                a.putAll(e);
                otherRqt(a);
            }
        }
    }


    private  void otherRqt (JSONObject message){
        testPost res1 = new testPost();
        /*System.out.println("{"+message+"}");*/
        String url = "http://192.168.1.31:8080/lotserver/test/sendRequest";
        /*String url = "http://192.168.1.35:8080/lottery-order/"*/
        String data = "content="+message.toString()+ "&urlAddress=http://127.0.0.1:8080/lotserver/lotserverServlet";
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

    public void otherSedRqt(File file){
        String[][] resp = readExcel.readExcelReturnarrArr(file);
        String message = "";
        String url = "";
        for(int i=1; i < resp.length; i++){
            for (int j=0; j < resp[0].length; j++) {
                if (resp[0][j].equals("url")){
                    url = url + resp[i][j];
                }else if (j==resp[0].length-1) {
                    message = message +  resp[0][j] + "=" + resp[i][j];
                }else{
                    message = message +  resp[0][j] + "=" + resp[i][j] + "&";
                }
            }
            if (message.lastIndexOf("&") == message.length()-1) {
                message = message.substring(0,message.length()-1);
                System.out.println("post:"+url+"\t\n"+message);
                otherSedRqt(url, message);
                message = "";
                url="";
            }else{

            }
        }
    }

    private void otherSedRqt(String url,String message){
        testPost tp = new testPost();
        String s = tp.transport(url, message);
        System.out.println(s+"\n");

    }
}
