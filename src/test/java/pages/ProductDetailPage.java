package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtils;

public class ProductDetailPage {

    private final By productTitle     = By.cssSelector("h1");
    private final By productPrice     = By.xpath("//p[contains(@class,'font-bold') and contains(text(),'$')]");
    private final By productCategory  = By.xpath("//p[contains(@class,'text-gray-500') and contains(@class,'capitalize')]");
    private final By colorButtons     = By.xpath("//button[contains(@class,'rounded') and contains(@class,'border')]");
    private final By sizeButtons      = By.xpath("//button[contains(@class,'w-12') or contains(@class,'w-10')]");
    private final By addToCartButton  = By.xpath("//button[contains(text(),'Agregar al carrito')]");
    private final By backButton       = By.xpath("//button[contains(text(),'Volver')]");
    private final By mainImage        = By.cssSelector("img[alt]");
    private final By prevImageBtn     = By.xpath("//button[contains(@class,'left-3')]");
    private final By nextImageBtn     = By.xpath("//button[contains(@class,'right-3')]");
    private final By thumbnails       = By.xpath("//button[contains(@class,'w-16') and contains(@class,'h-16')]");

    public void openProduct(int id)           { SeleniumUtils.navigateTo("/product/" + id); }
    public void clickAddToCart()              { SeleniumUtils.click(addToCartButton); }
    public void clickBack()                   { SeleniumUtils.click(backButton); }
    public void clickNextImage()              { SeleniumUtils.click(nextImageBtn); }
    public void clickPrevImage()              { SeleniumUtils.click(prevImageBtn); }

    public void selectColor(String colorName) {
        By colorBtn = By.xpath("//button[contains(text(),'" + colorName + "') and contains(@class,'rounded')]");
        SeleniumUtils.click(colorBtn);
    }

    public void selectSize(String size) {
        By sizeBtn = By.xpath("//button[text()='" + size + "']");
        SeleniumUtils.click(sizeBtn);
    }

    public String getProductTitle()           { return SeleniumUtils.getText(productTitle); }
    public String getProductPrice()           { return SeleniumUtils.getText(productPrice); }
    public boolean isAddToCartVisible()       { return SeleniumUtils.isDisplayed(addToCartButton); }
    public boolean isMainImageVisible()       { return SeleniumUtils.isDisplayed(mainImage); }
    public boolean isColorSectionVisible()    { return SeleniumUtils.isDisplayed(colorButtons); }
    public boolean isSizeSectionVisible()     { return SeleniumUtils.isDisplayed(sizeButtons); }
}
