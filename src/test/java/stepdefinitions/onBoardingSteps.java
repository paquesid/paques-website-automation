package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java8.En;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class onBoardingSteps extends TestInstrument implements En {

    public onBoardingSteps() {
        And("^user click button start$", () -> {
            paques.onboardingPage().clickStartOnboardingPage();
        });

        And("^asd$", () -> {
            paques.onboardingPage().getHomeTitleText();
        });
    }
}
