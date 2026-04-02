package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.RegisterPage;

public class RegisterSteps {

    private final RegisterPage registerPage = new RegisterPage();

    @Given("el usuario navega al registro")
    public void navegarAlRegistro() {
        registerPage.open();
    }

    @Then("el formulario de registro es visible")
    public void formularioRegistroVisible() {
        Assertions.assertTrue(registerPage.isRegisterPageDisplayed());
    }

    @When("completa el nombre {string}")
    public void completarNombre(String name) {
        registerPage.enterName(name);
    }

    @When("completa el email de registro {string}")
    public void completarEmailRegistro(String email) {
        registerPage.enterEmail(email);
    }

    @When("completa la contraseña de registro {string}")
    public void completarPasswordRegistro(String password) {
        registerPage.enterPassword(password);
    }

    @When("confirma la contraseña {string}")
    public void confirmarPassword(String password) {
        registerPage.enterConfirmPassword(password);
    }

    @When("presiona crear cuenta")
    public void presionarCrearCuenta() {
        registerPage.clickSubmit();
    }

    @Then("es redirigido al login")
    public void redirigidoAlLogin() {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/login"));
    }

    @Then("se muestra error {string}")
    public void mostrarError(String errorText) {
        Assertions.assertTrue(registerPage.isErrorDisplayed());
        Assertions.assertTrue(registerPage.getErrorMessage().contains(errorText));
    }

    @Then("el link de iniciar sesión es visible")
    public void linkLoginVisible() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//a[@href='/login']")
        ));
    }

    @When("hace clic en el link de iniciar sesión")
    public void clicEnLogin() {
        registerPage.clickLoginLink();
    }
}
