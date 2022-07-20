package helper;

import org.openqa.selenium.WebDriver;

import pages.DataProcessingPage;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;
import pages.onBoardingPage;

/**
 * Created by Dika Brenda Angkasa on 23/05/2022
 */

public class CucumberPages {
    
    private final WebDriver driver;

    public CucumberPages(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage(){
        return new HomePage(driver);
    }

    public LoginPage loginPage(){
        return new LoginPage(driver);
    }

    public ForgotPasswordPage forgotPasswordPage(){
        return new ForgotPasswordPage(driver);
    }

    public onBoardingPage onboardingPage(){
        return new onBoardingPage(driver);
    }

    public UsersPage userManagementPage(){
        return new UsersPage(driver);
    }

    public DataProcessingPage dataProcessingPage(){
        return new DataProcessingPage(driver);
    }
}
