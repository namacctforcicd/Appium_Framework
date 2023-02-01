package pages;

import core.drivers.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MobileActions {


    public enum PASSWORD {
        SECRET_SAUCE }

    public enum USERNAMES {
        STANDARD_USER,
        LOCKED_OUT_USER,
        PROBLEM_USER
    }
    // 1. Capture elements
    @iOSXCUITFindBy(accessibility = "test-Username")
    @AndroidFindBy(accessibility = "test-Username")
    WebElement USERNAME_TEXTFIELD;

    @iOSXCUITFindBy(accessibility = "test-Password")
    @AndroidFindBy(accessibility = "test-Password")
    WebElement PASSWORD_FIELD;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView")
    WebElement LOGIN_BUTTON;

    // 2. In constructor call PageFactory.initElements() methods
    public LoginPage(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // 3. Add actions on the elements in java methods
    public void enterText_UserNameTextField(String username) {
        waitClearAndEnterText(USERNAME_TEXTFIELD,username);
    }

    public void enterText_PasswordField(String password) {
        waitClearAndEnterText(PASSWORD_FIELD,password);
    }

    public void tapOn_LoginButton() {

       waitAndTapon(LOGIN_BUTTON);
    }

    public void perform_SuccessfulLogin(String username, String password) {
        waitClearAndEnterText(USERNAME_TEXTFIELD,username);
        waitClearAndEnterText(PASSWORD_FIELD,password);
       waitAndTapon(LOGIN_BUTTON);

    }


    public boolean is_UserNameDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(USERNAME_TEXTFIELD);
    }
    public boolean is_PasswordDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(PASSWORD_FIELD);
    }
    public boolean is_LoginButtonDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(LOGIN_BUTTON);
    }



}
