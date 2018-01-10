package com.test.applications.qmclotserver.overwrite11x5;

/**
 * created by xiapf on 2018/1/9
 */
public class renxuanTwo {
    private bet11x5 b15 = new bet11x5();
    public void singleBet2(String phase,String multiple,String lotNo){
        allBetCode exw = new allBetCode();
        String[] code = exw.setCode();
        String betcode = "";
        for (int i =0;i<code.length;i++){
            for(int j = code.length-1 ;j>=0; j--){
                if (i == j ){
                    continue;
                }else{
                    betcode = lotNo + "02-"+code[i]+","+code[j]+"^";
                    b15.bet11x5Bysingle(lotNo,phase,multiple,betcode);
                }
            }
        }
    }
    public void mutipBet2(){

    }
}
