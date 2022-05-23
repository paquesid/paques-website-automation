package helper;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.LogUtils;

import static helper.Constant.*;
import java.net.MalformedURLException;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class TestInstrument {

    protected static WebDriver driver;
    protected static CucumberPages paques;
    public static WebElement element;

    public static WebElement enterText(WebElement locator, String text) {
        boolean clear = true;
        if(clear){
            locator.clear();
        }
        locator.sendKeys(text);

        return locator;
    }

    public static void assertEquals(Object expected, Object actual) {
        try {
            delay(2);
            Assert.assertEquals(expected, actual);
        } catch (ElementNotVisibleException e) {
            LogUtils.error("Element not Founded : " + e.getMessage());
        }
    }

    public static WebElement clickButton(WebElement locator) {
        try {
            locator.click();
        } catch (ElementClickInterceptedException e) {
            LogUtils.info("element not exist : " + e.getCause());
        }

        return locator;
    }

    public static void delay(long milis) {
        try {
            Thread.sleep(milis);
        } catch (Exception e) {
            LogUtils.info("Waiting ... : " + e.getCause());
        }
    }

    public static void refreshPage(){
        driver.navigate().refresh();
    }

    public static void backButton(){
        driver.navigate().back();
    }

    public WebDriver setupBrowser() throws MalformedURLException {
        driver = Base.startApplication(CHROME, PRODUCTION);
        return driver;
    }

    public void pageObj(){
        paques = new CucumberPages(driver);
    }

    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
