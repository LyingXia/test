package com.test.applications.qmclotserver;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 * Created by xiapf on 2017/7/11 0011.
 * 暂时有点问题
 */
public class postWay{
    public String transRequest(String url, String type, String message) {
// 响应内容
        String result = "";
// 定义http客户端对象--httpClient
        HttpClient httpClient = new HttpClient();
// 定义并实例化客户端链接对象-postMethod
        PostMethod postMethod = new PostMethod(url);
        try{
// 设置http的头
            postMethod.setRequestHeader("ContentType","application/x-www-form-urlencoded");
           //请求到sendRequest尝试是否需要这样的http头
      /*      postMethod.setRequestHeader("ContentType", "text/plain");*/
// 填入各个表单域的值
            NameValuePair[] data = { new NameValuePair("type", type),
                    new NameValuePair("message", message) };
// 将表单的值放入postMethod中
            postMethod.setRequestBody(data);
// 定义访问地址的链接状态
            int statusCode = 0;
            try {
// 客户端请求url数据
                statusCode = httpClient.executeMethod(postMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }
// 请求成功状态-200
            if (statusCode == HttpStatus.SC_OK) {
                try {
                    //result = postMethod.getResponseBodyAsString();
                    result = postMethod.getResponseBodyAsString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
               System.out.println("请求返回状态：" + statusCode);
            }
        } catch (Exception e) {
         System.out.println(e.getMessage() + "" +e);
        } finally {
// 释放链接
            postMethod.releaseConnection();
            httpClient.getHttpConnectionManager().closeIdleConnections(0);
        }
        return result;
    }
}