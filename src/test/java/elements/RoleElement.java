package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoleElement {
    @FindBy(xpath = "//a[normalize-space()='Roles']")
    protected
    WebElement ROLEPAGE_ROLETAB;

    @FindBy(xpath = "//button[normalize-space()='Create Role']")
    protected
    WebElement ROlEPAGE_CREATEROLEBUTTON;

    @FindBy(id = "rolename")
    protected
    WebElement ROLEPAGE_ROLENAME_TEXT;

    @FindBy(id = "roledesc")
    protected
    WebElement ROLEPAGE_ROLEDESCRIPTION_TEXT;

    @FindBy(xpath = "//label[@for='checkbox-2fe0832d-92a7-4a9c-a446-c8da663d3ed1']")
    protected
    WebElement ROLEPAGE_ADMINISTRATOR_RADIOBUTTON;

    @FindBy(name = "row_limit")
    protected
    WebElement ROLEPAGE_APPLICATIONSCOPE_DROPLIST;

    @FindBy(xpath = "//label[@for='checkAll']")
    protected
    WebElement ROLEPAGE_CHECKLIST;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    protected
    WebElement ROLEPAGE_SAVE_BUTTON;

    @FindBy(css = ".kt-mat-snackbar__message")
    protected
    WebElement ROLEPAGE_RESULT_MESSAGE;

    @FindBy(xpath = "//a[@class='nav-link f-14 active']")
    protected
    WebElement ONBOARDING_TAB_ROLES;

    @FindBy(xpath = "//button[normalize-space()='Create Role']")
    protected
    WebElement ONBOARDING_CREATEROLE_button;

    @FindBy(id = "mat-error-0")
    protected
    WebElement ROLEPAGE_ROLENAME_ALERT;

    @FindBy(id = "mat-error-1")
    protected
    WebElement ROLEPAGE_ROLEDESCRIPTION_ALERT;

    @FindBy(id = "mat-error-2")
    protected
    WebElement ROLEPAGE_SCOPE_ALERT;
}
