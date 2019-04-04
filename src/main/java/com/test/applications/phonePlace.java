package com.test.applications;

/**
 * Created by xiapf on 2017/3/27 0027.
 */
import org.openqa.selenium.chrome.ChromeDriver;
//下面两个引入是为了webdriver  找不到元素   等待元素出现的
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.firefox.*;
public class phonePlace {
    public void search(String testurl){

        /*设置要启动的浏览器的位置*/
//        System.setProperty("webdriver.firefox.bin","D:\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.chrome.driver","D:\\work\\environment\\selenium-java\\chromedriver.exe");
        System.out.println("s");

//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

       /*设置url*/
        driver.get(testurl);
//      driver.quit();
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("13827065094");
        driver.findElement(By.id("su")).click();
        //超时等待，但是有个问题是 如果不是手机号就一直等待，可能需要提前判断一下是否为手机号格式
        WebDriverWait wait = new WebDriverWait(driver,100);
        String jieguo = wait.until(new ExpectedCondition<WebElement>(){
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.className("op_mobilephone_r"));
            }}).getText();
        driver.quit();
        System.out.println(jieguo);
        System.out.println(jieguo.length());
        String[] arr = jieguo.split(" ");
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        //目前这里是一个比较不合理的判断，不太适合所有的东西
        //具体可以看看arr里面的内容
        //System.out.println(jieguo.substring(19,21));


    }
    public static void main(String[] args) {
        phonePlace test =new phonePlace();
        test.search("https://www.baidu.com");
    }
}
