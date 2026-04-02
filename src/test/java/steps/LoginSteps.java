package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("el usuario navega al login")
    public void navegarAlLogin() {
        loginPage.open();
    }

    @Then("el formulario de login es visible")
    public void formularioLoginVisible() {
        Assertions.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("ingresa el email {string}")
    public void ingresarEmail(String email) {
        loginPage.enterEmail(email);
    }

    @When("ingresa la contraseña {string}")
    public void ingresarPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("presiona el botón de ingresar")
    public void presionarIngresar() {
        loginPage.clickSubmit();
    }

    @Then("es redirigido al homepage")
    public void redirigidoAlHomepage() {
        String url = loginPage.getCurrentUrl();
        Assertions.assertTrue(url.equals(utils.DriverManager.BASE_URL + "/") || url.equals(utils.DriverManager.BASE_URL));
    }

    @Then("se muestra un mensaje de error en el login")
    public void mensajeErrorLogin() {
        Assertions.assertTrue(loginPage.isErrorDisplayed());
    }

    @When("deja el campo email vacío")
    public void dejarEmailVacio() {
        // no ingresa nada
    }

    @When("deja el campo contraseña vacío")
    public void dejarPasswordVacio() {
        // no ingresa nada
    }

    @Then("el formulario no se envía")
    public void formularioNoSeEnvia() {
        String url = loginPage.getCurrentUrl();
        Assertions.assertTrue(url.contains("/login"));
    }

    @Then("el link de registro es visible")
    public void linkRegistroVisible() {
        Assertions.assertTrue(loginPage.isRegisterLinkVisible());
    }

    @When("hace clic en el link de registro")
    public void clicEnRegistro() {
        loginPage.clickRegisterLink();
    }

    @Then("es redirigido a la página de registro")
    public void redirigidoARegistro() {
        String url = loginPage.getCurrentUrl();
        Assertions.assertTrue(url.contains("/register"));
    }

    @Then("el campo contraseña es de tipo password")
    public void campoPaswordEsTipoPassword() {
        String type = utils.DriverManager.getDriver()
            .findElement(By.cssSelector("input[type='password']"))
            .getAttribute("type");
        Assertions.assertEquals("password", type);
    }
}
