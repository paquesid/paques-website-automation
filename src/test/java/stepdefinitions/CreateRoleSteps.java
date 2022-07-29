package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java8.En;
import helper.Type;

/**
 * created by Ria on 24/05/2022
 */

public class CreateRoleSteps extends TestInstrument implements En { 
    
    public CreateRoleSteps(){  

        And("^user click on Roles tab$", ()->{
            paques.createRolePage().clickRoleTab();
        });

        And("^user click on Create Role button$", ()->{
            paques.createRolePage().clickCreateRole();
        });

        And("^user input Role Name as \"([^\"]*)\"$", (String rolename) ->{
            paques.createRolePage().setName(rolename);
        });

        And("^user input Role Description as \"([^\"]*)\"$", (String description) ->{
            paques.createRolePage().setDecsription(description);
        });
        
        And("^user select radio button as \"([^\"]*)\"$", (String administrator)->{
            paques.createRolePage().selectScope(administrator);
        });

        And("^User select Application Scope as \"([^\"]*)\"$", (String application)->{
            paques.createRolePage().selectApplication(application);
        });

        And("^User check button as \"([^\"]*)\"$", (String menu)->{
            paques.createRolePage().checklistMenu(menu);
        });
        When("^User click on Save button$", ()->{
            paques.createRolePage().clickSave();
        });

        Then("^Result Message \"([^\"]*)\" will be displayed$", (String message) -> {
            paques.createRolePage().resultMessage(message);
        });

        Then("^Alert Message \"([^\"]*)\" will be displayed$", (String errMessage) -> {
            switch (errMessage) {
                case "Role name is required":
                paques.createRolePage().getErrorMessage(errMessage, Type.ROLENAME.toString());
                break;
                case "Role description is required" :
                paques.createRolePage().getErrorMessage(errMessage, Type.ROLEDESCRIPTION.toString());
                break;
                case "Please check at least 1 scope" :
                paques.createRolePage().getErrorMessage(errMessage, Type.SCOPE.toString());
                default:
                throw new Error("Type doesnt match with others values ..");
            }
        });
    }
}

