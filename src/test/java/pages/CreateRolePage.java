package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import elements.RoleElement;
import static helper.TestInstrument.*;
import utils.LogUtils;

public class CreateRolePage extends RoleElement {
    protected WebDriver driver;

    public CreateRolePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    public void clickRoleTab() {
        clickButton(ROLEPAGE_ROLETAB);
    }
    
    public void clickCreateRole() {
        clickButton(ROlEPAGE_CREATEROLEBUTTON);
    }

    public void setName(String rolename) {
        enterText(ROLEPAGE_ROLENAME_TEXT, rolename);
    }

    public void setDecsription(String description) {
        enterText(ROLEPAGE_ROLEDESCRIPTION_TEXT, description);
    }

    public void selectScope(String scope) {
       clickButton(ROLEPAGE_ADMINISTRATOR_RADIOBUTTON);
    }

    public void selectApplication(String application) {
        clickButtonByKeys(ROLEPAGE_APPLICATIONSCOPE_DROPLIST);
    }
    
    public void checklistMenu(String menu) {
        clickButton(ROLEPAGE_CHECKLIST);
    }

    public void clickSave() {
        clickButton(ROLEPAGE_SAVE_BUTTON);
    }
    public void resultMessage(String expected) {
        String actual = ROLEPAGE_RESULT_MESSAGE.getText();
        assertEquals(expected, actual);
    }
    
    public void getErrorMessage(String errMessage, String type){
        switch (type) { 
            case "rolename":
            String actualroleName = ROLEPAGE_ROLENAME_ALERT.getText();
            assertEquals(actualroleName, errMessage);
            break;

            default:
                LogUtils.error("please check parameters ..");
                break;
    }

}
}
