import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class UIAutomatorTest {

    private AndroidDriver driver;
    private MobileObject mobileObject;
    private String empty = "  ";
    private String textSample = "Netology";

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        driver = new AndroidDriver(getUrl(), desiredCapabilities);
        mobileObject = new MobileObject(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @Test
    public void emptyField() {
        String textView = mobileObject.view.getText();

        mobileObject.inputField.isDisplayed();
        mobileObject.inputField.click();
        mobileObject.inputField.sendKeys(empty);

        mobileObject.btnChange.isDisplayed();
        mobileObject.btnChange.click();

        mobileObject.view.isDisplayed();
        String result = mobileObject.view.getText();
        Assertions.assertEquals(result, textView);
    }

    @Test
    public void newActivity() {
        mobileObject.inputField.isDisplayed();
        mobileObject.inputField.click();
        mobileObject.inputField.sendKeys(textSample);

        mobileObject.btnNewActivity.isDisplayed();
        mobileObject.btnNewActivity.click();

        mobileObject.resultActivity.isDisplayed();
        String result = mobileObject.resultActivity.getText();
        Assertions.assertEquals(result, textSample);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
