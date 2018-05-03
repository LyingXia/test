package com.test.sometest;

import org.apache.poi.util.StringUtil;

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
        String secretKey = "b^9@q!(+u%~?*%w<";
        //如果是返回的字符串想要查看是什么，应该要再通过Fiddler的TextWizard中的使用From DeflateSAML 再次的转一下，就行了
        //如果是直接的请求参数，那么则直接就会查看到输入的是什么
        String result = "10f161f443806576c444702a9ce38411f144ed2698ddc95c6d6fde76ed9fd62aab6ac4bb2c4bf7497130769f0b40847f33e4cba9ac3a8ce5bb1151e25641c0cd70cefe17547d8f09500bd766d1e40102f214b4af9ca8d89ce6a7cfc016c2615e1b48a645c1710aa6530ee21a1c509e61d20789dfd57fd3c7dc2d434332dcdcffcffd426428d53c75fad04c4c7b2e68f3514b565741fd8c793f2deb46de6c0729390f0437895a6e1929388971ddf310e5841f2eec2277188314bd01e680e2f6d4ee640f31bf5f9b7663936a386ec750daa45c75a39fd6c255b0f478f0e8fc303f4f0f4f18e79b7a6caaa2356dfe37e7c807b385a224ac40054ffacaff431dd978d166ddcee8bb1b73c2f8a86770b37e2cb82f5ab38ba22da46fc02c81a8ecc0617cd156dbe6ef33d57266448939656d6e4f5b588afa9f5483f04d3ff78a28cbfdc4ff3ed7e0a7be220022e945c5cf41c45d54071efe55c21e6230ea51e4c94f84ee6d91c16c0f910ebeed6a089956db9b4da6246ed754fdb66e3423f1bdf49f5e330431884816c6b97fbf305942bf907e92213fb3d6af94e37170e88fd62118bb6910318d89faefd034ae134b9f54b8381a967ed0b6587e0a4d022eacc1d6809e55a193a073db0da734c8b6b58de0b92f946d2da36c5a0eb71e0e1457b98a35dcae1970acec92b7e09eefb5cc7d512196b7ecf8830ded05457375a6f49dcf1287362a0556ee103adf202c3e71857e17ec984e66b1a449909d979289b337c3ec7b1a9a5c3799a7a530e4fb30cebf4095fcf3f4e36e8d5a5654d3b2d7d0e76a7c96ba892e9d54c7545f016820e74e28271b";
        String register = "d6643192d23decc98b16821c7d368468294039f04137990eaf072536bcd294251b98b41910bde1c58a2a92bc759255ede7ef49635d274203147754f185dd2fc56d5f1b2dbb1cbae741ea4c1142fdc097";
        testHex.decrypt(register,secretKey);
        testHex.decrypt(result,secretKey);
        //实验给请求翻译出来的参数进行修改后继续加密传递
        String result1 = "{\"platform\":\"android\",\"pkgName\":\"com.zhitou.information\",\"osVersion\":\"4.4.2\",\"accessToken\":\"d07d91c9b3ca97e2ab80e0a6a9f4b85e\",\"imei\":\"866174011542251\",\"machineId\":\"OPPO R11\",\"bankName\":\"招商银行\",\"requestType\":\"toCash\",\"mac\":\"54:E1:AD:43:75:FF\",\"isCompress\":\"1\",\"version\":\"6.2.50\",\"amount\":\"-10000\",\"cardNo\":\"6214830108340778\",\"bssid\":\"54:E1:AD:43:75:FF\",\"address\":\"夏鹏飞\",\"token\":\"AgNlf9XIaJ19C4ywFcWXSomVOfiO8ew8BkMjyrdq5Aks\",\"userNo\":\"2016011801687589\",\"name\":\"夏鹏飞\",\"command\":\"cash\",\"encPassword\":\"c33367701511b4f6020ec61ded352059\",\"productName\":\"ltcp3\",\"channel\":\"1030014\"}";
        testHex.encrypt(result1,secretKey);
        //实验给返回值进行第一步的加密，这步之后再进行ehncrypt就是返回给客户端的参数了
        String compress = "{\"errorCode\":\"0000\",\"message\":\"查询成功\",\"result\":{\"mobileId\":\"13810765094\",\"nickName\":\"testUL\",\"headpic\":\"https://osscdn.qmcai.com/avatar/product/2016011801687589_1490218917306.png\",\"name\":\"夏鹏飞\",\"certId\":\"110228199309083814\",\"isNameCheck\":\"1\",\"hasPayPwd\":\"1\",\"safeQuestion\":\"您的出生地是?\",\"balance\":\"100.74\",\"drawBalance\":\"100.74\",\"noDrawBalance\":\"0.00\",\"goldBalance\":\"39.99\",\"happyBeanBalance\":\"-\",\"goldExchange\":\"39.99\",\"goldUnExchange\":\"0.00\",\"bankName\":\"招商银行\",\"bankNo\":\"6214830108340778\",\"bankUserName\":\"夏鹏飞\",\"exchangeQuota\":\"42132\",\"transferFlag\":\"2\",\"pkgName\":\"ltcp\",\"inviteSwitch\":\"1\",\"isUnReadMsg\":\"0\"}}";
        byte[] compress1 =  compress.getBytes();
        String response = base64Encode(compress(compress1), "UTF-8");
        System.out.println(response);
        testHex.encrypt(response,secretKey);

        String key = "2801cb0c28d314fa7e54c8ff8932a4b1";
        String cacheKey = StringUtil.join("_", new String[] { "accesscenter", "validateCode", key });
        System.out.println(cacheKey);
    }
}
