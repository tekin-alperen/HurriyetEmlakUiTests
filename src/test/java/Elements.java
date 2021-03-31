import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Elements {

    private static final String BASE_URL = "https://www.hurriyetemlak.com/";
    WebDriver driver;

    public Elements() {
        driver = new ChromeDriver();
    }

    public void setup() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public void oneWaitElement(int second) {
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    public void getSendKeyElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void clearElement(By by) {
        driver.findElement(by).clear();
    }

    public void getSendKeyKeyTab(By by) {
        driver.findElement(by).sendKeys(Keys.TAB);
    }

    public void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void scrollElement(String scroll) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + scroll + ")");

    }

    public void closeDriver() {
        driver.quit();
    }

}
