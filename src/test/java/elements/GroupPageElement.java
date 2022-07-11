package elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yusdriani 14/06/2022
 */
public class GroupPageElement {
 
    /*
     * @CREATE-GROUP
     */


    @FindBy(css = ".col-lg-7 col-md-6 col-sm-12" )
    protected
    WebElement GROUPPAGE_TITLE;

    @FindBy(xpath = "//*[normalize-space()='Groups']")
    protected
    WebElement GROUPPAGE_TAB;
    
    @FindBy(xpath = "//button[normalize-space()='Create Group']")
    protected
    WebElement GROUPPAGE_CREATE_BUTTON;

    @FindBy(css = ".title.f-16")
    protected
    WebElement GROUPPAGE_CREATEGROUP_TITLE;

    @FindBy(id = "groupname")
    protected
    WebElement GROUPPAGE_GROUPNAME_FIELD;

    @FindBy(id = "mat-input-1")
    protected
    WebElement GROUPPAGE_GROUPDECRIPTION_FILED;

    @FindBy(xpath = "//label[normalize-space()='nonadmin0706']")
    protected
    WebElement GROUPPAGE_ROLE;

    @FindBy(css = "button[class='btn btn-info btn-outline btn-sm f-12']")
    protected
    WebElement GROUPPAGE_SAVE_BUTTON;

    @FindBy(id = "cdk-descri bedby-message-container")
    protected
    WebElement GROUPPAGE_CREATE_RESULT;

    @FindBy(id = "mat-error-0")
    protected
    WebElement GROUPPAGE_ALERT_GROUPNAME;

    /*
    * Edit Form
    */

    @FindBy(css = "button[mattooltip='Edit Group']")
    protected
    WebElement GROUPPAGE_EDIT_ICON;

    @FindBy(css= "button[class='btn btn-info btn-outline btn-sm f-12']")
    protected
    WebElement GROUPPAGE_EDIT_SAVEBUUTTON;

    @FindBy(css = "input[placeholder='Search group']")
    protected
    WebElement GROUPPAGE_SEARCH;

    @FindBy(css = ".title.f-16")
    protected
    WebElement GROUPPAGE_EDIT_TITLE;

    @FindBy(css = ".kt-mat-snackbar__message")
    protected
    WebElement GROUPPAGE_EDIT_RESULT;
}
