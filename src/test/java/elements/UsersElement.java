package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dika Brenda Angkasa on 30/05/2022
 */

public class UsersElement {

    /**
     * this element for create user in user management page
     * @CREATE-USER
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

    @FindBy(xpath = "//h4[normalize-space()='User Management']")
    protected WebElement USERMANAGEMENTPAGE_GOTO_USERMANAGEMENT_BUTTON;

    /**
     * Form Create Users & Update Users
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

    @FindBy(id = "mat-select-1")
    protected WebElement USERMANAGEMENTPAGE_GROUP_DROPDOWN;

    @FindBy(xpath = "//span[normalize-space()='automation']")
    protected WebElement USERMANAGEMENTPAGE_VALUE_AUTOMATION_TEXT;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    protected WebElement USERMANAGEMENTPAGE_FORM_SAVE_BUTTON;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    protected WebElement USERMANAGEMENTPAGE_FORM_CANCEL_BUTTON;

    // End of Create User form

    /**
     * this element for cases in Update Users
     * @UPDATE-USER
     */

     @FindBy(css = "button[mattooltip='Edit User']")
     protected WebElement USERMANAGEMENTPAGE_UPDATE_BUTTON;

     @FindBy(css = ".title.f-16")
     protected WebElement USERMANAGEMENTPAGE_FORM_UPDATEUSER_TITLE;

     @FindBy(css = "input[placeholder='Search user']")
     protected WebElement USERMANAGEMENTPAGE_SEARCHUSER_TEXT;

     // End of Update User Form


     /**
      * this element for cases in Change Password in user datatable
      * @Change-Password
      */

    @FindBy(css = ".zmdi.zmdi-key")
    protected WebElement USERMANAGEMENTPAGE_CHANGE_PASSWORD_BUTTON;

    @FindBy(css = ".title.f-16")
    protected WebElement USERMANAGEMENTPAGE_CHANGE_PASSWORD_TITLE;

    // end of Change Password

    /**
     * this element for cases in Delete Password in user datatable
     * @DELETE-USER
     */

    @FindBy(css = ".zmdi.zmdi-delete")
    protected WebElement USERMANAGEMENTPAGE_DELETE_BUTTON;

    @FindBy(css = ".kt-portlet__head-title")
    protected WebElement USERMANAGEMENTPAGE_TITLE_DELETE_TEXT;

    @FindBy(css = ".mat-button.mat-button-base.mat-primary")
    protected WebElement USERMANAGEMENTPAGE_CONFIRM_DELETE_BUTTON;

    @FindBy(css = "button[class='mat-button mat-button-base']")
    protected WebElement USERMANAGEMENTPAGE_CANCEL_DELETE_BUTTON;

    @FindBy(css = ".kt-mat-snackbar__message")
    protected WebElement USERMANAGEMENTPAGE_SUCCESS_MESSAGE_TEXT;

    @FindBy(css = "")
    protected WebElement USERMANAGEMENTPAGE_USERNAME_DATATABLE;

    // End of Delete datatable


    /**
     * this element for error case in form Create Users
     * @ERROR-MESSAGE
     */

     @FindBy(id = "mat-error-0")
     protected WebElement ERROR_USERMANAGEMENTPAGE_USERNAME;
     // Username is required 

     @FindBy(id = "mat-error-8")
     protected WebElement ERROR_USERMANAGEMENTPAGE_EMAIL;
     // Email is required or type must be email 

     @FindBy(id = "mat-error-9")
     protected WebElement ERROR_USERMANAGEMENTPAGE_PASSWORD;
     // Password is required 

     @FindBy(id = "mat-error-10")
     protected WebElement ERROR_USERMANAGEMENTPAGE_REPASSWORD;
     // Password confirmation is required

     @FindBy(css = "p[role='alert']")
     protected WebElement ERROR_USERMANAGEMENTPAGE_PASSWORDNOTMATCH;
     // Passwords do not Match 

     @FindBy(id = "mat-error-11")
     protected WebElement ERROR_USERMANAGEMENTPAGE_FIRSTNAME;
     // First name is required 

     @FindBy(id = "mat-error-12")
     protected WebElement ERROR_USERMANGEMENTPAGE_LASTNAME;
     // Last name is required 
}
