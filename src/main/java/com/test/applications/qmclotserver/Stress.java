package com.test.applications.qmclotserver;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by xiapf on 2018/7/20
 */
public class Stress {
    private testPost tp = new testPost();
    private String url = "http://192.168.12.191:8080/lotserver/system/flushCache";
    private String message = "";
    public void test() throws InterruptedException {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        while (true){
            for (int i=0;i<30;i++){
                System.out.println(dateFormat.format(date)+ ":"+ i);
                tp.transport(url,message);
            }
            Thread.sleep(1000);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Stress st = new Stress();
        st.test();
    }
}
