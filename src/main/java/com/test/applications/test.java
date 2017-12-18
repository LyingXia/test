package com.test.applications;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    // 火狐和谷歌两个不同的浏览器的启动方式需要的配置
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
    //System.setProperty("webdriver.firefox.bin","D:\\Mozilla Firefox\\firefox.exe");
    driver = new ChromeDriver();
    //driver = new FirefoxDriver();
    baseUrl = "https://sojump.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }


  public void test() throws Exception {
    driver.get(baseUrl + "/m/13607293.aspx");
    //因为一直说没有找到这个元素，通过xpath进行尝试并且输出元素内容一步步的进行往下查找了一下
//    System.out.println(driver.findElement(By.xpath("//div[@id='div1']")).getText());
//    System.out.println(driver.findElement(By.xpath("//div[@id='div1']/div[2]")).getText());
//    System.out.println(driver.findElement(By.xpath("//div[@id='div1']/div[2]/div[1]")).getText());
    driver.findElement(By.xpath("//div[@id='div1']/div[2]/div[1]")).click();
    driver.findElement(By.xpath("//div[@id='div2']/div[2]/div[1]")).click();
    driver.findElement(By.xpath("//div[@id='div3']/div[2]/div[1]")).click();
    driver.findElement(By.xpath("//div[@id='div4']/div[2]/div[1]")).click();
    driver.findElement(By.xpath("//div[@id='div5']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div6']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div7']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div8']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div9']/div[2]/div[4]")).click();
    driver.findElement(By.xpath("//div[@id='div10']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div11']/div[2]/div[1]")).click();
    driver.findElement(By.xpath("//div[@id='div12']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div13']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div14']/div[2]/div[1]")).click();
    driver.findElement(By.xpath("//div[@id='div15']/div[2]/div[1]")).click();
    driver.findElement(By.xpath("//div[@id='div16']/div[2]/div[1]")).click();
    driver.findElement(By.xpath("//div[@id='div17']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div18']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div19']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div20']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div21']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div22']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div23']/div[2]/div[3]")).click();
    driver.findElement(By.xpath("//div[@id='div24']/div[2]/div[1]")).click();
    driver.findElement(By.xpath("//div[@id='div24']/div[2]/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='div24']/div[2]/div[4]")).click();
    driver.findElement(By.xpath("//div[@id='div24']/div[2]/div[5]")).click();
    driver.findElement(By.xpath("//div[@id='div24']/div[2]/div[6]")).click();
    driver.findElement(By.xpath("//div[@id='div24']/div[2]/div[12]")).click();
    driver.findElement(By.xpath("//div[@id='div24']/div[2]/div[8]")).click();
    driver.findElement(By.xpath("//div[@id='div24']/div[2]/div[9]")).click();
    driver.findElement(By.xpath("//div[@id='div24']/div[2]/div[6]")).click();
    driver.findElement(By.id("ctlNext")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
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
      return false;
    }
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

  public static  void main(String arg[]){
    test t1=new test();
    try {
      t1.setUp();
      t1.test();
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
