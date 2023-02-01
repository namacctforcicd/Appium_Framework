package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.ItemPage;
import pages.LoginPage;
import pages.MenuPage;

import java.net.MalformedURLException;
import java.time.Duration;

public class SwagLabsLoginTests extends MobileBaseTest {

    @Test
    public void testSwagLabTest1() throws MalformedURLException, InterruptedException {
        //3. Perform actions using appium driver

        LoginPage loginPage = new LoginPage(getMobileDriver());
        loginPage.perform_SuccessfulLogin("standard_user", "secret_sauce");

        WebElement source = getMobileDriver().findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"])[1]/android.widget.TextView"));
      //  WebElement target =  getMobileDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]"));

      //  WebElement source = getMobileDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name=\"test-Drag Handle\"]/XCUIElementTypeStaticText)[1]"));

        WebElement target =  getMobileDriver().findElement(MobileBy.AccessibilityId("test-Cart drop zone"));
        TouchAction action = new TouchAction(getMobileDriver());
        action.press(PointOption.point(source.getLocation().x, source.getLocation().y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000)))
                .moveTo(PointOption.point(target.getLocation().x+100, target.getLocation().y+10))
                .release()
                .perform();

//        ItemPage ip = new ItemPage(getMobileDriver());
//        Thread.sleep(5000);
//        ip.menuButton();
//        MenuPage mp = new MenuPage(getMobileDriver());
//        Thread.sleep(5000);
//        mp.logoutSelection();

        getMobileDriver().quit();


//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-Username"))).sendKeys("standard_user");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-Password"))).sendKeys("secret_sauce");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-LOGIN"))).click();


    }

//    @Test
//    public void testSwagLabTest2() throws MalformedURLException, InterruptedException {
//        //3. Perform actions using appium driver
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-Username"))).sendKeys("standard_user");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-Password"))).sendKeys("secret_sauce");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-LOGIN"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-Menu"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-LOGOUT"))).click();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("test-LOGOUT"))));
//    }



}
