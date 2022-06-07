package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java8.En;

public class HomePageSteps extends TestInstrument implements En {
    
    public HomePageSteps(){
        And("^user click on setting button$", () -> {
            paques.homePage().clickSettingInHeader();
        });
    }
}
