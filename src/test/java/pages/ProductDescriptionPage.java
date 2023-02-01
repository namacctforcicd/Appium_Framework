package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

public class ProductDescriptionPage {

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView")
    WebElement SAUCE_LABS_BACKPACK_IMAGE;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-BACK TO PRODUCTS\"]/android.widget.TextView")
    WebElement BACK_TO_PRODUCTS_BUTTON;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    WebElement SAUCE_LABS_BAG_TEXT1;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    WebElement SAUCE_LABS_BAG_TEXT2;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(accessibility = "test-Price")
    WebElement ITEM_PRICE;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(accessibility = "test-ADD TO CART")
    WebElement ADD_TO_CART_BUTTON;

    public ProductDescriptionPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),ProductDescriptionPage.class);
    }

}
