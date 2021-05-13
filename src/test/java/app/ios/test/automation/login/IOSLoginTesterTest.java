package app.ios.test.automation.login;

import app.ios.test.automation.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Tag("login")
public class IOSLoginTesterTest extends BaseTest {

    @Test
    public void testLoginWithCredentials() {
        String buttonElementId = "show alert";
        IOSElement buttonElement = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(buttonElementId)));
        buttonElement.click();

        String alertTitleId = "Cool title";
        IOSElement alertTitleElement = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(alertTitleId)));

        String alertTitle = alertTitleElement.getText();
        Assertions.assertEquals(alertTitle, "Cool title");

        IOSElement okButtonElement = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("OK")));
        okButtonElement.click();
    }

}
