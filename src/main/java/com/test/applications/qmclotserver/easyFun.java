package com.test.applications.qmclotserver;

import net.sf.json.JSONObject;

public class easyFun {
    /*将拼好的JSONObject给换成字符串发送给lotserver*/
    public String JsonToLotserverCommond(JSONObject message){
        String s = "content="+message.toString()+ "&urlAddress=http://127.0.0.1:8080/lotserver/lotserverServlet";
        return s;
    }

    /*将返回的字符串结果强制转成JSONObject以方便取值*/
    public JSONObject StringToJson(String s){
        JSONObject resp = JSONObject.fromObject(s);
        return resp;
    }

    /*将返回的字符串结果强制转成JSONObject,并且根据key取值*/
    public String StringToJson(String s,String key){
        JSONObject resp = JSONObject.fromObject(s);
        String res = resp.getString(key);
        return  res;
    }

    /*获取"username":"","password":"","productname":""去登陆然后获取登陆后的token*/
    public  String getToken(String loginmessage){
        System.out.println(loginmessage);
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
    /*获取含有username，password，productname的JSONObject去登陆然后获取登陆后的token*/
    public  String getToken(JSONObject loginmessage){
        System.out.println(loginmessage);
        login lg = new login();
        String s = lg.login(loginmessage);
        System.out.println(s+"\n");
        String errorcode = StringToJson(s,"errorCode");
        String result="";
        if (errorcode.equals("0000")) {
            String accessToken = StringToJson(s,"accessToken");
            result = accessToken;
        }else {
            result = "loginErr";
        }
        return result;
    }

    /*获取"username":"","password":"","productname":""去登陆然后获取登陆后的userNo*/
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

    /*获取含有username，password，productname的JSONObject去登陆然后获取登陆后的userNo*/
    public  String getuserNo(JSONObject loginmessage){
        //3是","  6是userNo  16是需要取的长度
        login lg = new login();
        String s = lg.login(loginmessage);
        String errorcode = StringToJson(s,"errorCode");
        String result="";
        if (errorcode.equals("0000")) {
            String userNo = StringToJson(s,"userNo");
            result = userNo ;
        }else {
            result = "loginErr";
        }
        return result;
    }
    /*用户注册接口*/
    public void register(String username,String password,String productName){
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
        message.put("password",password);
        message.put("userName",username);
        System.out.println(message.toString());
        String resp = tp.transport(url,JsonToLotserverCommond(message));
        System.out.println(resp);
        //String userNo = StringToJson(resp,"userNo");
        //加入投注白名单和充值的接口先备注上，以后用的时候再放开
        //inserIntoWhite(userNo,"300","ltcp");
        //addMoney(userNo);
    }
    /*用户添加白名单接口*/
    public void inserIntoWhite(String userno,String level,String productname){
        /*
        投注白名单
        http:192.168.1.35:8080/lottery-order/betWhiteList/addAll
        * supportlottype=all&level=600&userno=2017110900121744&productname=qmcp&memo=888&id=2057065&type=1&status=0
        */
        String message = "supportlottype=all&level="+level+"&userno="+userno+"&productname="+productname+"&memo=测试&&type=1&status=1";
        String url = "http://192.168.1.35:8080/lottery-order/betWhiteList/addAll";
        testPost tp = new testPost();
        System.out.println(tp.transport(url,message));
    }
    /*用户加钱接口，模拟的是mgr的人工充值过程*/
    public  void addMoney(String userno){
        //貌似account没有直接给用户加钱的接口，有也特么的需要payid  我哪有啊
        testPost tp = new testPost();
        String url = "http://192.168.1.35:8080/lottery-account/userAccountAdd/addMoney";
        String url1 = "http://192.168.1.35:8080/lottery-account/userAccountAdd/audit";
        //1是可以提现，0是不可以提现，amount的分的单位
        String message = "userno="+userno+"&amount=10000&forDraw=0&creator=chen&memo=test&type=0";
        String resp = tp.transport(url,message);
        System.out.println(resp);
        JSONObject res = new JSONObject().fromObject(resp);
        /*/lottery-account/adminUserAccountAdd/list|P|endLine=10&condition={}&startLine=0&orderBy=createTime&orderDir=desc*/
        System.out.println(res);
        //获取需要审核的那个ID
        String auditId =  res.getJSONObject("value").getString("id");
        String message1 = "id="+auditId+"&auditer=chen&forPass=1";
        String resp1 = tp.transport(url1,message1);
        System.out.println(resp1);
    }

    /*注册N多个的用户*/
    public void registerN(String username,int num,String password,String productName) {
        for (int i = 0 ; i <=  num; i ++){
            if (i == 0){
                register(username,password,productName);
            }else{
                register(username+i,password,productName);
            }
        }
    }



    public static void main(String args[]){
        easyFun ez = new easyFun();
        ez.registerN("xpftestzhh",50,"123456","ltcp");
        /*ez.inserIntoWhite("20180205Z00038499","300","ltcp");
        JSONObject s = ez.StringToJson("{\"errorCode\":\"0000\",\"message\":\"查询成功\",\"result\":{\"batchCode\":\"2018018\",\"remainSeconds\":\"204568\",\"forwardEndTime\":\"2100\",\"endBetTimeFormat\":\"02-11（周日）19:25\"}}");
        String s1 = s.getJSONObject("result").getString("batchCode");
        System.out.println(s1);*/
       //ez.addMoney("2016092000352139");
        }
        }
