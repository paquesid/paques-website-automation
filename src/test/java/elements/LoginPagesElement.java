package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(id = "")
    protected
    WebElement LOGINPAGE_LOGIN_BUTTON;

    @FindBy(css = "")
    protected
    WebElement LOGINPAGE_ALERT_MESSAGE;
}
