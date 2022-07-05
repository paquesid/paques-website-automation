package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import static helper.TestInstrument.*;
import elements.onBoardingElement;

public class onBoardingPage extends onBoardingElement{
    
    protected WebDriver driver;

    public onBoardingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void clickStartOnboardingPage(){
        clickButton(ONBOARDING_START_BUTTON);
    }

    public void getHomeTitleText(){
        String actual = ONBOARDING_HOME_TITLE.getText();
        assertEquals("Welcome To", actual);
    }
}
