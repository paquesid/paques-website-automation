package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java8.En;

/**
 * Created by Dika Brenda Angkasa on 30/05/2022
 */

public class UserManagementSteps extends TestInstrument implements En {
    
    public UserManagementSteps(){
        And("^user is on tab \"([^\"]*)\" activated$", (String activated) -> {
            paques.userManagementPage().getUserListText(activated);
        });

        Then("^user click on create user button in user tab$", () -> {
            paques.userManagementPage().clickCreateUserButton();
        });

        When("^user should see form to create user$", () -> {
            paques.userManagementPage().getTitleFormCreateUser("Create User");;
        });

        And("^user filled username as \"([^\"]*)\" in form create user$", (String username) -> {
            paques.userManagementPage().setUsername(username);
        });

        And("^user filled email as \"([^\"]*)\" in form create user$", (String email) -> {
            paques.userManagementPage().setEmail(email);
        });

        And("^user filled password as \"([^\"]*)\" in form create user$", (String password) -> {
            paques.userManagementPage().setPassword(password);
        });

        And("^user filled re-password as \"([^\"]*)\" in form create user$", (String rePassword) -> {
            paques.userManagementPage().setRePassword(rePassword);
        });

        And("^user filled fist name as \"([^\"]*)\" in form create user$", (String firstName) -> {
            paques.userManagementPage().setFirstName(firstName);
        });

        And("^user filled last name as \"([^\"]*)\" in form create user$", (String lastName) -> {
            paques.userManagementPage().setLastName(lastName);
        });

        And("^user selected group as \"([^\"]*)\" in form create user$", (String value) -> {
            paques.userManagementPage().setGroup(value);
        });

        When("^user click on save button$", () -> {
            paques.userManagementPage().clickSaveButton();
        });

        Then("^user should be able to see a message \"([^\"]*)\"$", (String message) -> {
            paques.userManagementPage().getSuccessMessage(message);;
        });
    }
}
