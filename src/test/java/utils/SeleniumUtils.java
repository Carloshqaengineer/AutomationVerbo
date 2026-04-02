package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumUtils {

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public static WebElement waitForElement(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void click(By locator) {
        waitForClickable(locator).click();
    }

    public static void type(By locator, String text) {
        WebElement el = waitForElement(locator);
        el.clear();
        el.sendKeys(text);
    }

    public static String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public static boolean isDisplayed(By locator) {
        try {
            return DriverManager.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void navigateTo(String path) {
        DriverManager.getDriver().get(DriverManager.BASE_URL + path);
    }
}
