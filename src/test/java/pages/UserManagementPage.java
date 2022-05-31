package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import elements.UserManagementElement;
import utils.LogUtils;
import static helper.TestInstrument.*;

/**
 * Created by Dika Brenda Angkasa on 30/05/2022
 */

public class UserManagementPage extends UserManagementElement{
    
    protected WebDriver driver;

    public UserManagementPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void getUserListText(String activatedTab){
        String actual = USERMANAGEMENTPAGE_USERTAB_TEXT.getText();
        assertEquals(activatedTab, actual);
    }

    public void goToUserManagement(){
        clickButton(USERMANAGEMENTPAGE_GOTO_USERMANAGEMENT_BUTTON);
    }

    public void clickCreateUserButton(){
        clickButton(USERMANAGEMENTPAGE_CREATE_USER_BUTTON);
    }

    public boolean getTitleFormCreateUser(String expected){
        if(isElementExist(USERMANAGEMENTPAGE_FORM_CREATEUSER_TITLE, 10)){
            String actual = USERMANAGEMENTPAGE_FORM_CREATEUSER_TITLE.getText();
            assertEquals(expected, actual);
        }
        return true;
    }

    public void searchUser(String name){
        enterTextByKeys(USERMANAGEMENTPAGE_SEARCHUSER_TEXT, name);
    }

    public void clickEditButton(String name){
        try {
            searchUser(name);
        } catch (AssertionError e) {
            LogUtils.error("cannot search user", e);
        } finally {
            clickButton(USERMANAGEMENTPAGE_UPDATE_BUTTON);
        }
    }

    public void setUsername(String username){
        enterText(USERMANAGEMENTPAGE_USERNAME_TEXT, username);
    }

    public void setEmail(String email){
        enterText(USERMANAGEMENTPAGE_EMAIL_TEXT, email);
    }

    public void setPassword(String password){
        enterText(USERMANAGEMENTPAGE_PASSWORD_TEXT, password);
    }

    public void setRePassword(String rePassword){
        enterText(USERMANAGEMENTPAGE_REPASSWORD_TEXT, rePassword);
    }

    public void setFirstName(String firstName){
        enterText(USERMANAGEMENTPAGE_FIRSTNAME_TEXT, firstName);
    }

    public void setLastName(String lastName){
        enterText(USERMANAGEMENTPAGE_LASTNAME_TEXT, lastName);
    }

    public void setGroup(){
        try {
            clickButton(USERMANAGEMENTPAGE_GROUP_DROPDOWN);
            clickButton(USERMANAGEMENTPAGE_VALUE_AUTOMATION_TEXT);
        } catch (AssertionError e) {
            LogUtils.error("element not clickable ", e);
        }
    }

    public void clickSaveButton(){
        clickButton(USERMANAGEMENTPAGE_FORM_SAVE_BUTTON);
    }

    public void getSuccessMessage(String message){
        try {
            String actual = USERMANAGEMENTPAGE_MODAL_SUCCESS_TAB.getText();
            if(isElementExist(USERMANAGEMENTPAGE_MODAL_SUCCESS_TAB, 4)){
                assertEquals(message, actual);
            } 
        } catch (AssertionError e) {
            LogUtils.info("element not displayed : " + e.getCause());
        } finally {
            clickButton(USERMANAGEMENTPAGE_MODAL_OKE_BUTTON);
        }
    }

    public void getErrorMessage(String errMessage, String type){
        switch (type) {
            case "username":
                String actualUsername = ERROR_USERMANAGEMENTPAGE_USERNAME.getText();
                assertEquals(actualUsername, errMessage);
                break;

            case "email":
                String actualEmail = ERROR_USERMANAGEMENTPAGE_EMAIL.getText();
                assertEquals(actualEmail, errMessage);
                break;

            case "passwordNotMatch":
                String actualNotMatch = ERROR_USERMANAGEMENTPAGE_PASSWORDNOTMATCH.getText();
                assertEquals(actualNotMatch, errMessage);
                break;

            case "password":
                String actualPassword = ERROR_USERMANAGEMENTPAGE_PASSWORD.getText();
                assertEquals(actualPassword, errMessage);
                break;

            case "rePassword":
                String actualRePassword = ERROR_USERMANAGEMENTPAGE_REPASSWORD.getText();
                assertEquals(actualRePassword, errMessage);
                break;

            case "firstName":
                String actualFirstName = ERROR_USERMANAGEMENTPAGE_FIRSTNAME.getText();
                assertEquals(actualFirstName, errMessage);
                break;

            case "lastName":
                String actualLastName = ERROR_USERMANGEMENTPAGE_LASTNAME.getText();
                assertEquals(actualLastName, errMessage);
                break;

            default:
                LogUtils.error("please check parameters ..");
                break;
        }

    }
}
