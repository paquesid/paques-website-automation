package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dika Brenda Angkasa on 30/05/2022
 */

public class UserManagementElement {

    /**
     * this element for create user in user management page
     * @WebElement
     */

    @FindBy(css = ".title.f-16")
    protected WebElement USERMANAGEMENTPAGE_FORM_CREATEUSER_TITLE;
    
    @FindBy(css = "h5[class='f-15 m-auto']")
    protected WebElement USERMANAGEMENTPAGE_MODAL_SUCCESS_TAB;

    @FindBy(css = ".btn.btn-info.btn-outline.btn-sm.f-12.mx-auto.mt-3")
    protected WebElement USERMANAGEMENTPAGE_MODAL_OKE_BUTTON;

    @FindBy(css = "button[data-target='#createUser']")
    protected WebElement USERMANAGEMENTPAGE_CREATE_USER_BUTTON;

    @FindBy(xpath = "//h5[normalize-space()='User List']")
    protected WebElement USERMANAGEMENTPAGE_USERTAB_TEXT;

    /**
     * Form Create Users
     * @WebElement
     */

    @FindBy(id = "username")
    protected WebElement USERMANAGEMENTPAGE_USERNAME_TEXT;

    @FindBy(id = "email")
    protected WebElement USERMANAGEMENTPAGE_EMAIL_TEXT;

    @FindBy(id = "password")
    protected WebElement USERMANAGEMENTPAGE_PASSWORD_TEXT;

    @FindBy(id = "passwordConfirmation")
    protected WebElement USERMANAGEMENTPAGE_REPASSWORD_TEXT;

    @FindBy(id = "firstname")
    protected WebElement USERMANAGEMENTPAGE_FIRSTNAME_TEXT;

    @FindBy(id = "lastname")
    protected WebElement USERMANAGEMENTPAGE_LASTNAME_TEXT;

    @FindBy(id = "mat-select-2")
    protected WebElement USERMANAGEMENTPAGE_GROUP_DROPDOWN;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    protected WebElement USERMANAGEMENTPAGE_FORM_SAVE_BUTTON;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    protected WebElement USERMANAGEMENTPAGE_FORM_CANCEL_BUTTON;

    // End of Create User form
}
