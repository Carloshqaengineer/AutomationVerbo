package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

public class HomeSteps {

    private final HomePage homePage = new HomePage();

    @Given("el usuario navega al homepage")
    public void navegarAlHomepage() {
        homePage.open();
    }

    @Then("el título hero {string} es visible")
    public void heroTitleVisible(String title) {
        Assertions.assertTrue(homePage.isHeroTitleVisible(), "Hero title no visible");
    }

    @Then("la sección {string} es visible")
    public void seccionVisible(String section) {
        if (section.contains("Destacados")) {
            Assertions.assertTrue(homePage.isFeaturedSectionVisible());
        } else if (section.contains("Categorías")) {
            Assertions.assertTrue(homePage.isCategoriesSectionVisible());
        }
    }

    @Then("el logo {string} es visible en el header")
    public void logoVisible(String logo) {
        Assertions.assertTrue(homePage.isLogoVisible());
    }

    @Then("la firma {string} es visible")
    public void firmaVisible(String firma) {
        Assertions.assertTrue(homePage.isByCarlosVisible());
    }

    @Then("el banner con código {string} es visible en el header")
    public void bannerVisible(String code) {
        Assertions.assertTrue(homePage.isBannerVisible());
    }

    @When("hace clic en {string}")
    public void hacerClic(String element) {
        switch (element) {
            case "Ver colección" -> homePage.clickHeroCTA();
            case "Remeras"      -> homePage.clickNavRemeras();
            case "Buzos"        -> homePage.clickNavBuzos();
            case "Pantalones"   -> homePage.clickNavPantalones();
            case "Accesorios"   -> homePage.clickNavAccesorios();
            case "Todos"        -> homePage.clickNavTodos();
        }
    }

    @Then("es redirigido a la página de productos")
    public void redirigidoAProductos() {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/products"));
    }

    @Then("es redirigido a productos filtrados por {string}")
    public void redirigidoACategoria(String category) {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains(category));
    }

    @When("hace clic en {string} en el nav")
    public void hacerClicEnNav(String element) {
        hacerClic(element);
    }

    @When("hace clic en la categoría {string}")
    public void hacerClicEnCategoria(String category) {
        switch (category) {
            case "Remeras"    -> homePage.clickCategoryRemera();
            case "Buzos"      -> homePage.clickCategoryBuzo();
            case "Pantalones" -> homePage.clickCategoryPantalon();
            case "Accesorios" -> homePage.clickCategoryAccesorio();
        }
    }

    @Then("el ícono del carrito es visible en el header")
    public void carritoIconoVisible() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//a[@href='/cart']")
        ));
    }
}
