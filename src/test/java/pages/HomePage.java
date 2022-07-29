package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import elements.HomePageElement;
import static helper.TestInstrument.*;

public class HomePage extends HomePageElement {
    
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void clickSettingInHeader(){
        doubleClickButton(HOMEPAGE_SETTING_BUTTON);
    }
    
    public void dismissModalInHomePage(){
        try {
            isElementExist(HOMEPAGE_MODAL_TEXT, 6);
            String text = HOMEPAGE_MODAL_TEXT.getText();
            if(text.equals("Let’s get started!")){
                clickButton(HOMEPAGE_MODAL_DISMISS_BUTTON);
            }
        } catch (AssertionError e) {
            refreshPage();
        }  
    }

    public void goToUserManagement(){
        clickButton(HOMEPAGE_USERMANAGEMENT_BUTTON);
    }

    public void goToDataProcessing(){
        clickButton(HOMEPAGE_DATAPROCESSING_TAB_BUTTON);
    }

    public void goToDataVisualization(){
        clickButton(HOMEPAGE_DATAVISUALIZATION_TAB_BUTTON);
    }

    public void goToMenuBuilder(){
        clickButton(HOMEPAGE_MENUBUILDER_TAB_BUTTON);
    }

    public void goToNotificationCenter(){
        try {
            clickButton(HOMEPAGE_NOTIFICATION_CENTER_BUTTON);
        } catch (Exception e) {
            refreshPage();
            clickButton(HOMEPAGE_NOTIFICATION_CENTER_BUTTON);
        }
        
    }
}
