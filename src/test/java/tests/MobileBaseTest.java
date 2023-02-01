package tests;

import core.drivers.MobileActions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class MobileBaseTest extends MobileActions {

//    private static AppiumDriver driver = null;
//    private static WebDriverWait wait = null;

    @Parameters({"appiumServerURL", "device"})
    @BeforeTest
    public void beforeTest(String appiumServerURL, String device) throws MalformedURLException {
        MobileActions.initDriver(device,appiumServerURL);
    }

    @AfterTest
    public void afterTest() {
        getMobileDriver().quit();
    }

//    public AppiumDriver getMobileDriver() {
//        return driver;
//    }
//
//    public WebDriverWait getWait() {
//        return MobileDriver.getWait();
//    }


}
