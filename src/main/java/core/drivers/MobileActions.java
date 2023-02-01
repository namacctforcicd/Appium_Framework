package core.drivers;

import core.readers.ReadCapabilityFromJSON;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MobileActions {

    private static AppiumDriver driver = null;
    private static WebDriverWait wait = null;
    final static Logger log = Logger.getLogger(MobileActions.class);
    private static DesiredCapabilities capabilities = null;

    public static void initDriver(String deviceConfig, String appiumServerURL) {
        capabilities = ReadCapabilityFromJSON.getDeviceCapabilities(deviceConfig + ".json");
        log.info("Capabilities successfully initialized");
        capabilities.setJavascriptEnabled(true);
        try {
            if (ReadCapabilityFromJSON.is_IOSDriver()) {
                driver = new IOSDriver(new URL(appiumServerURL), capabilities);
                log.info("IOS driver initialized");
            }
            else if (ReadCapabilityFromJSON.is_AndroidDriver()) {
                driver = new AndroidDriver(new URL(appiumServerURL), capabilities);
                log.info("Android driver initialized");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 300);
        log.info("WebDriverWait 'wait' initialized with wait object");
    }

    public static AppiumDriver getMobileDriver() {

        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void waitClearAndEnterText(WebElement we, String text){
        log.info("Waiting for element " + we.toString());
        getWait().until(ExpectedConditions.elementToBeClickable(we));
        we.clear();
        we.sendKeys(text);
    }

    public static void waitAndTapon(WebElement we){
        log.info("I tapped on element " + we.toString());
        getWait().until(ExpectedConditions.elementToBeClickable(we)).click();
    }

    public static void elementIsOnDisplay(WebElement we){
        log.info("element " + we.toString() + " is on display");
        we.isDisplayed();
    }

    public static boolean is_IOSDRIVER(){
        if(getMobileDriver() instanceof IOSDriver)  {

            return true;}
        else {
            return false;
        }
    }

    public static boolean is_AndroidDRIVER(){
        if(getMobileDriver() instanceof AndroidDriver)  {

            return true;}
        else {
            return false;
        }
    }

    public static String getElementTextByAttribute(WebElement e, Attributes attribute) {
        String a = attribute.name().toLowerCase();
        if(a.contains("_"))
            a = a.replace("_","-");
        log.info("Get element text by attribute '"+a+"': " + e.toString());
        String value = null;
        try {
            value = e.getAttribute(a);
        }
        catch(WebDriverException ee) {
            log.info("Attribute: "+ a + " error: NOT FOUND");
        }
        return value;
    }

    public static String waitAnd_GetElementByAttribute(WebElement e, Attributes attribute) {
        String a = attribute.name().toLowerCase();
        if(a.contains("_"))
            a = a.replace("_","-");
        log.info("Wait and get element text by attribute '\"+a+\"': " + e.toString());
        String value = null;
        try {
            value = waitFor_ElementClickable(e).getAttribute(a);
        }
        catch(WebDriverException ee) {
            log.info("Attribute: "+ a + " error: NOT FOUND");
        }
        return value;
    }

    public static String getElementTextByAttribute(By by, Attributes attribute) {
        String a = attribute.name().toLowerCase();
        log.info("Get element text by attribute '\"+a+\"': " + by.toString());
        return getMobileDriver().findElement(by).getAttribute(a);
    }

    public static WebElement waitFor_ElementClickable(WebElement e) {
        log.info("Waiting for element: " + e.toString());
        return getWait().until(ExpectedConditions.elementToBeClickable(e));
    }

    public static WebElement waitFor_ElementClickable(By by) {
        log.info("Waiting for element by: " + by.toString());
        return getWait().until(ExpectedConditions.elementToBeClickable(getMobileDriver().findElement(by)));
    }

    public static boolean waitFor_ElementToBeDisplayed(WebElement e) {
        log.info("Waiting and validating isElementDisplayed on screen: " + e.toString());
        return waitFor_ElementClickable(e).isDisplayed();
    }

    public static void performSwipeLeftJS(WebElement element) {
        //swipe left on element
        Map<String, Object> args = new HashMap<>();
        args.put("element",((MobileElement)element).getId());
        args.put("direction", "left");
        driver.executeScript("mobile:swipe", args);
    }

    public static void performSwipeRightJS(WebElement element) {
        //swipe right on element
        Map<String, Object> args = new HashMap<>();
        args.put("element",((MobileElement)element).getId());
        args.put("direction", "right");
        driver.executeScript("mobile:swipe", args);
    }

}
