package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumUtils {

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
    }

    public static WebElement waitForElement(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void scrollTo(WebElement el) {
        ((JavascriptExecutor) DriverManager.getDriver())
            .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        try { Thread.sleep(300); } catch (InterruptedException ignored) {}
    }

    public static void click(By locator) {
        WebElement el = waitForClickable(locator);
        scrollTo(el);
        try {
            el.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].click();", el);
        }
    }

    public static void type(By locator, String text) {
        WebElement el = waitForElement(locator);
        scrollTo(el);
        el.clear();
        el.sendKeys(text);
    }

    public static String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public static boolean isDisplayed(By locator) {
        try {
            WebElement el = getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void navigateTo(String path) {
        DriverManager.getDriver().get(DriverManager.BASE_URL + path);
    }
}
