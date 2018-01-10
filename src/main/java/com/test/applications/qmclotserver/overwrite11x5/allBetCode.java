package com.test.applications.qmclotserver.overwrite11x5;

import net.sf.json.JSONObject;

/**
 * created by xiapf on 2018/1/9
 */
public class allBetCode {
    private String[] code = {"01","02","03","04","05","06","07","08","09","10","11"};
    public String[] setCode(){
        return code;
    }
    public JSONObject betpost(){
        JSONObject message = new JSONObject();
        message.put("platform","android");
        message.put("isCompress","0");
        message.put("requestType","toBet2");
        message.put("version","5.2.36");
        message.put("productName","ltcp");
        message.put("encPassword","c33367701511b4f6020ec61ded352059");
        message.put("oneAmount","200");
        message.put("amt","200");
        message.put("userNo","2016092000352139");
        message.put("command","bet");
        message.put("num","1");
        message.put("accessToken","a6ab6f2b17381ebfb0f01a3510e4cd55");
        message.put("trackType","0");
        return message;
    }
}
