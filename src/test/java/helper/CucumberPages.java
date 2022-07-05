package helper;

import org.openqa.selenium.WebDriver;

import pages.CreateRolePage;
import pages.DataProcessingPage;
import pages.ForgotPasswordPage;
import pages.GroupPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;
import pages.onBoardingPage;
import telegram.TelegramStep;

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

    public TelegramStep telegramStep(){
        return new TelegramStep(driver);
    }

    public CreateRolePage createRolePage(){
        return new CreateRolePage(driver);
    }

    public GroupPage groupPage(){
        return new GroupPage(driver);
    }
}
