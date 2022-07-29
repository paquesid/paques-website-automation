package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java8.En;

public class CreateFolderSteps extends TestInstrument implements En {
    
    public CreateFolderSteps(){

        And("^user click on create folder icon$", () -> {
            paques.dataProcessingPage().clickFolderIcon();
        });

        When("^user input folder name as \"([^\"]*)\"$", (String FolderName) -> {
            paques.dataProcessingPage().setFolderName(FolderName);
        });

        And("^user click on \"([^\"]*)\" button to save new folder$", (String action) -> {
            if(action.equalsIgnoreCase("save")){
                paques.dataProcessingPage().clickSaveNewFolder("save");
            } else {
                paques.dataProcessingPage().clickSaveNewFolder("cancel");
            }
        });

        Then("^user should be able to created new folder$", () -> {
            paques.dataProcessingPage().resultSaveNewFolder("Automation_Test");
        });
    }
}
