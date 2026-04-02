package pages;

import org.openqa.selenium.By;
import utils.SeleniumUtils;

public class HomePage {

    // Header
    private final By logo             = By.xpath("//a[contains(.,'VERBO')]");
    private final By byCarlosHernando = By.xpath("//*[contains(text(),'by Carlos Hernando')]");
    private final By navRemeras       = By.xpath("//nav//a[contains(@href,'remeras')]");
    private final By navBuzos         = By.xpath("//nav//a[contains(@href,'buzos')]");
    private final By navPantalones    = By.xpath("//nav//a[contains(@href,'pantalones')]");
    private final By navAccesorios    = By.xpath("//nav//a[contains(@href,'accesorios')]");
    private final By navTodos         = By.xpath("//nav//a[contains(@href,'/products') and contains(text(),'Todos')]");
    private final By cartIcon         = By.xpath("//a[@href='/cart']");
    private final By bannerPromo      = By.xpath("//*[contains(text(),'MIPRIMERVERBO')]");

    // Hero
    private final By heroTitle        = By.xpath("//h1[contains(.,'Fe que se lleva')]");
    private final By heroCTA          = By.xpath("//a[contains(@href,'/products') and contains(text(),'Ver colección')]");

    // Secciones
    private final By featuredTitle    = By.xpath("//h2[contains(text(),'Productos Destacados')]");
    private final By categoriesTitle  = By.xpath("//h2[contains(text(),'Explora por Categorías')]");
    private final By categoryRemera   = By.xpath("//a[contains(@href,'remeras')]//h3[contains(text(),'Remeras')]");
    private final By categoryBuzo     = By.xpath("//a[contains(@href,'buzos')]//h3[contains(text(),'Buzos')]");
    private final By categoryPantalon = By.xpath("//a[contains(@href,'pantalones')]//h3[contains(text(),'Pantalones')]");
    private final By categoryAccesorio= By.xpath("//a[contains(@href,'accesorios')]//h3[contains(text(),'Accesorios')]");

    public void open()                        { SeleniumUtils.navigateTo("/"); }
    public void clickLogo()                   { SeleniumUtils.click(logo); }
    public void clickNavRemeras()             { SeleniumUtils.click(navRemeras); }
    public void clickNavBuzos()               { SeleniumUtils.click(navBuzos); }
    public void clickNavPantalones()          { SeleniumUtils.click(navPantalones); }
    public void clickNavAccesorios()          { SeleniumUtils.click(navAccesorios); }
    public void clickNavTodos()               { SeleniumUtils.click(navTodos); }
    public void clickCartIcon()               { SeleniumUtils.click(cartIcon); }
    public void clickHeroCTA()                { SeleniumUtils.click(heroCTA); }
    public void clickCategoryRemera()         { SeleniumUtils.click(categoryRemera); }
    public void clickCategoryBuzo()           { SeleniumUtils.click(categoryBuzo); }
    public void clickCategoryPantalon()       { SeleniumUtils.click(categoryPantalon); }
    public void clickCategoryAccesorio()      { SeleniumUtils.click(categoryAccesorio); }

    public boolean isHeroTitleVisible()       { return SeleniumUtils.isDisplayed(heroTitle); }
    public boolean isFeaturedSectionVisible() { return SeleniumUtils.isDisplayed(featuredTitle); }
    public boolean isCategoriesSectionVisible(){ return SeleniumUtils.isDisplayed(categoriesTitle); }
    public boolean isBannerVisible()          { return SeleniumUtils.isDisplayed(bannerPromo); }
    public boolean isLogoVisible()            { return SeleniumUtils.isDisplayed(logo); }
    public boolean isByCarlosVisible()        { return SeleniumUtils.isDisplayed(byCarlosHernando); }
}
