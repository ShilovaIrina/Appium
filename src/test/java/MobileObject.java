import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObject {
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    MobileElement inputField;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    MobileElement btnChange;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    MobileElement view;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    MobileElement btnNewActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    MobileElement resultActivity;


    private AppiumDriver driver;

    MobileObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}
