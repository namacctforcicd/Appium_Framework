package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SauceLabsTests {

    @Test
    public void androidSauce() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:app", "storage:filename=sl.apk");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "appium-build-NFH6Z");
        sauceOptions.setCapability("name", "InitialTest");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://appiumstudent:5e06ddea-63ba-47d1-8833-c05088ef82c9@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        AppiumDriver driver = new AndroidDriver(url, caps);
    }

    @Test
    public void iosSauceTest() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone.*");
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:app", "storage:filename=SauceLabs-Demo-App.ipa");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "appium-build-NFH6Z");
        sauceOptions.setCapability("name", "Wiiliams_iOS test");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://appiumstudent:5e06ddea-63ba-47d1-8833-c05088ef82c9@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        AppiumDriver driver = new IOSDriver(url, caps);


    }

    @Test
    public void iOSSauceTest2() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:app", "storage:filename=iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");
        caps.setCapability("appium:deviceName", "iPhone.*");
        caps.setCapability("appium:automationName", "XCUITest");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "appium-build-NFH6Z");
        sauceOptions.setCapability("name", "Second_iOS");
        caps.setCapability("sauce:options", sauceOptions);


        URL url = new URL("https://appiumstudent:5e06ddea-63ba-47d1-8833-c05088ef82c9@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        AppiumDriver driver = new IOSDriver(url, caps);

//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.perform_SuccessfulLogin("standard_user", "secret_sauce");

        Thread.sleep(5000);

        driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();

        Thread.sleep(5000);
        WebElement source = driver.findElement(MobileBy.AccessibilityId("test-Drag Handle"));
        WebElement target = driver.findElement(MobileBy.AccessibilityId("test-Cart drop zone"));
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(source.getLocation().x, source.getLocation().y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000)))
                .moveTo(PointOption.point(target.getLocation().x + 100, target.getLocation().y + 10))
                .release()
                .perform();

        driver.quit();
    }

    @Test
    public void androidRealDeviceTest() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=sl.apk");
        caps.setCapability("appium:deviceName", "Samsung.*");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "android-build");
        sauceOptions.setCapability("name", "androidRealDevice");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://appiumstudent:5e06ddea-63ba-47d1-8833-c05088ef82c9@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

        Thread.sleep(5000);

        driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']/android.widget.TextView")).click();

        Thread.sleep(5000);

        WebElement source = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"])[1]/android.widget.TextView"));
        WebElement target = driver.findElement(MobileBy.AccessibilityId("test-Cart drop zone"));

        TouchAction action = new TouchAction(driver);
        action.longPress(new ElementOption().withElement(source))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(new ElementOption().withElement(target))
                .release()
                .perform();

        Thread.sleep(5000);

        driver.quit();

    }
}
