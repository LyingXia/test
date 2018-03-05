package com.test.applications.katalon;

/**
 * created by xiapf on 2018/2/6
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        //下面是实现chromedriver窗口最大化的方式 ChromeOptions
        ChromeOptions opiions=new ChromeOptions();
        opiions.addArguments("--start-maximized");
        driver = new ChromeDriver(opiions);
        baseUrl = "http://zt-mgr.aetest.bwae.org";
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[1]/div/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[1]/div/div[1]/input")).sendKeys("chen");
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.cssSelector("span")).click();
        /*点击业务管理*/
        //*[@id="app"]/div/div[2]/div[2]/div[2]/div[2]/div[4]/iframe
        //WebDriverWait wait = new WebDriverWait(driver, 100);
        /*wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/ul/div[4]/li/div/span"));
            }
        }).click();*/
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/ul/div[3]/li/div/span")).click();
        /*点击人工充值*/
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div/div[2]/ul/div[3]/li/ul/div[10]/li")).click();
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
        //python中用到的是ActionChains，java中用到的是Actions
       /* WebElement addmenu1 = driver.findElement(By.xpath("(//input[@type='text'])[10]"));
        new Actions(driver).click(addmenu1).perform();
        WebElement addlist1 = driver.findElement(By.xpath("//div[3]/div/div/ul/li[4]"));
        new Actions(driver).click(addlist1).perform();

        WebElement addmenu2 = driver.findElement(By.xpath("(//input[@type='text'])[11]"));
        new Actions(driver).click(addmenu2).perform();
        WebElement addlist2 = driver.findElement(By.xpath("//div[4]/div/div/ul/li[1]"));
        new Actions(driver).click(addlist2).perform();*/
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).click();
        Thread.sleep(300);
//        new Actions(driver).click(driver.findElement(By.xpath("(//input[@type='text'])[10]"))).perform();
        driver.findElement(By.xpath("//div[3]/div/div[1]/ul/li[4]")).click();
/*        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//div[3]/div/div/ul/li[4]"));
            }
        });*/
        Thread.sleep(300);
        driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
//        new Actions(driver).click(driver.findElement(By.xpath("(//input[@type='text'])[11]"))).perform();
        Thread.sleep(300);
        driver.findElement(By.xpath("//div[4]/div/div/ul/li[1]")).click();
/*        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//div[4]/div/div/ul/li[1]"));
            }
        });*/



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

        //从iframe切换回来
        driver.switchTo().parentFrame();
        /*driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/span/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/span/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/span/div/input")).sendKeys("优惠券");
        driver.findElement(By.cssSelector("div.el-submenu__title")).click();*/
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/ul/div[11]/li/div/span")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/ul/div[11]/li/ul/div[2]/li/span")).click();

        WebElement iframe_tab2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]/iframe"));
        driver.switchTo().frame(iframe_tab2);
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
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).click();
        Thread.sleep(300);
        WebElement now = driver.findElement(By.cssSelector("td.available.today.current"));
        now.click();
        driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//div[4]/div[1]/div/div[2]/table[1]/tbody/tr[6]/td[7]")).click();
        //driver.findElement(By.cssSelector("body > div:nth-child(11) > div.el-picker-panel__body-wrapper > div > div.el-picker-panel__content > table.el-date-table > tbody > tr:nth-child(7) > td:nth-child(7)")).click();
        //下面是选择产品类型的可以不写
/*        driver.findElement(By.xpath("(//input[@type='text'])[12]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//div[6]/div/div[1]/ul/li[1]")).click();
        driver.findElement(By.cssSelector("div.dialog-footer > button.el-button.el-button--primary > span")).click();*/
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[3]/div/button[2]/span")).click();
        String str = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/p")).getText();
        System.out.println(str);
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