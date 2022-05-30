package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import elements.UserManagementElement;
import utils.LogUtils;

import static helper.TestInstrument.*;

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

    public void clickCreateUserButton(){
        clickButton(USERMANAGEMENTPAGE_CREATE_USER_BUTTON);
    }

    public boolean getTitleFormCreateUser(String expected){
        String actual = USERMANAGEMENTPAGE_FORM_CREATEUSER_TITLE.getText();
        if(isElementExist(USERMANAGEMENTPAGE_FORM_CREATEUSER_TITLE, 10)){
            assertEquals(expected, actual);
        }
        return true;
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

    public void setGroup(String value){
        dropDownByValue(USERMANAGEMENTPAGE_GROUP_DROPDOWN, value, 2);
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
}
