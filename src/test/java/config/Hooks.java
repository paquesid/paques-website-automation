package config;

import static helper.Constant.*;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import helper.CucumberPages;
import helper.TestInstrument;

public class Hooks extends TestInstrument implements En {

    protected static WebDriver driver;
    public CucumberPages Website;
    private static String scenarioName;
    String path = System.getProperty("user.dir") + "/screenshot_failed";
    File srcFile = null;
    byte[] screenshot = new byte[0];

    public Hooks(){
        
        Before(0, () -> {
            setupBrowser();
            pageObj();
            Runtime.getRuntime().addShutdownHook(new Thread(this::tearDown));
        });

        Before(1, (Scenario scenario) -> {
            
            scenarioName = scenario.getName();

            if(scenario.isFailed()) {
                srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                File imageFile = new File(path + scenarioName + ".png");
                try {
                    scenario.attach(screenshot, "image/png", scenarioName);
                    FileUtils.copyFile(Objects.requireNonNull(srcFile), imageFile);
                    System.out.println("Image has been taken");
                } catch (Exception e) {
                    System.out.println("Exception while taking screenshot : " + e.getMessage());
                }
            }
        });

        After(0, () -> {
            tearDown();
            System.out.println("teardown");
        });
    }

    public WebDriver setupBrowser() throws MalformedURLException {
        driver = Base.startApplication(CHROME, PRODUCTION);
        return driver;
    }

    public void pageObj(){
        Website = new CucumberPages(driver);
    }

    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
