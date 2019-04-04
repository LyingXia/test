package com.test.sometest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
/**
 * created by xiapf on 2018/3/12
 */
public class testHex {
    //lotserver中收到的请求参数的解密的原则
    public static String decrypt(String sSrc, String sKey) throws Exception
    {
        try
        {
            //使用sKey生成秘钥
            byte[] raw = sKey.getBytes("GBK");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

            //创建密码器    //"算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //初始化  2代表了Cipher.DECRYPT_MODE ，1代表Cipher.ENCRYPT_MODE
            cipher.init(2, skeySpec);
            byte[] encrypted1 = hex2byte(sSrc.getBytes());
            //System.out.println(new String(encrypted1));
            byte[] original = cipher.doFinal(encrypted1);
            System.out.println(new String(original));
            return new String(original);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public static byte[] hex2byte(byte[] b)
    {
        if (b.length % 2 != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[(n / 2)] = (byte)Integer.parseInt(item, 16);
        }
        return b2;
    }

    //lotserver中的加密规则
    public static String encrypt(String sSrc, String sKey) throws Exception
    {
        byte[] raw = sKey.getBytes("GBK");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        System.out.println(byte2hex(encrypted).toLowerCase());
        return  byte2hex(encrypted).toLowerCase();
    }

    public static String byte2hex(byte[] b)
    {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

    //返回参数返给客户端之前，还进行了一步加密处理
    public static byte[] compress(byte[] data) throws IOException {
        byte[] output = new byte[0];
        Deflater compresser = new Deflater();
        compresser.reset();
        compresser.setInput(data);
        compresser.finish();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!compresser.finished()) {
                int i = compresser.deflate(buf);
                bos.write(buf, 0, i);
            }
            output = bos.toByteArray();
        } catch (Exception e) {
            output = data;
                bos.close();
        }
        finally
        {
            try
            {
                bos.close();
            } catch (IOException e) {

            }
        }
        compresser.end();
        return output;
    }

      public static String base64Encode(byte[] src, String charset)
    {
        Base64 base64 = new Base64();
        //try {
            return new String(base64.encode(src));
        //} catch (UnsupportedEncodingException e) {
         //   System.out.println("error"+ e);
        //}return null;
    }

/*    public static byte[] base64Decode(String src, String charset)
    {
        Base64 base64 = new Base64();
        try {
            return base64.decode(src.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            System.out.println("error"+ e);
        }return null;
    }*/

    public static void main(String[] args) throws Exception {
        String secretKey = "thisiskey";
        //下面的是卖料的
        String key1 = "thisiskey";
        //如果是返回的字符串想要查看是什么，应该要再通过Fiddler的TextWizard中的使用From DeflateSAML 再次的转一下，就行了
        //如果是直接的请求参数，那么则直接就会查看到输入的是什么
        String result = "058893a67e41c5c5770f277244155b044724f3868f4b25a37961842df752a6d43f524b5bc196faa1c09d526a72717388ccfcae56a373cbc63f2f911b8b466e5678c745dcca0f2cf9a204c8e828c3f88d3bd0577e5f0e8c0dcd446b8a146f35bcaa56f5a7c1e6da394d998cecd433e5cb757a8c8b544bddf9e947005361c54ecf6d3cc1951d8f99ced2a292bc54ca904a7d5ba9b6b41e14e9c0dc2c51cf70c0e25d763e14871fe9c91bf67ac82efd266dd01b951ba84328c57392cef18cfddabef3c59d80af5c013d1b5b8c376a4a86121a7acba78b598b29dcbace6fe332aaf286238a9277718ded1c8cff46b24e5771f7c414ba524c3cd5acebb9553213e4ca95e77e1ae201c3c54cd5007ec0ee60f846cd9d5605f0baf8d0732f792e9e2b0d88c653dd70dfd750c4ac51d0d0c8996d1370d877d9b369fb83754fd9cc39099da2ee5af9441938dea19401feba56d1a41220e3027717984993fe922bc8f23774852d613eb66424c1fc5c7776663bbc25dbd293e705e0d71087a9a48e4c1bf912cc1179c7b08960a3da9e2432d0af604e0fc0dbb58c0f405563fc90ae0814c75a4dd27d23ed7d67866c80a4b61fc43cf255481abad5bc60970d4b46f0a4004ed7a7c3691fecd46d92dbbe30c551af921e7eff00f1ac63c3e3841705c3becbf06f51ae358dc1d44c9f8fcfcc094f4ab3c210fada85306acbee68e5c9501069ce711aa15b30b2f67dccc0580ca91b2bdeec8347d1468d4f139e01ce57eed47293b33c7464daa0fad5057241b33e71e7b332";
        String register = "058893a67e41c5c5770f277244155b044724f3868f4b25a37961842df752a6d43f524b5bc196faa1c09d526a72717388ccfcae56a373cbc63f2f911b8b466e5678c745dcca0f2cf9a204c8e828c3f88d3bd0577e5f0e8c0dcd446b8a146f35bcaa56f5a7c1e6da394d998cecd433e5cb757a8c8b544bddf9e947005361c54ecf6d3cc1951d8f99ced2a292bc54ca904a7d5ba9b6b41e14e9c0dc2c51cf70c0e25d763e14871fe9c91bf67ac82efd266dd01b951ba84328c57392cef18cfddabef3c59d80af5c013d1b5b8c376a4a86121a7acba78b598b29dcbace6fe332aaf286238a9277718ded1c8cff46b24e5771f7c414ba524c3cd5acebb9553213e4ca95e77e1ae201c3c54cd5007ec0ee60f846cd9d5605f0baf8d0732f792e9e2b0d88c653dd70dfd750c4ac51d0d0c8996d1370d877d9b369fb83754fd9cc39099da2ee5af9441938dea19401feba56d1a41220e3027717984993fe922bc8f23774852d613eb66424c1fc5c7776663bbc25dbd293e705e0d71087a9a48e4c1bf912cc1179c7b08960a3da9e2432d0af604e0fc0dbb58c0f405563fc90ae0814c75a4dd27d23ed7d67866c80a4b61fc43cf255481abad5bc60970d4b46f0a4004ed7a7c3691fecd46d92dbbe30c551af921e7eff00f1ac63c3e3841705c3becbf06f51ae358dc1d44c9f8fcfcc094f4ab3c210fada85306acbee68e5c9501069ce711aa15b30b2f67dccc0580ca91b2bdeec8347d1468d4f139e01ce57eed47293b33c7464daa0fad5057241b33e71e7b332";
        testHex.decrypt(register,secretKey);
        testHex.decrypt(result,secretKey);
        //实验给请求翻译出来的参数进行修改后继续加密传递
        String result1 = "{ \"command\":\"analysisJl\", \"requestType\":\"immediateScoreDetail\", \"platform\":\"android\", \"imei\":\"3434343434534534\", \"version\":\"2.3.0\", \"machineId\":\"HTC Desire\", \"channel\":\"1\", \"event\":\"20180917301\" }";
        testHex.encrypt(result1,secretKey);
 /*       //实验给返回值进行第一步的加密，这步之后再进行ehncrypt就是返回给客户端的参数了
        String compress = "{\"platform\":\"android\",\"pkgName\":\"com.zhitou.information\",\"osVersion\":\"4.4.2\",\"accessToken\":\"\",\"imei\":\"866174011542251\",\"machineId\":\"OPPO R11\",\"requestType\":\"immediateScore\",\"mac\":\"54:E1:AD:43:75:FF\",\"type\":\"4\",\"date\":\"20180917\",\"isCompress\":\"0\",\"version\":\"6.2.66\",\"bssid\":\"54:E1:AD:43:75:FF\",\"token\":\"AgNlf9XIaJ19C4ywFcWXSoksrK0beB112D_FmDm6xwSl\",\"command\":\"analysisJl\",\"productName\":\"ltcp3\",\"channel\":\"1470001\"}";
        byte[] compress1 =  compress.getBytes();
        String response = base64Encode(compress(compress1), "UTF-8");
        System.out.println(response);
        testHex.encrypt(response,secretKey);

        String key = "2801cb0c28d314fa7e54c8ff8932a4b1";
        String cacheKey = StringUtil.join("_", new String[] { "accesscenter", "validateCode", key });
        System.out.println(cacheKey);*/
    }
}
