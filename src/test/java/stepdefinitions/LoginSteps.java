package stepdefinitions;

import config.Hooks;
import static helper.Constant.*;

public class LoginSteps extends Hooks{
    
    public LoginSteps() {
        Given("^user is on login page PDS$", () -> {
            // Website.loginPage().setName(username);
        });

        And("user filled in valid username", () -> { 
            Website.loginPage().setName(USERNAME);
        });

        And("user filled in valid password", () -> {
            Website.loginPage().setPassword(PASSWORD);
        });

        When("^user click button login$", () -> {
            Website.loginPage().clickButtonLogin();
        });

        Then("^user should be able to login successfully$", (String message) -> {
            // Website.loginPage().messageLogin(message);
        });

        And("^user filled in invalid username$", (String InvalidUsername) -> {
            Website.loginPage().setName(InvalidUsername);
        });

        And("^user filled in invalid password$", (String invalidPassword) -> {
            Website.loginPage().setPassword(invalidPassword);
        });

        Then("^user should have an alert \"([^\"]*)\" invalid login as \"([^\"]*)\"$", (String message, String value) -> {
            Website.loginPage().messageLogin(message, value);
        });

        // Invalid Login

        // And("^user filled in invalid name as \"([^\"]*)\"$", (String invalidName) -> {
            // Website.loginPage().setName(username);
        // });
    }
}
