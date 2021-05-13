package app.ios.test.automation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {

    protected IOSDriver<WebElement> driver;

    @BeforeEach
    public void setUp() throws IOException {
        String deviceName = System.getenv("IOS_DEVICE_NAME");
        String platformVersion = System.getenv("IOS_PLATFORM_VERSION");
        String appFolder = System.getenv("IOS_APP_FOLDER");
        String appFile = System.getenv("IOS_APP_FILE");
        String udid = System.getenv("IOS_UDID");

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, appFolder == null ? "app/" : appFolder);
        File app = new File(appDir.getCanonicalPath(), appFile == null ? "TestApp.app.zip" : appFile);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName == null ? "iPhone 8" : deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion == null ? "12.2" : platformVersion);
        capabilities.setCapability(MobileCapabilityType.UDID, udid == null ? "1E119969-364E-42D3-8BA0-E6A9277EACED" : udid);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new IOSDriver<>(getServiceUrl(), capabilities);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public URL getServiceUrl() throws MalformedURLException {
        String appiumUrl = System.getenv("APPIUM_URL");
        return new URL(appiumUrl == null ? "http://localhost:4723/wd/hub" : appiumUrl);
    }

}
