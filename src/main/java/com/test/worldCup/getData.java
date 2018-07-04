package com.test.worldCup;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


/**
 * created by xiapf on 2018/6/26
 */
public class getData {
    public void getData(String url) {
        String s = get(url);
        s = s.replace("getData(","");
        s = s.replace(");","");
        JSONObject json = JSONObject.fromObject(s);
        json.entrySet();
        System.out.println(json);
        JSONObject json_data = json.getJSONObject("data");
        //获取json串中的key值都是哪些
        JSONArray keys = json_data.names();
        System.out.println(keys);
        for(int i= 0;i<keys.size();i++){
            String key = keys.get(i).toString();
            JSONObject key_data_value = json_data.getJSONObject(key);
            if(key_data_value.containsValue("世界杯") && key_data_value.containsValue("2018-06-27")){
                    System.out.println(key_data_value.getString("h_cn")+"VS"+key_data_value.getString("a_cn"));
            }
        }
        System.out.println(json_data.values());
    }
    public  String get(String url) {
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
