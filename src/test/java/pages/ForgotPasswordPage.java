package pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import elements.ForgotPasswordElement;
import static helper.TestInstrument.*;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class ForgotPasswordPage extends ForgotPasswordElement {
    
    protected WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void clickForgotPasswordButton() {
        clickButton(FORGOT_PASSWORD_BUTTON);
    }

    public void setEmailForgotPassword(String email) {
        enterText(FORGOT_PASSWORD_EMAIL_TEXT, email);
        clickButton(FORGOT_PASSWORD_SAVE_BUTTON);
    }

    public void textSuccessResetPassword(String expected){
        try {
            String actual = FORGOT_PASSWORD_SUCCESS_TEXT.getText();
            assertEquals(expected, actual);
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        } finally {
            clickButton(FORGOT_PASSWORD_OKE_MODAL_BUTTON);
        }
    }

}
