package com.test.applications;
/**
 * Created by xiapf on 2017/3/28 0028.
 */

import com.test.applications.qmclotserver.postWay;
import com.test.applications.qmclotserver.testPost;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class readTxt {
    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        String each = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = "";
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                each = each+"FGF"+s;//""+每行获取到的值，并且为了之后自己号进行转换成数组，加入自己的分隔符FGF
                //System.out.println(each);
                //result.append(System.lineSeparator()+s).toString();

            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //将获取到的第一行再次进行转换元素并且输出
        //System.out.println(a[1].split(",")[1]);
        return each;//result.toString();
        /*下面是返回的数组，数组第一个为空 等待解决  如果返回数组  需要将函数的String 改成 String[]*/
        //String[] res= result.toString().split("\r\n");
        //return res;
    }

    public static void main(String[] args){
        File file = new File("C:\\Users\\Administrator\\Desktop\\phone.txt");
        // System.out.println(txt2String(file));  //查看了一下刚才获取到的并且加了FGF的字符串
        //将获取的所有转换成数组，没一个元素为一行，第一个元素是空的
        String a[] =txt2String(file).split("FGF");
        //厉害了我的哥  还特么的可以这样写,将数组写成数组[][]
        String test[][] = new String[a.length-1][];
        for (int i=1; i< a.length;i++){
            test[i-1]=a[i].split(",");
        }
        //post请求
        //String url = "http://192.168.1.57:8080/lotserver/user/loginMix";
        String url = "http://192.168.1.34:8080/lotserver/test/sendRequest";
        //String url = "http://192.168.1.63:8081/dataserver/userScore/getScoreList";
        String type = "post";
        String message="";
        postWay res = new postWay();
        testPost res1 = new testPost();
        //下面的for循环是json格式
        for(int i=1;i<=test[0].length-1;i++){
            for (int j = 0; j<test.length;j++){
                if (j == test.length-1) {
                    message = message + "\"" + test[j][0] + "\":\"" + test[j][i] + "\"";
                }else{
                    message = message + "\"" + test[j][0] + "\":\"" + test[j][i] + "\",";
                }
            }
            System.out.println("{"+message+"}");
            String data = "content={"+message+"}&urlAddress=http://127.0.0.1:8080/lotserver/lotserverServlet";
            System.out.println(data);

            //发送到sendRequest
            //String s = res.transRequest(url,type,data);
            //发送的是json格式
            //String s = res.transRequest(url,type,"{"+message+"}");
            //测试message，此处直接用的是message赋值
            //String s = res.transRequest(url,type,message);
            //System.out.println(s);
            String s1 = res1.transport(url,data);
            System.out.println(s1);
            message="";
        }

    }

}
