package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class onBoardingElement {

    @FindBy(xpath = "//a[normalize-space()='START']")
    protected WebElement ONBOARDING_START_BUTTON;

    @FindBy(css = ".welcome")
    protected WebElement ONBOARDING_HOME_TITLE;

    @FindBy(css = ".f-14")
    protected WebElement ONBOARDING_VERSION_TEXT;
}
