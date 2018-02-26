package com.test.applications.qmclotserver.overwrite11x5;

import com.test.applications.qmclotserver.testPost;
import net.sf.json.JSONObject;

/**
 * created by xiapf on 2018/1/9
 */
public class bet11x5 {
    testPost tp = new testPost();
    allBetCode abc = new allBetCode();
    public void bet11x5Bysingle(String lotNo,String phase,String multiple,String betcode){
        String url = "http://192.168.1.31:8080/lotserver/test/sendRequest";
        JSONObject bet = abc.betpost();
        String amount = Integer.toString(Integer.parseInt(multiple)*200);
        bet.put("lotNo",lotNo);
        bet.put("batchCode",phase);
        bet.put("multiple",multiple);
        bet.put("betCode",betcode);
        bet.put("amount",amount);
        String message = "content="+bet.toString()+ "&urlAddress=http://127.0.0.1:8080/lotserver/lotserverServlet";
        System.out.println(message);
        System.out.println(tp.transport(url,message));
    }
    public static void main(String[] args){
        renxuanTwo rxt = new renxuanTwo();
        String phase = "2018011230";
        String multiplue = "2";
        String lotNo = "2801";
        rxt.singleBet2(phase,multiplue,lotNo);
    }
}
