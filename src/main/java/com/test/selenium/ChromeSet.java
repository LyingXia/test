package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * created by xiapf on 2018/5/29
 */
public class ChromeSet {
    public static void main(String args[]) throws Exception{
        System.setProperty("webdriver.chrome.driver","D:\\work\\file\\这个文件夹 今天开始属于我\\新人工作常用软件\\chromedriver.exe");
        //System.setProperty("webdriver.firefox.bin","D:\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        //driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");
        driver.quit();
    }
}
