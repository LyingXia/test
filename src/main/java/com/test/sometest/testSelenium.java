package com.test.sometest; /**
 * Created by xiapf on 2017/3/7 0007.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.*;
public class testSelenium {
    public void testsele(String testurl){

        /*设置要启动的浏览器的位置*/
//        System.setProperty("webdriver.firefox.bin","D:\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.chrome.driver","D:\\work\\environment\\selenium-java\\chromedriver.exe");

//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

       /*设置url*/
        driver.get(testurl);
//      driver.quit();
    }

    public static void main(String[] args) {
        testSelenium test = new testSelenium();
        test.testsele("www.baidu.com");
    }
}

