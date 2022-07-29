package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import elements.GroupPageElement;
import static helper.TestInstrument.*;

public class GroupPage extends GroupPageElement {

    protected WebDriver driver;
    
    public GroupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void getTextTitleGroup(String expected){
        if(isElementExist(GROUPPAGE_TITLE, 2)){
            String actual = GROUPPAGE_TITLE.getText();
            assertEquals(expected, actual);
        }
    } 

    public void clickGroupTab() {
        clickButton(GROUPPAGE_TAB);
        refreshPage();
        delay(2000);
        clickButton(GROUPPAGE_TAB);
    }

    public void clickCreateGroup() {
        clickButton(GROUPPAGE_CREATE_BUTTON);
    }
    
    public void getTextTitleCreateGroup(String expected){
        if(isElementExist(GROUPPAGE_CREATEGROUP_TITLE, 2)){
            String actual = GROUPPAGE_CREATEGROUP_TITLE.getText();
            assertEquals(expected, actual);
        }
    }

    public void setGroupName(String groupName){
        enterText(GROUPPAGE_GROUPNAME_FIELD, groupName);
    }

    public void setGroupDescription(String groupDescription){
        enterText(GROUPPAGE_GROUPDECRIPTION_FILED, groupDescription);
    }

    public void selectRole(){
        clickButton(GROUPPAGE_ROLE);
    }

    public void clickSave(){
        clickButton(GROUPPAGE_SAVE_BUTTON);
    }

    public void resultMessageGroup(String expected) {
        if(isElementExist(GROUPPAGE_CREATE_RESULT, 2)){
            String actual = GROUPPAGE_CREATE_RESULT.getText();
            assertEquals(expected, actual);
        }
    }


    public void getErrorMessage(String errMessage, String type){
        switch (type) { 
            case "rolename":
                String actualroleName = GROUPPAGE_ALERT_GROUPNAME.getText();
                assertEquals(actualroleName, errMessage);
                break;
    
            default:
                throw new Error("please check parameter");
        }

    }
    /*
     * Edit Group
     */

    public void searchGroup(String name){
        delay(2000);
        enterTextByKeys(GROUPPAGE_SEARCH, name);
    }

    public void clickEditGroup(String name){
        try{
            // refreshPage();
            searchGroup(name);
            // delay(2000);
        } catch (AssertionError e) {
            e.printStackTrace();
        } finally {
            clickButton(GROUPPAGE_EDIT_ICON);
        }
    }

    public void getTitleFormUpdateGroup(String expected){
        if(isElementExist(GROUPPAGE_EDIT_TITLE, 2)){
            String actual = GROUPPAGE_EDIT_TITLE.getText();
            assertEquals(expected, actual);
        }
    }

    public void editGroupDescription(String GroupDescription){
        enterText(GROUPPAGE_GROUPDECRIPTION_FILED, GroupDescription);
    }

    public void resultMessageEditGroup(String expected) {
        if(isElementExist(GROUPPAGE_EDIT_RESULT, 2)){
            String actual = GROUPPAGE_EDIT_RESULT.getText();
            assertEquals(expected, actual);
        }
    }
}
