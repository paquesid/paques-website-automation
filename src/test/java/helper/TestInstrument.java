package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java8.Scenario;
import io.github.cdimascio.dotenv.Dotenv;
import static helper.Constant.*;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class TestInstrument {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static CucumberPages paques;
    public static String scenarioName;
    public static WebElement element;
    public static Actions action;
    public static Select select;
    private static boolean clear = false;
    public Dotenv dotenv = Dotenv.load();

    /**
     * @param locator parameter element locator
     * @param text parameter input text in Frontend application
     * @return 
     */
    
    public static WebElement enterText(WebElement locator, String text) {
        if(!clear){
            locator.clear();
        }
        locator.sendKeys(text);
        return locator;
    }

    public static WebElement enterTextByKeys(WebElement locator, String text){
        if(!clear){
            locator.clear();
        }
        locator.sendKeys(text, Keys.ENTER);
        return locator;
    }

    public static void assertEquals(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);
    }

    public static WebElement clickButton(WebElement locator) {
        if(locator.equals(null)){
            throw new ElementNotInteractableException("please check this element locator : " + locator);
        } else {
            if(isElementExist(locator, 2)){
                locator.click();
            }
            return locator;
        }
    }

    public static Boolean clickCheckBox(WebElement locator){
        Boolean target = locator.isDisplayed();
        if(target.equals(true)){
            locator.click();
        } else {
            throw new Error("Check this a locator : " + locator);
        }
        
        return target;
    }

    public static WebElement clickButtonByKeys(WebElement locator) {
        if(locator.equals(null)){
            throw new ElementNotInteractableException("please check this element locator : " + locator);
        } else {
            if(isElementExist(locator, 2)){
                locator.click();
                locator.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            }
            return locator;
        }
    }

    public static WebElement doubleClickButton(WebElement locator) {
        if(locator.equals(null)){
            throw new Error("please check this element locator : " + locator);
        } else {
            if(isElementExist(locator, 2)){
                for(int i = 0; i < 2; i++){
                    locator.click();
                }
            }
            return locator;
        }
    }

    public static void delay(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new Error("waiting... : " + e.getCause());
        }
    }

    public static void scrollIntoView(WebElement elementLocator, WebDriver driver, int timeout){
        delay(timeout);
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", elementLocator);
    }

    public static void scrollIntoElement(WebElement elementLocator, int timeout){
        if(elementLocator.equals(null)){
            throw new NotFoundException("please check this element : " + elementLocator);
        } else {
            if(isElementExist(elementLocator, timeout)){
                action = new Actions(driver);
                action.moveToElement(elementLocator)
                    .build()
                    .perform();
            }
        }
    }

    public static void selectDropDownValue(WebElement locator, String type, String value){
        select = new Select(locator);
        switch (type) {
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "text":
                select.selectByVisibleText(value);
                break;
            default:
                throw new Error("please pass the correct selection criteria ..");
        }
    }

    public static boolean isElementExist(WebElement locator, int timeout) {
        wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofMillis(timeout * 1000));
        locator = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
        return true;
    }

    public static boolean isAlertPresent(WebElement locator, int timeout) {
        wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofMillis(timeout * 1000));
        locator = (WebElement) wait.until(ExpectedConditions.alertIsPresent());
        return true;
    }

    public static void refreshPage(){
        driver.navigate().refresh();
    }

    public static void backButton(){
        driver.navigate().back();
    }

    public WebDriver setupBrowser(String browserName) {
        try {
            if(browserName.equalsIgnoreCase("chrome")){
                return driver = Base.startApplication(driver, CHROME, Environment.PDS.toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public void pageObj(){
        paques = new CucumberPages(driver);
    }

    public void afterScenario(Scenario scenario){
        scenarioName = scenario.getName();

        if(scenario.isFailed()){
            String path = System.getProperty("user.dir") + "/screenshots_failed/";
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            File imageFile = new File(path + scenarioName + ".png");
            try {
                scenario.attach(screenshot, "image/png", "failed screenshot");
                FileUtils.copyFile(Objects.requireNonNull(srcFile), imageFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void takeScreenShotsOnStepFailure(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    public void tearDown(){
        if (driver != null){
            driver.close();
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

    // End method Date Picker


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
                System.out.println("Source dropped to target as expected");
            } else {
                System.out.println("Source couldn't be dropped to target as expected");
            }
        } catch (ElementClickInterceptedException e) {
            throw new Error("element not founded : " + e.getCause());
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
            throw new Error("Source couldn't be dropped to target as expected");
        }
    }
}
