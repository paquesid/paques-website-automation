package helper;

import org.openqa.selenium.WebDriver;

import pages.ForgotPasswordPage;
import pages.LoginPage;

public class CucumberPages {
    
    private final WebDriver driver;

    public CucumberPages(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage loginPage(){
        return new LoginPage(driver);
    }

    public ForgotPasswordPage forgotPasswordPage(){
        return new ForgotPasswordPage(driver);
    }
}
