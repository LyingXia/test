package com.test.sometest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

//下面两个引入是为了webdriver  找不到元素   等待元素出现的


public class testSele {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @Before
  public void setUp() throws Exception{
    // 火狐和谷歌两个不同的浏览器的启动方式需要的配置
    System.setProperty("webdriver.chrome.driver","D:\\work\\file\\这个文件夹 今天开始属于我\\新人工作常用软件\\chromedriver.exe");
    //System.setProperty("webdriver.firefox.bin","D:\\Mozilla Firefox\\firefox.exe");
    driver = new ChromeDriver();
    //driver = new FirefoxDriver();
    baseUrl = "http://192.168.1.31:8081";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSele() throws Exception{
    driver.get(baseUrl + "/mgr/login.jsp");
    //driver.findElement(By.id("account")).clear();
    //driver.findElement(By.id("password")).clear();

    //找不到元素的时候  等待元素出现
    WebDriverWait wait = new WebDriverWait(driver,100);
      wait.until(new ExpectedCondition<WebElement>(){
      @Override
      public WebElement apply(WebDriver d) {
        return d.findElement(By.id("account"));
      }}).clear();

    driver.findElement(By.id("account")).sendKeys("chen");
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.id("ext-gen24")).click();
    //System.out.println(driver.getPageSource());
    //System.out.println(driver.getTitle());

    WebDriverWait wait1 = new WebDriverWait(driver,100);
    wait1.until(new ExpectedCondition<WebElement>(){
      @Override
      public WebElement apply(WebDriver d) {
        return d.findElement(By.id("ext-gen130"));
      }}).click();

    driver.findElement(By.id("ext-gen32")).click();
    driver.findElement(By.xpath("//ul[@id='ext-gen32']/div/li[5]/div/a/span")).click();
    driver.findElement(By.id("ext-gen20")).click();
  }
  @After
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false; }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
