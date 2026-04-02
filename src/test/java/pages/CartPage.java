package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtils;

public class CartPage {

    private final By cartTitle        = By.xpath("//h1[contains(text(),'Carrito')]");
    private final By emptyCartMsg     = By.xpath("//h1[contains(text(),'vacío')]");
    private final By exploreBtn       = By.xpath("//a[contains(text(),'Explorar productos')]");
    private final By checkoutBtn      = By.xpath("//a[@href='/checkout']");
    private final By clearCartBtn     = By.xpath("//button[contains(text(),'Vaciar carrito')]");
    private final By cartItems        = By.cssSelector(".border-b.border-gray-200");
    private final By increaseQtyBtns  = By.xpath("//button[text()='+']");
    private final By decreaseQtyBtns  = By.xpath("//button[text()='-']");
    private final By removeItemBtns   = By.xpath("//button[contains(text(),'Eliminar')]");
    private final By totalPrice       = By.xpath("//span[contains(text(),'Total:')]/following-sibling::span");
    private final By cartBadge        = By.xpath("//a[@href='/cart']//span[contains(@class,'bg-red-500')]");

    public void open()                        { SeleniumUtils.navigateTo("/cart"); }
    public void clickCheckout()               { SeleniumUtils.click(checkoutBtn); }
    public void clickClearCart()              { SeleniumUtils.click(clearCartBtn); }
    public void clickExploreProducts()        { SeleniumUtils.click(exploreBtn); }
    public void clickIncreaseQty()            { SeleniumUtils.click(increaseQtyBtns); }
    public void clickDecreaseQty()            { SeleniumUtils.click(decreaseQtyBtns); }
    public void clickRemoveItem()             { SeleniumUtils.click(removeItemBtns); }

    public boolean isCartEmpty()              { return SeleniumUtils.isDisplayed(emptyCartMsg); }
    public boolean isCheckoutBtnVisible()     { return SeleniumUtils.isDisplayed(checkoutBtn); }
    public boolean isCartBadgeVisible()       { return SeleniumUtils.isDisplayed(cartBadge); }
    public String getTotalPrice()             { return SeleniumUtils.getText(totalPrice); }

    public int getCartItemCount() {
        return utils.DriverManager.getDriver().findElements(cartItems).size();
    }
}
