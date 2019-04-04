package com.test.worldCup;

/**
 * created by xiapf on 2018/6/26
 */
public class run {
    public static void main(String[] args){
        getHTML page = new getHTML();
        getData data = new getData();
        String html_url = "http://www.bjlot.com/ssm/200/html/80702_07_06.html?dt=Wed%20Jul%2004%202018%2010:52:35%20GMT+0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&_=1530672755349";
        String data_url = "http://i.sporttery.cn/odds_calculator/get_odds?i_format=json&i_callback=getData&poolcode[]=hhad&poolcode[]=had&_=1529999840983";
        page.setPageUrl(html_url);
        page.getPageSourceWithoutHtml();
        //data.getData(data_url);
    }
}
