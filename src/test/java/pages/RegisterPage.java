package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtils;

public class RegisterPage {

    private final By nameInput            = By.xpath("//input[not(@type='email') and not(@type='password')][1]");
    private final By emailInput           = By.cssSelector("input[type='email']");
    private final By passwordInput        = By.cssSelector("input[type='password'][1]");
    private final By confirmPasswordInput = By.xpath("(//input[@type='password'])[2]");
    private final By submitButton         = By.cssSelector("button[type='submit']");
    private final By errorMessage         = By.cssSelector(".text-red-600");
    private final By loginLink            = By.xpath("//a[@href='/login']");

    public void open()                                  { SeleniumUtils.navigateTo("/register"); }
    public void enterName(String name)                  { SeleniumUtils.type(nameInput, name); }
    public void enterEmail(String email)                { SeleniumUtils.type(emailInput, email); }
    public void enterPassword(String password)          { SeleniumUtils.type(passwordInput, password); }
    public void enterConfirmPassword(String password)   { SeleniumUtils.type(confirmPasswordInput, password); }
    public void clickSubmit()                           { SeleniumUtils.click(submitButton); }
    public void clickLoginLink()                        { SeleniumUtils.click(loginLink); }

    public void register(String name, String email, String password, String confirm) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirm);
        clickSubmit();
    }

    public String getErrorMessage()                     { return SeleniumUtils.getText(errorMessage); }
    public boolean isErrorDisplayed()                   { return SeleniumUtils.isDisplayed(errorMessage); }
    public boolean isRegisterPageDisplayed()            { return SeleniumUtils.isDisplayed(submitButton); }
}
