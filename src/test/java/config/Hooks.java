package config;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;

import helper.TestInstrument;

public class Hooks extends TestInstrument implements En {

    public Hooks() {

        Before(0, () -> {
            setupBrowser("chrome");
            pageObj();
        });

        After(0, (Scenario scenario) -> {
            takeScreenShotsOnStepFailure(scenario);
            tearDown();
        });
    }
}