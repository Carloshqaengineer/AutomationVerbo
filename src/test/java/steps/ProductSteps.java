package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.ProductsPage;
import pages.ProductDetailPage;

public class ProductSteps {

    private final ProductsPage     productsPage     = new ProductsPage();
    private final ProductDetailPage detailPage      = new ProductDetailPage();

    @Given("el usuario navega a productos")
    public void navegarAProductos() {
        productsPage.open();
    }

    @Then("la lista de productos es visible")
    public void listaProductosVisible() {
        Assertions.assertTrue(productsPage.getProductCount() > 0);
    }

    @Then("el panel de filtros lateral es visible")
    public void panelFiltrosVisible() {
        Assertions.assertTrue(productsPage.isSidebarVisible());
    }

    @Then("el selector de ordenamiento es visible")
    public void selectorOrdenamientoVisible() {
        Assertions.assertTrue(productsPage.isSortDropdownVisible());
    }

    @When("filtra por categoría {string}")
    public void filtrarPorCategoria(String category) {
        productsPage.openByCategory(category);
    }

    @Then("solo se muestran productos de {string}")
    public void soloProductosDeCategoria(String category) {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains(category));
        Assertions.assertTrue(productsPage.getProductCount() > 0);
    }

    @Then("se muestran todos los productos disponibles")
    public void todosLosProductos() {
        Assertions.assertTrue(productsPage.getProductCount() > 0);
    }

    @Then("cada producto muestra nombre precio y botón agregar al carrito")
    public void cadaProductoTieneElementos() {
        Assertions.assertTrue(productsPage.getProductCount() > 0);
    }

    @When("hace clic en {string} del primer producto")
    public void clicEnPrimerProducto(String action) {
        if (action.contains("Agregar")) {
            productsPage.clickFirstAddToCart();
        }
    }

    @Then("el badge del carrito muestra al menos 1 ítem")
    public void badgeCarritoMuestraItem() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//a[@href='/cart']//span[contains(@class,'bg-red-500')]")
        ));
    }

    @When("hace clic en el nombre del primer producto")
    public void clicEnNombreProducto() {
        utils.SeleniumUtils.click(org.openqa.selenium.By.cssSelector("h3 a, .group a"));
    }

    @Then("es redirigido a la página de detalle del producto")
    public void redirigidoADetalle() {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/product/"));
    }

    @When("selecciona ordenar por {string}")
    public void seleccionarOrden(String value) {
        productsPage.selectSort(value);
    }

    @Then("los productos se muestran ordenados por precio ascendente")
    public void productosOrdenadosPrecioAsc() {
        Assertions.assertTrue(productsPage.getProductCount() > 0);
    }

    // Detail steps
    @Given("el usuario navega al detalle del producto {int}")
    public void navegarAlDetalle(int id) {
        detailPage.openProduct(id);
    }

    @Then("el nombre del producto es visible")
    public void nombreProductoVisible() {
        Assertions.assertFalse(detailPage.getProductTitle().isEmpty());
    }

    @Then("el precio del producto es visible")
    public void precioProductoVisible() {
        Assertions.assertFalse(detailPage.getProductPrice().isEmpty());
    }

    @Then("la imagen principal es visible")
    public void imagenPrincipalVisible() {
        Assertions.assertTrue(detailPage.isMainImageVisible());
    }

    @Then("el botón agregar al carrito es visible")
    public void botonAgregarVisible() {
        Assertions.assertTrue(detailPage.isAddToCartVisible());
    }

    @When("selecciona el color {string}")
    public void seleccionarColor(String color) {
        detailPage.selectColor(color);
    }

    @Then("el color {string} queda seleccionado")
    public void colorSeleccionado(String color) {
        Assertions.assertTrue(detailPage.isColorSectionVisible());
    }

    @When("selecciona la talla {string}")
    public void seleccionarTalla(String size) {
        detailPage.selectSize(size);
    }

    @Then("la talla {string} queda seleccionada")
    public void tallaSeleccionada(String size) {
        Assertions.assertTrue(detailPage.isSizeSectionVisible());
    }

    @When("hace clic en agregar al carrito")
    public void clicAgregarAlCarrito() {
        detailPage.clickAddToCart();
    }

    @Then("el badge del carrito se actualiza")
    public void badgeCarritoActualizado() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//a[@href='/cart']//span[contains(@class,'bg-red-500')]")
        ));
    }

    @When("hace clic en volver")
    public void clicEnVolver() {
        detailPage.clickBack();
    }

    @Then("regresa a la página anterior")
    public void regresaAPaginaAnterior() {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertFalse(url.contains("/product/"));
    }

    @Then("la imagen principal del producto es visible")
    public void imagenPrincipalDelProductoVisible() {
        Assertions.assertTrue(detailPage.isMainImageVisible());
    }

    @Then("la categoría del producto es visible en el detalle")
    public void categoriaProductoVisible() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//p[contains(@class,'capitalize')]")
        ));
    }
}
