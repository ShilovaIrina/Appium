import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileObject {
    WebElement inputField;
    WebElement btnChange;
    WebElement view;
    WebElement btnNewActivity;
    WebElement resultActivity;

    private AppiumDriver driver;

    MobileObject(AppiumDriver driver) {
        this.driver = driver;
        inputField = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        btnChange = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
        view = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
        btnNewActivity = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        resultActivity = driver.findElement(By.id("ru.netology.testing.uiautomator:id/text"));
    }
}
