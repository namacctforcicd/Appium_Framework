package pages;

import core.drivers.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends MobileActions {

    @iOSXCUITFindBy(accessibility = "test-First Name")
    @AndroidFindBy(accessibility = "test-First Name")
    WebElement FIRSTNAME_TEXT;

    @iOSXCUITFindBy(accessibility = "test-Last Name")
    @AndroidFindBy(accessibility = "test-Last Name")
    WebElement LASTNAME_TEXT;

    @iOSXCUITFindBy(accessibility = "test-Zip/Postal Code")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    WebElement ZIPCODE_ENTER;

    @iOSXCUITFindBy(accessibility = "test-CANCEL")
    @AndroidFindBy(accessibility = "test-CANCEL")
    WebElement CANCEL_BUTTON;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-CONTINUE\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    WebElement CONTINUE_BUTTON;

    public CheckOutPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), CheckOutPage.class);

    }

    public void typeFirstName(String fName){

       waitClearAndEnterText(FIRSTNAME_TEXT,fName);
    }

    public void typeLastName(String lName){

        waitClearAndEnterText(LASTNAME_TEXT,lName);
    }

    public void typeZipCode(String zipCode){
        waitClearAndEnterText(ZIPCODE_ENTER,zipCode);

    }

    public void clickingCancelButton(){
        waitAndTapon(CANCEL_BUTTON);
    }

    public void continueButton(){
       waitAndTapon(CONTINUE_BUTTON);
    }
}
