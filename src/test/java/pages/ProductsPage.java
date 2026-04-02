package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;
import java.util.List;

public class ProductsPage {

    private final By filterRemeras    = By.xpath("//a[contains(@href,'category=remeras')]");
    private final By filterBuzos      = By.xpath("//a[contains(@href,'category=buzos')]");
    private final By filterPantalones = By.xpath("//a[contains(@href,'category=pantalones')]");
    private final By filterAccesorios = By.xpath("//a[contains(@href,'category=accesorios')]");
    private final By filterTodos      = By.xpath("//a[@href='/products' and contains(text(),'Todos')]");
    private final By productCards     = By.cssSelector(".group");
    private final By addToCartButtons = By.xpath("//button[contains(text(),'Agregar al carrito')]");
    private final By productTitles    = By.cssSelector("h3");
    private final By productPrices    = By.xpath("//p[contains(@class,'font-bold') and contains(text(),'$')]");
    private final By sidebarFilter    = By.xpath("//h3[contains(text(),'FILTRAR POR')]");
    private final By sortDropdown     = By.cssSelector("select");
    private final By noResultsMsg     = By.xpath("//*[contains(text(),'No hay productos')]");

    public void open()                        { SeleniumUtils.navigateTo("/products"); }
    public void openByCategory(String cat)    { SeleniumUtils.navigateTo("/products?category=" + cat); }
    public void clickFilterRemeras()          { SeleniumUtils.click(filterRemeras); }
    public void clickFilterBuzos()            { SeleniumUtils.click(filterBuzos); }
    public void clickFilterPantalones()       { SeleniumUtils.click(filterPantalones); }
    public void clickFilterAccesorios()       { SeleniumUtils.click(filterAccesorios); }
    public void clickFilterTodos()            { SeleniumUtils.click(filterTodos); }
    public void clickFirstAddToCart()         { SeleniumUtils.click(addToCartButtons); }

    public void selectSort(String value) {
        new org.openqa.selenium.support.ui.Select(
            utils.DriverManager.getDriver().findElement(sortDropdown)
        ).selectByValue(value);
    }

    public int getProductCount() {
        return utils.DriverManager.getDriver().findElements(addToCartButtons).size();
    }

    public boolean isSidebarVisible()         { return SeleniumUtils.isDisplayed(sidebarFilter); }
    public boolean isNoResultsVisible()       { return SeleniumUtils.isDisplayed(noResultsMsg); }
    public boolean isSortDropdownVisible()    { return SeleniumUtils.isDisplayed(sortDropdown); }
}
