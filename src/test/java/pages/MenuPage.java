package pages;

import core.drivers.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends MobileActions {

    @iOSXCUITFindBy(accessibility = "test-WEBVIEW")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-WEBVIEW\"]/android.widget.TextView" )
    WebElement WEBVIEW_ITEM;

    @iOSXCUITFindBy(accessibility = "test-GEO LOCATION")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-GEO LOCATION\"]/android.widget.TextView")
    WebElement GEOLOCATION;

    @iOSXCUITFindBy(accessibility = "test-LOGOUT")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]/android.widget.TextView")
    WebElement LOG_OUT;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Close\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Close\"]/android.widget.ImageView")
    WebElement X_CLOSE;

    public MenuPage(AppiumDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver),MenuPage.class);
    }

    public void webViewSelect(){

        waitAndTapon(WEBVIEW_ITEM);
    }

    public void geoLocationSelection(){

        waitAndTapon(GEOLOCATION);
    }

    public void logoutSelection(){

        waitAndTapon(LOG_OUT);
    }

    public void xOut(){

        waitAndTapon(X_CLOSE);
    }


}
