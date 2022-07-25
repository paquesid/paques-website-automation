package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java8.En;

public class ExecutedScheduler extends TestInstrument implements En {
    
    public ExecutedScheduler(){

        And("^user click on section query information tab$", () -> {
            paques.dataProcessingPage().clickSectionQueryInformation();
        });

        When("^user set scheduller from time \"([^\"]*)\"$$", (String TimeScheduler) -> {
            paques.dataProcessingPage().chooseScheduler(TimeScheduler);
        });

        And("^user set scheduler time from today$", () -> {
            paques.dataProcessingPage().setSchedulerToday();
        });
    }
}
