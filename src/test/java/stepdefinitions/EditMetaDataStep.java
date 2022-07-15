package stepdefinitions;

import com.github.dockerjava.api.exception.NotFoundException;

import helper.TestInstrument;
import io.cucumber.java8.En;

/**
 * Created by Dika Brenda Angkasa on 05/07/2022
 */

public class EditMetaDataStep extends TestInstrument implements En{
    
    public EditMetaDataStep(){

        And("^user click metadata setting$", () -> {
            paques.dataProcessingPage().clickMetaDataSetting();
        });

        When("^user check Date time flag to yes$", () -> {
            paques.dataProcessingPage().checklistDateTimeMetaData();
        });

        Then("^user should be able to see a popup message \"([^\"]*)\"$", (String expected) -> {
            if(expected.equalsIgnoreCase("Process Completed")){
                paques.dataProcessingPage().getTextErrorMessage("Process Completed");
            } else if(expected.equalsIgnoreCase("Process failed")){
                paques.dataProcessingPage().getTextErrorMessage("Process failed");
            } else {
                throw new NotFoundException("Element notFound");
            }
        });
    }
}
