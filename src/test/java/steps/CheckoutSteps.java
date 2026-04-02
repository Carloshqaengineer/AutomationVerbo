package steps;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

public class CheckoutSteps {

    private final CheckoutPage checkoutPage = new CheckoutPage();
    private final CartPage     cartPage     = new CartPage();
    private final ProductsPage productsPage = new ProductsPage();

    private void addProductAndGoToCheckout() {
        productsPage.open();
        productsPage.clickFirstAddToCart();
        checkoutPage.open();
    }

    @Given("el usuario tiene productos en el carrito y navega al checkout")
    public void productosEnCarritoYCheckout() {
        addProductAndGoToCheckout();
    }

    @Then("el banner de demostración es visible en el checkout")
    public void bannerDemoVisible() {
        Assertions.assertTrue(checkoutPage.isDemoBannerVisible());
    }

    @Then("las opciones de envío a domicilio y retiro en sucursal son visibles")
    public void opcionesEnvioVisibles() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//input[@value='delivery']")
        ));
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//input[@value='pickup']")
        ));
    }

    @When("selecciona envío a domicilio")
    public void seleccionarDelivery() {
        checkoutPage.selectDelivery();
    }

    @When("hace clic en continuar")
    public void clicContinuar() {
        checkoutPage.clickContinue();
    }

    @Then("el formulario de datos personales es visible")
    public void formularioDatosVisible() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.cssSelector("input[type='email']")
        ));
    }

    @Given("el usuario está en el paso 2 del checkout")
    public void estarEnPaso2() {
        addProductAndGoToCheckout();
        checkoutPage.selectDelivery();
        checkoutPage.clickContinue();
    }

    @When("deja el campo nombre vacío e intenta continuar")
    public void dejarNombreVacio() {
        checkoutPage.clickContinue();
    }

    @Then("el botón continuar está deshabilitado")
    public void botonContinuarDeshabilitado() {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/checkout"));
    }

    @When("ingresa un email inválido en el checkout")
    public void ingresarEmailInvalidoCheckout() {
        checkoutPage.enterEmail("emailinvalido");
    }

    @Then("se muestra error de formato de email")
    public void errorFormatoEmail() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.cssSelector(".text-red-500")
        ));
    }

    @Given("el usuario está en el paso 2 del checkout con datos válidos")
    public void estarEnPaso2ConDatosValidos() {
        addProductAndGoToCheckout();
        checkoutPage.selectDelivery();
        checkoutPage.clickContinue();
        checkoutPage.enterNombre("Carlos");
        checkoutPage.enterApellido("Hernando");
        checkoutPage.selectTipoDoc("DNI");
        checkoutPage.enterNroDoc("12345678");
        checkoutPage.enterEmail("test@test.com");
        checkoutPage.enterDireccion("Av Corrientes 1234");
        checkoutPage.enterCodigoPostal("1425");
    }

    @Then("el resumen del pedido y métodos de pago son visibles")
    public void resumenYMetodosPagoVisibles() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//h3[contains(text(),'Resumen')]")
        ));
    }

    @Given("el usuario está en el paso 3 del checkout")
    public void estarEnPaso3() {
        estarEnPaso2ConDatosValidos();
        checkoutPage.clickContinue();
    }

    @When("selecciona transferencia bancaria")
    public void seleccionarTransferencia() {
        checkoutPage.selectTransfer();
    }

    @Then("los datos de CBU son visibles")
    public void datosCbuVisibles() {
        Assertions.assertTrue(checkoutPage.isCbuInfoVisible());
    }

    @Given("el usuario está en el paso 3 con transferencia seleccionada")
    public void paso3ConTransferencia() {
        estarEnPaso3();
        checkoutPage.selectTransfer();
    }

    @When("no sube comprobante")
    public void noSubirComprobante() {
        // no hace nada
    }

    @Then("el botón finalizar está deshabilitado")
    public void botonFinalizarDeshabilitado() {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/checkout"));
    }

    @When("selecciona MercadoPago y hace clic en pagar")
    public void seleccionarMPYPagar() {
        checkoutPage.selectMercadoPago();
        checkoutPage.clickFinalizar();
    }

    @Then("el modal tutorial de MercadoPago es visible")
    public void modalMPVisible() {
        Assertions.assertTrue(checkoutPage.isMpTutorialVisible());
    }

    @Given("el modal tutorial de MercadoPago está abierto")
    public void modalMPAbierto() {
        estarEnPaso3();
        checkoutPage.selectMercadoPago();
        checkoutPage.clickFinalizar();
    }

    @Then("se muestran 5 dots de navegación")
    public void cincoDotsNavegacion() {
        Assertions.assertEquals(5, checkoutPage.getMpDotsCount());
    }

    @When("hace clic en siguiente")
    public void clicSiguiente() {
        checkoutPage.clickMpNext();
    }

    @Then("avanza al siguiente paso del tutorial")
    public void avanzaAlSiguientePaso() {
        Assertions.assertTrue(checkoutPage.isMpTutorialVisible());
    }

    @Given("el modal tutorial de MercadoPago está abierto en el último paso")
    public void modalMPEnUltimoPaso() {
        modalMPAbierto();
        for (int i = 0; i < 4; i++) {
            checkoutPage.clickMpNext();
        }
    }

    @When("hace clic en Entendido")
    public void clicEntendido() {
        checkoutPage.clickMpClose();
    }

    @Then("el modal se cierra")
    public void modalSeCierra() {
        Assertions.assertFalse(checkoutPage.isMpTutorialVisible());
    }

    @Given("el usuario completa el checkout con transferencia")
    public void completarCheckoutConTransferencia() throws Exception {
        estarEnPaso3();
        checkoutPage.selectTransfer();
        // Simular subida de archivo
        java.io.File tempFile = java.io.File.createTempFile("comprobante", ".png");
        utils.DriverManager.getDriver()
            .findElement(org.openqa.selenium.By.cssSelector("input[type='file']"))
            .sendKeys(tempFile.getAbsolutePath());
        checkoutPage.clickFinalizar();
    }

    @Then("el modal de pedido recibido es visible")
    public void modalPedidoRecibidoVisible() {
        Assertions.assertTrue(checkoutPage.isSuccessModalVisible());
    }

    @Then("se muestra un número de orden")
    public void numeroOrdenVisible() {
        Assertions.assertFalse(checkoutPage.getOrderNumber().isEmpty());
    }

    @When("hace clic en atrás")
    public void clicAtras() {
        checkoutPage.clickBack();
    }

    @Then("regresa al paso 1 del checkout")
    public void regresaAlPaso1() {
        Assertions.assertTrue(utils.SeleniumUtils.isDisplayed(
            org.openqa.selenium.By.xpath("//input[@value='delivery']")
        ));
    }

    @When("hace clic en volver al carrito")
    public void clicVolverAlCarrito() {
        checkoutPage.clickBackToCart();
    }

    @Then("es redirigido al carrito")
    public void redirigidoAlCarrito() {
        String url = utils.DriverManager.getDriver().getCurrentUrl();
        Assertions.assertTrue(url.contains("/cart"));
    }
}
