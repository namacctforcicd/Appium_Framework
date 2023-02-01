package pages;

import core.drivers.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends MobileActions {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-CONTINUE SHOPPING\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]/android.widget.TextView")
    WebElement CONTINUE_SHOPPING;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-CHECKOUT\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    WebElement CHECKOUT_BUTTON;


    public CartPage(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), CartPage.class);
    }

    public void contShop(){

      waitAndTapon(CONTINUE_SHOPPING);
    }

    public void checkOut(){

        waitAndTapon(CHECKOUT_BUTTON);
    }


}
