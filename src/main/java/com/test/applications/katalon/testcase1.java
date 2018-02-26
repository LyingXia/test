package com.test.applications.katalon;

/**
 * created by xiapf on 2018/2/6
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class testcase1 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\work\\file\\这个文件夹 今天开始属于我\\新人工作常用软件\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://zt-mgr.aetest.bwae.org";
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[1]/div/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[1]/div/div[1]/input")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(":\"123456789a");
        driver.findElement(By.cssSelector("span")).click();
        /*点击业务管理*/
        //*[@id="app"]/div/div[2]/div[2]/div[2]/div[2]/div[4]/iframe
        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(new ExpectedCondition<WebElement>(){
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/ul/div[4]/li/div/span"));
            }}).click();
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/ul/div[4]/li/div/span")).click();
        /*点击人工充值*/
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div/div[2]/ul/div[4]/li/ul/div[10]/li")).click();
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/button/span")).click();
        /*这里有一步切换到iframe步骤*/
        WebElement iframe_tab = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/iframe"));
        driver.switchTo().frame(iframe_tab);
        /*点击新增*/
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/button")).click();
        //driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input.el-input--small > input.el-input__inner")).click();
        driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input.el-input--small > input.el-input__inner")).clear();
        driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input.el-input--small > input.el-input__inner")).sendKeys("2016092000352139");
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("100");
        //因为这个新的mgr的下拉框限制，所以，只能通过下面两行来进行下拉框的选择---加款类别
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).click();
        driver.findElement(By.xpath("//div[3]/div/div/ul/li[4]")).click();
//        wait.until(new ExpectedCondition<WebElement>(){
//            @Override
//            public WebElement apply(WebDriver d) {
//                return d.findElement(By.xpath("//div[3]/div/div/ul/li[4]"));
//            }}).click();
        driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
        driver.findElement(By.xpath("//div[4]/div/div/ul/li[1]")).click();
//        wait.until(new ExpectedCondition<WebElement>(){
//            @Override
//            public WebElement apply(WebDriver d) {
//                return d.findElement(By.xpath("//div[4]/div/div/ul/li[1]"));
//            }}).click();


       /* //普通的select可能遇到的下拉框难题，但是不适用于当前的这里，
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/form/div[3]/div/div/div/div[1]")));
        select.selectByIndex(1);
        //select.selectByValue("其它");
        Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/form/div[3]/div/div/div/div[1]/input")));
        select1.selectByIndex(1);
        //select1.selectByValue("可提现");*/

        driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("测试");
        driver.findElement(By.cssSelector("div.dialog-footer > button.el-button.el-button--info")).click();
        driver.findElement(By.xpath("//div[3]/button[2]/span")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
        driver.findElement(By.cssSelector("input.el-input__inner")).click();
        driver.findElement(By.cssSelector("input.el-input__inner")).clear();
        driver.findElement(By.cssSelector("input.el-input__inner")).sendKeys("优惠券");
        driver.findElement(By.cssSelector("div.el-submenu__title")).click();
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div/div[2]/ul/div/li/ul/div[2]/li")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=2 | ]]
        driver.findElement(By.cssSelector("button.el-button.el-button--info.el-button--mini")).click();
        driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input.el-input--small > input.el-input__inner")).click();
        driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input.el-input--small > input.el-input__inner")).clear();
        driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input.el-input--small > input.el-input__inner")).sendKeys("2016092000352139");
        driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("1011");
        driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("测试");
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("测试");
        driver.findElement(By.cssSelector("td.available.today.current")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
        driver.findElement(By.xpath("//div[4]/div/div/div[2]/table/tbody/tr[4]/td[3]")).click();
        driver.findElement(By.cssSelector("div.el-dialog__body > form.el-form.el-form--label-right > div.el-row.el-row--flex > div.el-col.el-col-24 > div.el-form-item > div.el-form-item__content > div.el-select > div.el-input.el-input--small > input.el-input__inner")).click();
        driver.findElement(By.cssSelector("li.el-select-dropdown__item.hover")).click();
        driver.findElement(By.cssSelector("div.dialog-footer > button.el-button.el-button--primary > span")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[24]")).click();
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
}