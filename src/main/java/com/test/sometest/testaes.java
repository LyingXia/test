package com.test.sometest;

import com.lottery.common.util.AES;
import org.apache.commons.lang.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * created by xiapf on 2018/3/15
 */
public class testaes {
    //chargecenter的AES加密解密
    private static char[] Base64Code = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '+', '/' };

    private static byte[] Base64Decode = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 63,
            -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };

    public static final String aesKey = "q8%m9sf^d3w<49_#";

    public static byte[] aesEncrypt(byte[] input, int offset, int length, String aesKey)
            throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
    {
        byte[] put = new byte[length];
        System.arraycopy(input, offset, put, 0, length);
        SecretKeySpec skeySpec = new SecretKeySpec(aesKey.getBytes(Charset.defaultCharset()), "AES");
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(1, skeySpec);
        byte[] encrypt = c.doFinal(put);
        return encrypt;
    }

    public static String encrypt(String value, String key)
            throws Exception
    {
        byte[] bytes = value.getBytes("UTF-8");
        byte[] encrypt = aesEncrypt(bytes, 0, bytes.length, key);
        return Base64.encode(encrypt);
    }



    public static byte[] aesDecrypt(byte[] input, int offset, int length, String aesKey)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        byte[] put = new byte[length];
        System.arraycopy(input, offset, put, 0, length);
        SecretKeySpec sS = new SecretKeySpec(aesKey.getBytes(Charset.defaultCharset()), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, sS);
        byte[] decrypted = cipher.doFinal(put);
        return decrypted;
    }


    public static String decrypt(String value, String key)
            throws Exception
    {
        byte[] decode = Base64.decode(value);
        byte[] aesDecrypt = aesDecrypt(decode, 0, decode.length, key);
        return new String(aesDecrypt, "UTF-8");
    }

    public String setAes(String param) {
        try {
            String result = getAesPrefix() + AES.encrypt(param,aesKey);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            System.out.println("aes encrypt fail，param：{}"+ param);
        }
        return param;
    }
    public String getUnAes(String aesParam) {
        try {
            return AES.decrypt(StringUtils.replace(aesParam, getAesPrefix(), ""), aesKey);
        } catch (Exception e) {
            System.out.println("aes decrypt fail，param：{}"+ aesParam);
        }
        return null;
    }
    public String getAesPrefix() {
        return "$:";
    }



    public static  void  main(String []args) throws Exception {
        //这个是Lottery-order和Chargecneter用的KEY
        String key = "q8%m9sf^d3w<49_#";
        String code = "6LEoDdwjO1AwNoL3FzQgq7C6Lf4qJ7fAgeYdeRoZBfM=";
        String code1 = "110228199309083814";
        System.out.println(encrypt(code1,key));
        System.out.println(decrypt(code,key));
        testaes ta = new testaes();
        ta.setAes(code1);
        ta.getUnAes("$:FN+hlcOENlAgtCy2nziTcIsitfTmLLwCl4hpl2eeu2A=");
    }
}
