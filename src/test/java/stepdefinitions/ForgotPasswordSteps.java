package stepdefinitions;

import helper.TestInstrument;
import io.cucumber.java8.En;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class ForgotPasswordSteps extends TestInstrument implements En{
    
    public ForgotPasswordSteps(){
        And("^user click forgot password button$", () -> {
            paques.forgotPasswordPage().clickForgotPasswordButton();
        });

        When("^user filled in email as \"([^\"]*)\"$", (String email) -> {
            paques.forgotPasswordPage().setEmailForgotPassword(email);
        });

        Then("^user should be able to reset password successfully$", () -> {
            paques.forgotPasswordPage().textSuccessResetPassword("This action has been processed successfully!");
        });

        When("^user filled in notFound email as \"([^\"]*)\"$", (String invalidEmail) -> {
            paques.forgotPasswordPage().setEmailForgotPassword(invalidEmail);
        });

        Then("^user Not able to reset password in PDS application$", () -> {
            paques.forgotPasswordPage().textSuccessResetPassword("This action failed to process! messasge : user not found");
        });
    }
}
