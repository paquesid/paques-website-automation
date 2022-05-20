package config;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import helper.TestInstrument;

public class Hooks extends TestInstrument implements En {

    protected static WebDriver driver;
    private static String scenarioName;
    String path = System.getProperty("user.dir") + "/screenshot_failed";
    File srcFile = null;
    byte[] screenshot = new byte[0];

    public Hooks() {

        Before(0, () -> {
            setupBrowser();
            pageObj();
        });

        Before(1, (Scenario scenario) -> {
            scenarioName = scenario.getName();
            if (scenario.isFailed()) {
                srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                File imageFile = new File(path + scenarioName + ".png");
                try {
                    scenario.attach(screenshot, "image/png", scenarioName);
                    FileUtils.copyFile(Objects.requireNonNull(srcFile), imageFile);
                    System.out.println("Image has been taken");
                } catch (IOException e) {
                    System.out.println("Exception while taking screenshot : " + e.getMessage());
                }
            }
        });

        After(0, () -> {
            tearDown();
        });
    }
}
