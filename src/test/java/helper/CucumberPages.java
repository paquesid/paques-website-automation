package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import pages.LoginPage;

public class CucumberPages {
    
    WebDriver driver;

    public CucumberPages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public LoginPage loginPage(){
        return new LoginPage(driver);
    }
}
