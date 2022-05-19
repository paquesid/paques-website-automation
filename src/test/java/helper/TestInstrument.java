package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestInstrument {

    protected static WebDriver driver;
    public static Properties elementProperties = getElementProperties();
    public static WebElement element;

    protected static Properties getElementProperties() {
        elementProperties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(Constant.ELEMENTS);
            elementProperties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elementProperties;
    }

    protected static By setElementProperties(String locator){
        if (locator.equals("css_")){
            driver.findElement(By.cssSelector(getElementProperties().getProperty(locator)));
        } else if (locator.equals("xpath_")){
            String.valueOf(By.xpath(getElementProperties().getProperty(locator)));
        } else {
            throw new ElementNotInteractableException("element not founded " + locator);
        }

        return null;
    }

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

    public WebElement inputText(String locator, String text){
        boolean clear = true;
        element = (WebElement) setElementProperties(locator);
        if(clear){
            element.clear();
        }
        element.sendKeys(text);

        return element;
    }

    public static WebElement clickButton(WebElement locator) {
        try {
            // element = (WebElement) setElementProperties(locator);
            // element.click();
            locator.click();
        } catch (ElementClickInterceptedException e) {
            throw new Error("element not exist : " + locator);
        }

        return element;
    }

    public static void delay(long milis) {
        try {
            Thread.sleep(milis);
        } catch (Exception e) {
            System.out.println("waiting ...");;
        }
    }

    public static String getText(String locator){
        element = driver.findElement(setElementProperties(locator));
        return element.getText();
    }

    public static void refreshPage(){
        driver.navigate().refresh();
    }
}
