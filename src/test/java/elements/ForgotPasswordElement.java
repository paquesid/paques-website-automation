package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordElement {

    @FindBy(linkText = "Forgot Password?")
    protected
    WebElement FORGOT_PASSWORD_BUTTON;

    @FindBy(css = "input[placeholder='Email']")
    protected
    WebElement FORGOT_PASSWORD_EMAIL_TEXT;

    @FindBy(xpath = "//button[normalize-space()='Save Changes']")
    protected
    WebElement FORGOT_PASSWORD_SAVE_BUTTON;

    @FindBy(css = ".f-15.m-auto")
    protected
    WebElement FORGOT_PASSWORD_SUCCESS_TEXT;

    @FindBy(css = "button[type='button']")
    protected
    WebElement FORGOT_PASSWORD_OKE_MODAL_BUTTON;
}
