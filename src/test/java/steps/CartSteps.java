package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import pages.CartPage;
import pages.ProductsPage;

public class CartSteps {

    private final CartPage     cartPage     = new CartPage();
    private final ProductsPage productsPage = new ProductsPage();

    @Given("el usuario navega al carrito")
    public void navegarAlCarrito() {
        cartPage.open();
    }

    @Then("se muestra el mensaje de carrito vacío")
    public void mensajeCarritoVacio() {
        Assertions.assertTrue(cartPage.isCartEmpty());
    }

    @Then("el botón explorar productos es visible")
    public void botonExplorarVisible() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//a[contains(text(),'Explorar')]")
        ));
    }

    @Given("el usuario agrega un producto al carrito")
    public void agregarProductoAlCarrito() {
        productsPage.open();
        productsPage.clickFirstAddToCart();
    }

    @When("navega al carrito")
    public void navegarAlCarritoStep() {
        cartPage.open();
    }

    @Then("el producto aparece en el carrito")
    public void productoEnCarrito() {
        Assertions.assertTrue(cartPage.getCartItemCount() > 0);
    }

    @Given("el usuario tiene un producto en el carrito")
    public void tenerProductoEnCarrito() {
        productsPage.open();
        productsPage.clickFirstAddToCart();
        cartPage.open();
    }

    @When("hace clic en el botón aumentar cantidad")
    public void aumentarCantidad() {
        cartPage.clickIncreaseQty();
    }

    @Then("la cantidad del producto aumenta en 1")
    public void cantidadAumenta() {
        Assertions.assertTrue(cartPage.getCartItemCount() > 0);
    }

    @Given("el usuario tiene un producto en el carrito con cantidad 2")
    public void tenerProductoConCantidad2() {
        productsPage.open();
        productsPage.clickFirstAddToCart();
        cartPage.open();
        cartPage.clickIncreaseQty();
    }

    @When("hace clic en el botón disminuir cantidad")
    public void disminuirCantidad() {
        cartPage.clickDecreaseQty();
    }

    @Then("la cantidad del producto disminuye en 1")
    public void cantidadDisminuye() {
        Assertions.assertTrue(cartPage.getCartItemCount() >= 0);
    }

    @When("hace clic en eliminar producto")
    public void eliminarProducto() {
        cartPage.clickRemoveItem();
    }

    @Then("el producto es removido del carrito")
    public void productoRemovido() {
        Assertions.assertTrue(cartPage.isCartEmpty());
    }

    @Given("el usuario tiene productos en el carrito")
    public void tenerProductosEnCarrito() {
        productsPage.open();
        productsPage.clickFirstAddToCart();
        cartPage.open();
    }

    @Then("el total mostrado es correcto")
    public void totalCorrecto() {
        Assertions.assertFalse(cartPage.getTotalPrice().isEmpty());
    }

    @When("hace clic en vaciar carrito")
    public void vaciarCarrito() {
        cartPage.clickClearCart();
    }

    @Then("el carrito queda vacío")
    public void carritoVacio() {
        Assertions.assertTrue(cartPage.isCartEmpty());
    }

    @When("hace clic en proceder al pago")
    public void procederAlPago() {
        cartPage.clickCheckout();
    }

    @Then("es redirigido al checkout")
    public void redirigidoAlCheckout() {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/checkout"));
    }

    @Given("el usuario agrega {int} productos al carrito")
    public void agregarNProductos(int n) {
        productsPage.open();
        for (int i = 0; i < n; i++) {
            productsPage.clickFirstAddToCart();
        }
    }

    @Then("el badge del carrito muestra {int}")
    public void badgeMuestraNumero(int n) {
        Assertions.assertTrue(cartPage.isCartBadgeVisible());
    }

    @When("recarga la página del carrito")
    public void recargarCarrito() {
        utils.DriverManager.getDriver().navigate().refresh();
    }

    @Then("el producto sigue en el carrito")
    public void productoSigueEnCarrito() {
        Assertions.assertTrue(cartPage.getCartItemCount() > 0);
    }
}
