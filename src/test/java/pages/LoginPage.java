package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtils;

public class LoginPage {

    private final By emailInput    = By.cssSelector("input[type='email']");
    private final By passwordInput = By.cssSelector("input[type='password']");
    private final By submitButton  = By.cssSelector("button[type='submit']");
    private final By errorMessage  = By.cssSelector(".text-red-500");
    private final By registerLink  = By.xpath("//a[@href='/register']");
    private final By backButton    = By.xpath("//button[contains(.,'Volver')]");
    private final By verboLogo     = By.xpath("//a[contains(text(),'VERBO')]");

    public void open()                          { SeleniumUtils.navigateTo("/login"); }
    public void enterEmail(String email)        { SeleniumUtils.type(emailInput, email); }
    public void enterPassword(String password)  { SeleniumUtils.type(passwordInput, password); }
    public void clickSubmit()                   { SeleniumUtils.click(submitButton); }
    public void clickRegisterLink()             { SeleniumUtils.click(registerLink); }
    public void clickBack()                     { SeleniumUtils.click(backButton); }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    public String getErrorMessage()             { return SeleniumUtils.getText(errorMessage); }
    public boolean isErrorDisplayed()           { return SeleniumUtils.isDisplayed(errorMessage); }
    public boolean isLoginPageDisplayed()       { return SeleniumUtils.isDisplayed(submitButton); }
    public boolean isRegisterLinkVisible()      { return SeleniumUtils.isDisplayed(registerLink); }

    public String getCurrentUrl() {
        return utils.DriverManager.getDriver().getCurrentUrl();
    }
}
