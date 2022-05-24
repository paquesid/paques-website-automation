package helper;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.LogUtils;

import static helper.Constant.*;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class TestInstrument {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static CucumberPages paques;
    public static WebElement element;
    public static Actions action;
    public static Select select;

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

    public static void scrollIntoView(WebElement elementLocator, WebDriver driver, int timeout){
        delay(timeout);
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", elementLocator);
    }

    public static Select dropDownByValue(WebElement locator, String value, int timeOut){
        delay(timeOut);
        select = new Select(locator);
        try {
            select.selectByValue(value);
        } catch (ElementNotSelectableException e) {
            LogUtils.error("element not founded : " + e.getCause());
        }
        return select;
    }

    public static boolean isElementExist(WebElement elementLocator) {
        wait.until(ExpectedConditions.visibilityOf(elementLocator));
        return true;
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


    /**
     * Method to handle date picker
     * @return
     */

    public static String getCurrentDay() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("ID"));
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        String todayStr = Integer.toString(todayInt);
        return todayStr;
    }

    public static String getCurrentDayPlus(int days){
        LocalDate currentDate = LocalDate.now();
        int dayOfWeekPlus = currentDate
            .getDayOfWeek()
            .plus(days)
            .getValue();
        return Integer.toString(dayOfWeekPlus);
    }

    public static void clickGivenDays(List<WebElement> elementList, String day){
        elementList.stream()
            .filter(element -> element
                .getText()
                .contains(day))
            .findFirst()
            .ifPresent(WebElement::click);
    }


    /**
     * Method to perform Drag and Drop
     * @param source 
     * @param target
     * @param timeout
     */
    public static void dragAndDrop(WebElement source, WebElement target, int timeout) {
        try {
            delay(timeout);
            action = new Actions(driver);
            String to = target.getText();
            action.dragAndDrop(source, target).perform();
            if(to.equals("Dropped!")){
                LogUtils.info("Source dropped to target as expected");
            } else {
                LogUtils.info("Source couldn't be dropped to target as expected");
            }
        } catch (ElementClickInterceptedException e) {
            throw new Error(e.getCause());
        }
        
    }

    public static void dragAndDropByOfset(WebElement source, WebElement target, int timeout) {
        // get x and y offset for from object
        int xOfsetSource = source.getLocation().getX();
        int yOfsetSource = source.getLocation().getY();

        // get x and y offset for to object
        int xOfsetTarget = target.getLocation().getX();
        int yOfsetTarget = target.getLocation().getY();

        xOfsetTarget = (xOfsetTarget - xOfsetSource) + 10;
        yOfsetTarget = (yOfsetTarget - yOfsetSource) + 20;
        
        String to = target.getText();
        if(to.equals("Dropped!")){
            action
                .dragAndDropBy(source, xOfsetTarget, yOfsetTarget)
                .perform();
        } else {
            LogUtils.info("Source couldn't be dropped to target as expected");
        }
    }
}
