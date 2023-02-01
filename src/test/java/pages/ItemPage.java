package pages;

import core.drivers.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends MobileActions {

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Item title\"])[2]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[2]")
    WebElement SAUCE_LABS_BIKE_LIGHT;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"test-ADD TO CART\"])[2]")
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]/android.widget.TextView")
    WebElement ADD_TO_CART;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Modal Selector Button\"]/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    WebElement TEST_MODAL;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Toggle\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView")
    WebElement TOGGLE_BUTTON;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Menu\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement TEST_MENU;


    public ItemPage(AppiumDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),ItemPage.class);
    }

    public void sauceLabLight(){

       elementIsOnDisplay(SAUCE_LABS_BIKE_LIGHT);
    }

    public void addingToCart(){
       waitAndTapon(ADD_TO_CART);
    }

    public void testModalItem(){

        waitAndTapon(TEST_MODAL);
    }

    public void togg_Butt(){

        waitAndTapon(TOGGLE_BUTTON);
    }

    public void menuButton(){

        waitAndTapon(TEST_MENU);
    }

}
