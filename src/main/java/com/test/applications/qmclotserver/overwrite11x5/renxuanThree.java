package com.test.applications.qmclotserver.overwrite11x5;

/**
 * created by xiapf on 2018/1/9
 */
public class renxuanThree {
    private bet11x5 b15 = new bet11x5();
    public void singleBet3(String phase,String multiple,String lotNo){
        allBetCode exw = new allBetCode();
        String[] code = exw.setCode();
        String betcode = "";
        for (int i =0;i<code.length;i++){
            for(int j = code.length-1 ;j>=0; j--){
                for(int k = code.length-1 ;k>=0; k--) {
                    if (i == j || j == k || i == k) {
                        continue;
                    } else {
                        betcode = lotNo + "03-" + code[i] + "," + code[j] + code[k]+"^";
                        b15.bet11x5Bysingle(lotNo, phase, multiple, betcode);
                    }
                }
            }
        }
    }
}
