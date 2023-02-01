package pages;


import core.drivers.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    final static Logger log = Logger.getLogger(HeaderPage.class);
    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement CART_ICON;

    @iOSXCUITFindBy(xpath="")
    @AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement MENU_ICON;

    @iOSXCUITFindBy
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]")
    WebElement SWAGLAB_LABEL;

    public HeaderPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), HeaderPage.class);
    }

    public void tap_Menu_Icon(){

        MobileActions.waitAndTapon(MENU_ICON);
    }
    public void tap_Cart_Icon(){
        MobileActions.waitAndTapon(CART_ICON);
    }

    public void swagLabelIsVisible(){
        MobileActions.elementIsOnDisplay(SWAGLAB_LABEL);
    }

}
