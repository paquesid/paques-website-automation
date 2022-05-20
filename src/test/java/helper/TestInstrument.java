package helper;


import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static helper.Constant.*;
import java.net.MalformedURLException;

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
        Assert.assertEquals(expected, actual);
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
