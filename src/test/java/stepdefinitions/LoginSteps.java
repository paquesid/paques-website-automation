package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java8.En;

import static helper.Constant.*;

public class LoginSteps extends TestInstrument implements En{
    
    public LoginSteps() {
        Given("^user is on login page PDS$", () -> {
            paques.loginPage().isOnLoginPage();
        });

        And("user filled in valid username", () -> { 
            paques.loginPage().setName(USERNAME);
        });

        And("user filled in valid password", () -> {
            paques.loginPage().setPassword(PASSWORD);
        });

        And("^user filled in capcha$", () -> {
            paques.loginPage().setCaptcha();
        });

        When("^user click button login$", () -> {
            paques.loginPage().clickButtonLogin();
        });

        Then("^user should be able to login successfully$", () -> {
            paques.loginPage().successLogin("Hi, Dika");
        });

        And("^user filled in invalid username$", (String InvalidUsername) -> {
            paques.loginPage().setName(InvalidUsername);
        });

        And("^user filled in invalid password$", (String invalidPassword) -> {
            paques.loginPage().setPassword(invalidPassword);
        });

        Then("^user should have an alert \"([^\"]*)\" invalid login with \"([^\"]*)\"$", (String message, String value) -> {
            paques.loginPage().messageLogin(message, value);
        });
    }
}
