package com.test.sometest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;

/**
 * created by xiapf on 2018/8/7
 */
public class AppServlet_Request {
    public static final String contentType = "text/plain;charset=UTF-8";

    //解密
    public static String decryptForByte(byte[] sSrc, String sKey) throws Exception
    {
        try
        {
            byte[] raw = sKey.getBytes("GBK");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, skeySpec);

            byte[] original = cipher.doFinal(sSrc);
            return new String(original);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //加密
    public static byte[] encryptToByte(String sSrc, String sKey) throws Exception
    {
        byte[] raw = sKey.getBytes("GBK");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        return encrypted;
    }

    public static byte[] encrypt2Bytes(byte[] src, String sKey) {
        try {
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, skeySpec);
            return cipher.doFinal(src);
        }
        catch (Exception e) {
            e.printStackTrace();
        }return null;
    }

    public static byte[] decrypt2Bytes(byte[] src, String sKey) throws Exception
    {
        try {
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, skeySpec);
            byte[] encrypted1 = src;
            try {
                return cipher.doFinal(encrypted1);
            }
            catch (Exception localException1) {
                return null;
            }
        } catch (Exception localException2) {  }

        return null;
    }

    public static byte[] post(String url,byte[] bytes) throws IOException {
        String m_url = url;
        HttpClient m_HttpClient = new HttpClient();
        PostMethod method = new PostMethod(m_url);
        method.setRequestHeader("Content-type" , "application/octet-stream;charset=UTF-8");
        method.setRequestEntity(new ByteArrayRequestEntity(bytes));
        int HttpCode = m_HttpClient.executeMethod(method);
        if (HttpCode != HttpStatus.SC_OK)
            throw new IOException("Invalid HttpStatus: " + HttpCode);
//        InputStream respStream = method.getResponseBodyAsStream();
        byte[] s = method.getResponseBody();
        int respBodySize = (int) method.getResponseContentLength();
        if (respBodySize <= 0)
            throw new IOException("Invalid respBodySize: " + respBodySize);
        byte[] respBuffer = new byte[respBodySize];
//        if (respStream.read(respBuffer) != respBodySize)
//            throw new IOException("Read respBody Error");
        return s;
    }

    public static byte[] post1(String url,byte[] bytes) throws IOException{
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new ByteArrayEntity(bytes));
        httpPost.setHeader("Content-type", "text/plain;charset=UTF-8");
        CloseableHttpResponse httpResponse = HttpClients.createDefault().execute(httpPost);
        try {
            HttpEntity entityResponse = httpResponse.getEntity();
            int contentLength = (int) entityResponse.getContentLength();
            if (contentLength <= 0)
                throw new IOException("No response");
            byte[] respBuffer = new byte[contentLength];
            if (entityResponse.getContent().read(respBuffer) != respBuffer.length)
                throw new IOException("Read response buffer error");
            return respBuffer;
        } finally {
            httpResponse.close();
        }
    }


    public static void main(String[] args) throws Exception {
        AppServlet_Request ar = new AppServlet_Request();
        String MLurl = "http://192.168.1.50:8080/lotserver/appServlet/validateCode/generate";
//        String data = "content={\"code\":\"0\",\"imei\":\"865166021999555\",\"key\":\"67bad6e7bac3bb8fe80fdb41aeea2519\",\"mobileId\":\"15144587547\",\"productName\":\"ltcp3\"}&urlAddress=http://127.0.0.1:8080/lotserver/appServlet";
//        String data = "{\"code\":\"0\",\"imei\":\"865166021999555\",\"key\":\"67bad6e7bac3bb8fe80fdb41aeea2519\",\"mobileId\":\"15144587547\",\"productName\":\"ltcp3\"}";
        String data = "{\"requestType\":\"generate\",\"bssid\":\"\",\"channel\":\"AppStore\",\"type\":\"6\",\"version\":\"1.1.0\",\"ssid\":\"\",\"mac\":\"c4:b3:01:d1:ab:b9\",\"productName\":\"\",\"platform\":\"iOS\",\"command\":\"validateCode\",\"machineId\":\"iPhone Simulator\",\"osVersion\":\"11.4\",\"imei\":\"62429A2C-4054-4D61-80AC-AD51B4F71203\"}";
        String key = "thisiskey";
        byte[] request = encryptToByte(data,key);
        System.out.println(request);
        byte[] appRe = ar.post1(MLurl,request);
        System.out.println(appRe);
        String response = decryptForByte(appRe,key);
        System.out.println(response);

    }
}
