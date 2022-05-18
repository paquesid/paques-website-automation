package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import elements.LoginPagesElement;

import static helper.TestInstrument.*;

public class LoginPage extends LoginPagesElement {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void setName(String username) {
        enterText(LOGINPAGE_USERNAME_TEXT, username);
    }

    public void setPassword(String password) {
        enterText(LOGINPAGE_PASSWORD_TEXT, password);
    }

    public void clickButtonLogin() {
        try {
            LOGINPAGE_LOGIN_BUTTON.click();
        } catch (Exception e) {
            delay(2);
        }
    }

    public void messageLogin(String message, String value) {
        try {
            String actual = LOGINPAGE_ALERT_MESSAGE.getText();
            switch (value) {
                case "invalidPassword":
                    assertEquals(message, actual);
                    System.out.println(message);
                    break;

                case "invalidUsername":
                    assertEquals(message, actual);
                    System.out.println(message);
                    break;

                case "sqlInjection":
                    assertEquals(message, actual);
                    System.out.println(message);
                    break;
            }
        } catch (ElementClickInterceptedException e) {
            refreshPage();
        }
    }
}
