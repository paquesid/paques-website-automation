package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class LoginPagesElement {
    
    @FindBy(name = "username")
    protected
    WebElement LOGINPAGE_USERNAME_TEXT;

    @FindBy(name = "password")
    protected
    WebElement LOGINPAGE_PASSWORD_TEXT;

    @FindBy(name = "captcha")
    protected
    WebElement LOGINPAGE_CAPCHA_TEXT;

    @FindBy(css = "button[type='submit']")
    protected
    WebElement LOGINPAGE_LOGIN_BUTTON;

    @FindBy(css = "")
    protected
    WebElement LOGINPAGE_ALERT_MESSAGE;

    @FindBy(xpath = "//span[normalize-space()='Hi, Dika']")
    protected
    WebElement LOGINPAGE_SUCCESS_LOGIN_TEXT;

    /**
     * @LOG-OUT
     */

    @FindBy(css = "img[alt='User']")
    protected WebElement LOGINPAGE_USER_IMAGE;

    @FindBy(xpath = "//h4[normalize-space()='Sign Out']")
    protected WebElement LOGINPAGE_LOGOUT_BUTTON;
}
