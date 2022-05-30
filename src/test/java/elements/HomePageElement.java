package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElement {

    @FindBy(css = ".zmdi.zmdi-settings")
    protected WebElement HOMEPAGE_SETTING_BUTTON;

    @FindBy(xpath = "//h4[normalize-space()='User Management']")
    protected WebElement HOMEPAGE_USERMANAGEMENT_BUTTON;

    @FindBy(xpath = "//h4[normalize-space()='Notifications Center']")
    protected WebElement HOMEPAGE_NOTIFICATION_CENTER_BUTTON;

    @FindBy(xpath = "//button[normalize-space()='Close this window']")
    protected WebElement HOMEPAGE_MODAL_DISMISS_BUTTON;

    @FindBy(xpath = "//h2[contains(text(),'Let’s get started!')]")
    protected WebElement HOMEPAGE_MODAL_TEXT;

    /**
     * Element below for TAB in the Header
     * @DATA-PROCESSING
     * @DATA-VISUALIZATIONS
     * @MENU-BUILDER
     */

    @FindBy(xpath = "//a[contains(text(),'DATA PROCESSING')]")
    protected WebElement HOMEPAGE_DATAPROCESSING_TAB_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'DATA VISUALIZATIONS')]")
    protected WebElement HOMEPAGE_DATAVISUALIZATION_TAB_BUTTON;

    @FindBy(xpath = "//a[contains(text(),'MENU BUILDER')]")
    protected WebElement HOMEPAGE_MENUBUILDER_TAB_BUTTON;

    // End of element TAB in Header
}
