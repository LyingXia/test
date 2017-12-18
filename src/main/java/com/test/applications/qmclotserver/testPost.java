package com.test.applications.qmclotserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by xiapf on 2017/7/11 0011.
 */
public class testPost {
    public String transport(String url, String message) {
        StringBuffer sb = new StringBuffer();
        try {
            URL urls = new URL(url);
            HttpURLConnection uc = (HttpURLConnection) urls.openConnection();
            uc.setRequestMethod("POST");
            uc.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            /*uc.setRequestProperty("content-type", "text/plain");*/
            uc.setRequestProperty("charset", "UTF-8");
            uc.setDoOutput(true);
            uc.setDoInput(true);
            uc.setReadTimeout(10000);
            uc.setConnectTimeout(10000);
            OutputStream os = uc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.write(message.getBytes("utf-8"));
            dos.flush();
            os.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc
                    .getInputStream(), "utf-8"));
            String readLine = "";
            while ((readLine = in.readLine()) != null) {
                sb.append(readLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + ":" + e);
        }
        return sb.toString();
    }
}
