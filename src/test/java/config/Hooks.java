package config;

import io.cucumber.java8.En;
// import io.cucumber.java8.Scenario;
// import utils.LogUtils;

// import java.io.File;
// import java.util.Objects;

// import org.apache.commons.io.FileUtils;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;

import helper.TestInstrument;

public class Hooks extends TestInstrument implements En {

    public Hooks() {

        Before(0, () -> {
            setupBrowser();
            pageObj();
        });

        // After(1, (Scenario scenario) -> {
        //     scenarioName = scenario.getName();
            
        //     if(scenario.isFailed()){
        //         String path = System.getProperty("user.dir") + "/screenshots_failed/";
        //         File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //         byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        //         File imageFile = new File(path + scenarioName + ".png");
        //         try {
        //             scenario.attach(screenshot, "image/png", "failed screenshot");
        //             FileUtils.copyFile(Objects.requireNonNull(srcFile), imageFile);
        //             LogUtils.info("Screenshot has taken");
        //         } catch (Exception e) {
        //             LogUtils.error("Exception while taking screenshot", e);
        //         }
        //     }
        // });

        After(0, () -> {
            tearDown();
        });
    }
}
