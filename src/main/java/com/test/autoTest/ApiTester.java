package com.test.autoTest;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * created by xiapf on 2018/5/29
 */
public class ApiTester {

    public static  void main(String[] args) throws IOException {
        //定义URL
        String url="";
        //创建post方法
        HttpPost post = new HttpPost(url);
        //定义参数类型
        List<NameValuePair>  parameters = new ArrayList<NameValuePair>();
        //加入具体参数
        parameters.add(new BasicNameValuePair("phoneno","13811111111"));
        //给post加上参数
        post.setEntity(new UrlEncodedFormEntity(parameters));
        //创建法宝客户端--相当于打开了postman等这些发包工具
        HttpClient client = HttpClients.createDefault();
        //发起请求--》得到相应
        HttpResponse response  =  client.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        System.out.print(result);
    }
}
