package com.test.sometest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * created by xiapf on 2018/6/15
 */
public class sameCar {
    public void getHTML() {
        String url = "http://wx.hpinche.com/index/load_info";
        //创建post方法
        String result = "";
        BufferedReader in = null;
        HttpURLConnection connection = null;
        try {
            URL paostUrl = new URL(url);
            //请求配置
            connection = (HttpURLConnection) paostUrl.openConnection();
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);

            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            System.out.println(in);
            String line = in.readLine();
            while (line != null) {
                result += line;
                line = in.readLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("get请求发生异常"+",url="+url);
        }
    }
    public  static void main(String[] args){
        sameCar sm = new sameCar();
        sm.getHTML();
    }
}
