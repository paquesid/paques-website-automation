package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;
import helper.Type;


public class GroupSteps extends TestInstrument implements En {
    public GroupSteps(){

        When("^user click on group tab in user tab$", ()->{
            paques.groupPage().clickGroupTab();
        }); 

        /*
         * Create Group
         */

        Then("^user should see group page$", ()->{
            paques.groupPage().getTextTitleGroup("Group List");
        });

        And("^user click on create group button$", ()->{
            paques.groupPage().clickCreateGroup();
        });

        And("^user should see crate group form$", ()->{
            paques.groupPage().getTextTitleCreateGroup("Create Group");
        });

        And("^user input Group name as \"([^\"]*)\"$", (String groupName)->{
            paques.groupPage().setGroupName(groupName);
        });

        And("^user input Group Description as \"([^\"]*)\"$", (String groupDescription)->{
            paques.groupPage().setGroupDescription(groupDescription);
        });

        And("^user select role as nonadmin0706$", ()->{
            paques.groupPage().selectRole();
        });

        When("^user click on Save button$", ()->{
            paques.groupPage().clickSave();
        }); 

        Then("^Result message \"([^\"]*)\" will be displayed$", (String messageResult) -> {
            paques.groupPage().resultMessageGroup(messageResult);
        });
        
        Then("^Alert message \"([^\"]*)\" will be displayed$", (String errMessage) -> {
            switch (errMessage) {
                case "Group name is required":
                    paques.groupPage().getErrorMessage(errMessage, Type.GROUPNAME.toString());
                    break;
                default:
                    throw new Error("Type doesnt match with others values ..");
            }
        });

        /*
         * Edit Page
         */
 
        Then("^user is on tab group \"([^\"]*)\" activated$", () -> {
            paques.groupPage().getTextTitleGroup("Group List");
        });

        When("^user click on Edit Group icon$", () -> {
            paques.groupPage().clickEditGroup("Grp2108");
            // paques.groupPage().searchGroup("Grp2108");
        });

        Then("^user should see form to update group$", () -> {
            paques.groupPage().getTitleFormUpdateGroup("Edit Group 'Grp2108'");
        });

        And("^user edit Group Description as \"([^\"]*)\"$", (String editDescription) -> {
            paques.groupPage().editGroupDescription(editDescription);
        });

        Then("^update group result message \"([^\"]*)\" will be displayed$", (String message) -> {
            paques.groupPage().resultMessageGroup(message);
        });







    }

    
}
