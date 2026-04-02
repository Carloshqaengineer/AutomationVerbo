package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtils;

public class CheckoutPage {

    // Progress steps
    private final By step1            = By.xpath("//div[contains(@class,'rounded-full')][1]");
    private final By step2            = By.xpath("//div[contains(@class,'rounded-full')][2]");
    private final By step3            = By.xpath("//div[contains(@class,'rounded-full')][3]");

    // Step 1 - Envío
    private final By deliveryRadio    = By.xpath("//input[@value='delivery']");
    private final By pickupRadio      = By.xpath("//input[@value='pickup']");
    private final By continueBtn      = By.xpath("//button[contains(text(),'Continuar')]");
    private final By backToCartBtn    = By.xpath("//button[contains(text(),'Volver al carrito')]");

    // Step 2 - Datos
    private final By nombreInput      = By.xpath("(//input[@type='text'])[1]");
    private final By apellidoInput    = By.xpath("(//input[@type='text'])[2]");
    private final By tipoDocSelect    = By.cssSelector("select");
    private final By nroDocInput      = By.xpath("(//input[@type='text'])[3]");
    private final By emailInput       = By.cssSelector("input[type='email']");
    private final By telefonoInput    = By.cssSelector(".PhoneInput input");
    private final By direccionInput   = By.xpath("//input[@placeholder[contains(.,'San Luis')]]");
    private final By cpInput          = By.xpath("//input[@placeholder[contains(.,'1425')]]");
    private final By backBtn          = By.xpath("//button[contains(text(),'Atrás')]");

    // Step 3 - Pago
    private final By transferRadio    = By.xpath("//input[@value='transfer']");
    private final By mpRadio          = By.xpath("//input[@value='mercadopago']");
    private final By fileUpload       = By.cssSelector("input[type='file']");
    private final By finalizarBtn     = By.xpath("//button[contains(text(),'Finalizar') or contains(text(),'MercadoPago')]");
    private final By cbuInfo          = By.xpath("//*[contains(text(),'CBU')]");

    // Modales
    private final By successModal     = By.xpath("//h3[contains(text(),'Pedido Recibido')]");
    private final By orderNumber      = By.xpath("//p[contains(text(),'#')]");
    private final By mpTutorialModal  = By.xpath("//h3[contains(text(),'MercadoPago')]");
    private final By mpNextBtn        = By.xpath("//button[contains(text(),'Siguiente')]");
    private final By mpCloseBtn       = By.xpath("//button[contains(text(),'Entendido')]");
    private final By mpDots           = By.xpath("//button[contains(@class,'rounded-full') and contains(@class,'h-1.5')]");
    private final By demoBanner       = By.xpath("//*[contains(text(),'Sitio de demostración')]");

    public void open()                                  { SeleniumUtils.navigateTo("/checkout"); }

    // Step 1
    public void selectDelivery()                        { SeleniumUtils.click(deliveryRadio); }
    public void selectPickup()                          { SeleniumUtils.click(pickupRadio); }
    public void clickContinue()                         { SeleniumUtils.click(continueBtn); }
    public void clickBack()                             { SeleniumUtils.click(backBtn); }
    public void clickBackToCart()                       { SeleniumUtils.click(backToCartBtn); }

    // Step 2
    public void enterNombre(String v)                   { SeleniumUtils.type(nombreInput, v); }
    public void enterApellido(String v)                 { SeleniumUtils.type(apellidoInput, v); }
    public void enterEmail(String v)                    { SeleniumUtils.type(emailInput, v); }
    public void enterDireccion(String v)                { SeleniumUtils.type(direccionInput, v); }
    public void enterCodigoPostal(String v)             { SeleniumUtils.type(cpInput, v); }

    public void selectTipoDoc(String value) {
        new org.openqa.selenium.support.ui.Select(
            utils.DriverManager.getDriver().findElement(tipoDocSelect)
        ).selectByValue(value);
    }

    public void enterNroDoc(String v)                   { SeleniumUtils.type(nroDocInput, v); }

    // Step 3
    public void selectTransfer()                        { SeleniumUtils.click(transferRadio); }
    public void selectMercadoPago()                     { SeleniumUtils.click(mpRadio); }
    public void clickFinalizar()                        { SeleniumUtils.click(finalizarBtn); }
    public void clickMpNext()                           { SeleniumUtils.click(mpNextBtn); }
    public void clickMpClose()                          { SeleniumUtils.click(mpCloseBtn); }

    public boolean isSuccessModalVisible()              { return SeleniumUtils.isDisplayed(successModal); }
    public boolean isMpTutorialVisible()                { return SeleniumUtils.isDisplayed(mpTutorialModal); }
    public boolean isDemoBannerVisible()                { return SeleniumUtils.isDisplayed(demoBanner); }
    public boolean isCbuInfoVisible()                   { return SeleniumUtils.isDisplayed(cbuInfo); }
    public String getOrderNumber()                      { return SeleniumUtils.getText(orderNumber); }

    public int getMpDotsCount() {
        return utils.DriverManager.getDriver().findElements(mpDots).size();
    }
}
