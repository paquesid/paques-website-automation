package pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import elements.LoginPagesElement;

import static helper.TestInstrument.*;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class LoginPage extends LoginPagesElement {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void isOnLoginPage() {
        String actual = driver.getTitle();
        assertEquals("Paques | Smart Data Lake", actual);
    }

    public void setName(String username) {
        enterText(LOGINPAGE_USERNAME_TEXT, username);
    }

    public void setPassword(String password) {
        enterText(LOGINPAGE_PASSWORD_TEXT, password);
    }

    public void setCaptcha() {
        enterText(LOGINPAGE_CAPCHA_TEXT, "12345");
    }

    public void clickButtonLogin() {
        clickButton(LOGINPAGE_LOGIN_BUTTON);
    }

    public void successLogin(String expected) {
        String actual = LOGINPAGE_SUCCESS_LOGIN_TEXT.getText();
        assertEquals(expected, actual);
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
        } catch (ElementNotInteractableException e) {
            refreshPage();
        }
    }
}
