package config;

import io.cucumber.java8.En;
import helper.TestInstrument;

public class Hooks extends TestInstrument implements En {

    public Hooks() {

        Before(0, () -> {
            setupBrowser();
            pageObj();
        });

        After(0, () -> {
            tearDown();
        });
    }
}
