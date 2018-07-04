package com.test.worldCup;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by xiapf on 2018/6/26
 * 北京体彩网数据源---北单
 */
public class getHTML {
    private write wt = new write();
    private List<String[]> list = new ArrayList<>();
    private String pageUrl;//定义需要操作的网页地址
    private String pageEncode="UTF8";//定义需要操作的网页的编码
    public String getPageUrl() {
        return pageUrl;
    }
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
    public String getPageEncode() {
        return pageEncode;
    }
    public void setPageEncode(String pageEncode) {
        this.pageEncode = pageEncode;
    }
    //定义取源码的方法
    public String getPageSource()
    {
        StringBuffer sb = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), pageEncode));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null)
            {
                sb.append(line);
            }
            in.close();
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
        return sb.toString();
    }
    //定义一个把HTML标签删除过的源码的方法
    public void getPageSourceWithoutHtml() {
        String htmlStr = getPageSource();//获取未处理过的源码
        htmlStr = htmlStr.replaceAll("</td>","</td>\n");
        final String regEx_betWorldCup = "<td.*><label>.*2018世界杯.*</span></label></td>";
        Pattern p_betWorldCup = Pattern.compile(regEx_betWorldCup,Pattern.CASE_INSENSITIVE);
        Matcher m_betWorldCup = p_betWorldCup.matcher(htmlStr);
        ArrayList al=new ArrayList();
        while (m_betWorldCup.find()) {
            al.add(m_betWorldCup.group(0));
        }
        //System.out.println("去除重复值前");
        for (int i=0;i<al.size();i++)
        {
            String a = al.get(i).toString();
            String team = a.substring(a.indexOf("(")+1,a.indexOf(",\'2018世界杯\'")).replace("\'","");
            String odd = a.substring(a.indexOf("<span value=")+13,a.lastIndexOf("\""));
            String team_odd = team + "," + odd;
            al.set(i , team_odd);
            //System.out.println(al.get(i).toString());
        }
        //去除重复值
        HashSet hs=new HashSet(al);
        al.clear();
        al.addAll(hs);
        //System.out.println("去除重复值后");
        for (int i=0;i<al.size();i++)
        {
            System.out.println(al.get(i).toString());
            /*wt.writeTxt(al.get(i).toString());*/
            String[] a = al.get(i).toString().split(",");
            list.add(a);
        }
        writeExcel we = new writeExcel();
        String[] ab = {"1d","2d"};
        //we.writeExcel("C:\\Users\\user\\Desktop\\betOdds.xlsx",list,"test",ab);
        we.xssWriteExcel2(list);
        //we.poiWriteExcel(list);


       /* final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
        final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符*/
     /*   Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签
        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        htmlStr = htmlStr.trim(); // 返回文本字符串
        htmlStr = htmlStr.replaceAll(" ", "");
        htmlStr = htmlStr.substring(0, htmlStr.indexOf("。")+1);*/
    }


}
