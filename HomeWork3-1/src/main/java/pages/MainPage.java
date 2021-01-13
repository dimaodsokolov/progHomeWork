package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;


    private By logIn = By.xpath("//*[@class='login']");
    private By searchField = By.id("search_query_top");
    private By searchButton = By.name("submit_search");
    private String goodsName = "blouse";
    private By listView = By.xpath("//i[@class='icon-th-list']");
    private By addCartButton = By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']//span");
    private By proceedToCheckout = By.xpath("//*[@class='btn btn-default button button-medium']");
    private By increaseQty = By.id("cart_quantity_up_2_7_0_0");
    private By totalProductPrice = By.id("total_product_price_2_7_0");

    private By totalProducts = By.id("total_product");
    private By totalShipping = By.id("total_shipping");
    private By totalWoutTax = By.id("total_price_without_tax");
    private By tax = By.id("total_tax");
    private By totalPrice = By.id("total_price");
    private By itemsInShortCart = By.className("ajax_cart_no_product");
    private By delete = By.className("cart_quantity_delete");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public SignInPage openSignInPage() {
        this.driver.findElement(logIn).click();
        return new SignInPage(driver);
    }

    public void fillSearchField() {
        driver.findElement(searchField).clear();
        this.driver.findElement(searchField).sendKeys(goodsName);
    }

    public MainPage openSearchPage() {
        driver.findElement(searchButton).click();
        return this;
    }

    public void setListView() {
        driver.findElement(listView).click();
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckout).click();
    }

    public void addToCart() {
        driver.findElement(addCartButton).click();
    }

    public void clickIncreaseQty() {

        driver.findElement(increaseQty).click();

    }


    public String getTotalProductPrice() {
        WebElement elemTotalProd = driver.findElement(totalProductPrice);
        new WebDriverWait(driver, 4).
                until(ExpectedConditions.textToBePresentInElement(elemTotalProd, "$54.00"));
        return elemTotalProd.getText();
    }


    public String getTotalProducts() {
        return this.driver.findElement(totalProducts).getText();
    }

    public String getTotalShipping() {
        return this.driver.findElement(totalShipping).getText();
    }

    public String getTotalWoutTax() {
        return this.driver.findElement(totalWoutTax).getText();
    }

    public String getTax() {
        return this.driver.findElement(tax).getText();
    }

    public String getTotalPrice() {
        return this.driver.findElement(totalPrice).getText();
    }

    public String getItemsInShortCart() {
        return this.driver.findElement(itemsInShortCart).getText();
    }

    public void cleanShortCart() {
        driver.findElement(delete).click();
    }

}
