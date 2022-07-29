package stepdefinitions;

// import java.util.Random;

import helper.TestInstrument;
import helper.Type;
import io.cucumber.java8.En;

/**
 * Created by Dika Brenda Angkasa on 30/05/2022
 */

public class UsersSteps extends TestInstrument implements En {
    
    public UsersSteps(){
        And("^user is on tab \"([^\"]*)\" activated$", (String activated) -> {
            paques.userManagementPage().getUserListText(activated);
        });

        Then("^user click on create user button in user tab$", () -> {
            paques.userManagementPage().clickCreateUserButton();
        });

        And("^user click on user management button in the list$", () -> {
            paques.userManagementPage().goToUserManagement();
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

        And("^user selected group as automation in form create user$", () -> {
            paques.userManagementPage().setGroup();
        });

        When("^user click on save button$", () -> {
            paques.userManagementPage().clickSaveButton();
        });

        Then("^user should be able to see a message \"([^\"]*)\"$", (String message) -> {
            paques.userManagementPage().getSuccessMessage(message);;
        });

        Then("^user should be able to see an error \"([^\"]*)\"$", (String errMessage) -> {
            switch (errMessage) {
                case "Username is required":
                    paques.userManagementPage().getErrorMessage(errMessage, Type.USERNAME.toString());
                    break;
                case "email is not valid email":
                    paques.userManagementPage().getErrorMessage(errMessage, Type.EMAIL.toString());
                    break;
                case "Passwords do not Match":
                    paques.userManagementPage().getErrorMessage(errMessage, Type.NOTMATCH.toString());
                    break;
                case "Password confirmation is required":
                    paques.userManagementPage().getErrorMessage(errMessage, Type.REPASSWORD.toString());
                    break;
                case "First name is required":
                    paques.userManagementPage().getErrorMessage(errMessage, Type.FIRSTNAME.toString());
                    break;
                case "Last name is required ":
                    paques.userManagementPage().getErrorMessage(errMessage, Type.LASTNAME.toString());
                    break;
                default:
                    throw new Error("Type doesn't match with others values ..");
            }
        });

        When("^user click on edit button in user tab$", () -> {
            paques.userManagementPage().clickEditButton(dotenv.get("PDS_SEARCH_USERS_DATATABLE"));
        });

        Then("^user should see form to update user$", () -> {
            paques.userManagementPage().getTitleFormUpdateUser("Edit User Dika");
        });

        When("^user click change password button$", () -> {
            paques.userManagementPage().clickChangePasswordButton(dotenv.get("PDS_SEARCH_USERS_DATATABLE"));
        });

        Then("^user should be able to see form password$", () -> {
            paques.userManagementPage().getTitleFormChangePassword("Change Password User  Dika");
        });


        /**
         * This step for Scenario Delete
         * @DELETE_USER
         */

        And("^user click delete button$", () -> {
            paques.userManagementPage().clickDeleteButton(dotenv.get("PDS_SEARCH_USERS_DATATABLE"));
        });

        And("^user should see form delete user$", () -> {
            paques.userManagementPage().getTitleFormDeleteUser("Delete User");
        });

        When("^user click \"([^\"]*)\" in the button$", (String value) -> {
            paques.userManagementPage().isDeletedUser(value);
        });

        Then("^user able to see a message \"([^\"]*)\"$", (String message) -> {
            paques.userManagementPage().messageDeleteExist(message);
        });

        Then("^user confirmed data still available in datatable user$", () -> {
            paques.userManagementPage().userStillExist(dotenv.get("PDS_SEARCH_USERS_DATATABLE"));
        });
    }
}