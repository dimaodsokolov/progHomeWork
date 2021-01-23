package pages;

import Utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    private String goodsName = "blouse";

    private String priceAsc = "price:asc";

    private final static  String DRESSES_TAB = "#block_top_menu > ul > li:nth-child(2) > a";
    private final static String TOTAL_PRODUCT_PRICE = "$54.00";
    @FindBy (xpath = "//*[@class='login']")
    private WebElement singIn;

    @FindBy (id = "search_query_top")
    private WebElement searchField;

    @FindBy (name = "submit_search")
    private WebElement searchButton;


    @FindBy (xpath = "//i[@class='icon-th-list']")
    private WebElement listView ;

    @FindBy (xpath = "//a[@class='button ajax_add_to_cart_button btn btn-default']//span")
    private WebElement addCartButton;

    @FindBy (xpath = "//*[contains(@class, 'button btn btn-default')]")

    private WebElement proceedToCheckout;

    @FindBy (id = "cart_quantity_up_2_7_0_0")
    private WebElement increaseQty;

    @FindBy (id = "total_product_price_2_7_0")
    private WebElement totalProductPrice;

    @FindBy (id = "total_product")
    private WebElement totalProducts;

    @FindBy (id ="total_shipping")
    private WebElement totalShipping;

    @FindBy (id = "total_price_without_tax")
    private WebElement totalWoutTax;

    @FindBy (id = "total_tax")
    private WebElement tax;

    @FindBy (id = "total_price_container")
    private WebElement totalPrice;

   // @FindBy (className = "ajax_cart_no_product")
    @FindBy (id="summary_products_quantity")
    private WebElement itemsInShortCart;

    @FindBy (className = "cart_quantity_delete")
    private WebElement delete;

    @FindBy (css = DRESSES_TAB)
    private WebElement dressesTab;

    @FindBy (id="uniform-layered_id_attribute_group_3")
    private WebElement sortByLsize;

    @FindBy (id="selectProductSort")
    private WebElement sortByPrice;

    @FindBy (xpath = "(//a[contains(@class, 'button ajax_add_to_cart_button')])[5]")
    private WebElement firstGoodsCart;

    @FindBy (xpath = "(//a[contains(@class, 'button ajax_add_to_cart_button')])[3]")
    private WebElement secondGoodsCart;

    @FindBy (xpath = "//span[contains(@class, 'continue btn')]")
    private WebElement continueShipping;

    @FindBy (xpath = "//*[contains(@title ,'View my shopping cart')]")
    private WebElement shopCart;

    @FindBy (xpath = "(//span[contains(@class,'price-percent-reduction small')])[1]")
    private WebElement clearanceFirstGoods;

    @FindBy (xpath = "(//span[contains(@class,'price-percent-reduction small')])[2]")
    private WebElement clearanceSecondGoods;

    @FindBy (id = "cgv")
    private WebElement iAgreeButton;

    @FindBy (xpath = "//*[contains(@class,'price cart_block_total ajax_block_cart_total')]")
    private WebElement shopCartTotal;

    @FindBy (xpath = "(//*[contains(@class,'address_firstname')])[2]")
    private WebElement billingFormFirstLastName;

    @FindBy (xpath = "(//*[contains(@class,'address_address1')])[2]")
    private WebElement billingFormAddress;

    @FindBy (xpath = "(//*[contains(@class,'address_city ')])[2]")
    private WebElement billingFormCityStatePost;

    @FindBy (xpath = "(//*[contains(@class,'address_country_name')])[2]")
    private WebElement billingFormCountry;

    @FindBy (xpath = "(//*[contains(@class,'address_phone_mobile')])[2]")
    private WebElement billingFormMobilePhone;



    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public SignInPage openSignInPage() {
        singIn.click();
        return new SignInPage(driver);
    }

    public void fillSearchField() {
        searchField.clear();
        searchField.sendKeys(goodsName);
    }

    public MainPage openSearchPage() {
        searchButton.click();
        return this;
    }

    public void setListView() {
        listView.click();
    }

    public void clickProceedToCheckout() {
        scrollToItem(proceedToCheckout);
        proceedToCheckout.click();
    }

    public void addToCart() {
        addCartButton.click();
    }

    public void clickIncreaseQty() {

        increaseQty.click();

    }


    public String getTotalProductPrice() {
        new WebDriverWait(driver, 4).
                until(ExpectedConditions.textToBePresentInElement
                        (totalProductPrice, TOTAL_PRODUCT_PRICE));
        return totalProductPrice.getText();
    }


    public String getTotalProducts() {
        return totalProducts.getText();
    }

    public String getTotalShipping() {
        return totalShipping.getText();
    }

    public String getTotalWoutTax() {
        return totalWoutTax.getText();
    }

    public String getTax() {
        return tax.getText();
    }

    public String getTotalPrice() {
        moveToElement(totalPrice);
        return totalPrice.getText();
    }

    public String getItemsInShortCart() {
        return itemsInShortCart.getText();
    }

    public void cleanShortCart() {
        delete.click();
    }

    public MainPage clickDressesTab(){
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DRESSES_TAB))).click();

        return new MainPage(driver);
    }
    public void sortBySizeL(){
        sortByLsize.click();
    }
    public void selectPriceSort (){
    WebElement selectDropDown = sortByPrice;
        Select sortDropDown = new Select(selectDropDown);
        sortDropDown.selectByValue(priceAsc);
    }
    public void navigateAndClickItem1(){
        Actions actions = new Actions(driver);
        actions.moveToElement(firstGoodsCart).build().perform();
        firstGoodsCart.click();
    }
    public void navigateAndClickItem2() {
        Actions actions = new Actions(driver);
        actions.moveToElement(secondGoodsCart).build().perform();
        secondGoodsCart.click();
    }
    public  void scrollToItem(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public  void moveToElement(WebElement element){
        Actions action = new Actions(driver);

        action.moveToElement(element).build().perform();
    }
    public String getBillingFormFirstLastName() {
        return billingFormFirstLastName.getText();
    }

    public String getBillingFormAddress() {
        return billingFormAddress.getText();
    }

    public String getBillingFormCityStatePost(){ return billingFormCityStatePost.getText();}

    public String getBillingFormCountry() {
        return billingFormCountry.getText();
    }

    public String getBillingFormMobilePhone() {
        return billingFormMobilePhone.getText();
    }


    public void clickContinueShop(){
        continueShipping.click();
    }

    public String getClearanceFirstGoods(){
       return (clearanceFirstGoods.getText()).trim();
    }

    public String getClearanceSecondGoods(){
        return  (clearanceSecondGoods.getText()).trim();
    }

    public void clickShopCart(){
        scrollToItem(shopCart);
        shopCart.click();

    }

    public void clickIAgreeButton(){
        iAgreeButton.click();
    }
    public String getShopCartTotal(){
        moveToElement(shopCart);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(shopCartTotal));
        return shopCartTotal.getText();
    }
}
