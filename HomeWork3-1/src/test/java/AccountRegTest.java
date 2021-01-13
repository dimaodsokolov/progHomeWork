import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.*;



import static Utils.Adds.randomInt;

public class AccountRegTest extends BaseTest {
    MainPage mainPage;
    SignInPage signInPage;
    RegistrationPage registrationPage;
    Account account;
    MyAccountPage myAccountPage;

    @BeforeClass
    public static void beforeAccountRegTest() {
        chrome.navigate().to("http://automationpractice.com");
    }

    @Test
    public void testAccWithErrors() {
        mainPage = new MainPage(chrome);
        account = new Account();
        account.setGender("Mr");
        account.setFirstCustomerName("dima");
        account.setLastCustomerName("s");
        account.setEmail("testexample" + randomInt() + "@google.com");
        account.setPass("111111");

        account.setFirstName("dima");
        account.setLastName("s");
        account.setCompany("home");
        account.setAddress1("adr 1");
        account.setAddress2("adr 2");
        account.setCity("Od");

        account.setPostcode("12345");

        account.setMobilePhone("+380");
        account.setAlias("adress");
        signInPage = mainPage.openSignInPage();
        registrationPage = signInPage.openRegPage();

        myAccountPage = registrationPage.fillFirstFormAndSubmit(account);
        String expectedResultPage = "There are 3 errors";
        String actualResultPage = myAccountPage.getErrorText();
        Assert.assertTrue("test failed", actualResultPage.contains(expectedResultPage));

    }

    @Test
    public void testAccRegistration() {
        mainPage = new MainPage(chrome);
        account = new Account();
        account.setGender("Mr");
        account.setFirstCustomerName("dima");
        account.setLastCustomerName("s");
        account.setEmail("testexample" + randomInt() + "@google.com");
        account.setPass("111111");
        account.setDay("2");
        account.setMonth("3");
        account.setYear("2000");
        account.setFirstName("dima");
        account.setLastName("s");
        account.setCompany("home");
        account.setAddress1("adr 1");
        account.setAddress2("adr 2");
        account.setCity("Od");
        account.setState("Montana");
        account.setPostcode("12345");
        account.setCountry("United States");
        account.setMobilePhone("+380");
        account.setAlias("adress");
        signInPage = mainPage.openSignInPage();
        registrationPage = signInPage.openRegPage();
        myAccountPage = registrationPage.fillSecondFormAndSubmit(account);

        String expectedResultPage = account.getFirstCustomerName();

        String actualResultPage = myAccountPage.getAccountName();
        Assert.assertTrue("If test failed, user name  incorrect", actualResultPage.contains(expectedResultPage));


    }

    @Test
    public void testGoodsSearch()  {
        mainPage = new MainPage(chrome);

        mainPage.fillSearchField();
        mainPage.openSearchPage();
        mainPage.setListView();
        mainPage.addToCart();
        mainPage.clickProceedToCheckout();
        mainPage.clickIncreaseQty();


        String expectedTotalProductPrice = "$54.00";
        String actualTotalProductPrice = mainPage.getTotalProductPrice();
        Assert.assertEquals("TotalProductPrice is incorrect",expectedTotalProductPrice,actualTotalProductPrice);

        String actualTotalProducts = mainPage.getTotalProducts();
        Assert.assertEquals("TotalProducts is incorrect",expectedTotalProductPrice,actualTotalProducts);

        String expectedTotalShipping= "$2.00";
        String actualTotalShipping = mainPage.getTotalShipping();
        Assert.assertEquals("Shipping price is incorrect",expectedTotalShipping,actualTotalShipping);

        String expectedTotal = "$56.00";
        String actualTotal = mainPage.getTotalWoutTax();
        Assert.assertEquals("Total price w/o tax is incorrect",expectedTotal,actualTotal);

        String expectedTax = "$0.00";
        String actualTax = mainPage.getTax();
        Assert.assertEquals("Tax is incorrect",expectedTax,actualTax);

        String expectedTotalPrice = "$56.00";
        String actualTotalPrice = mainPage.getTotalPrice();
        Assert.assertEquals("Tax is incorrect",expectedTotalPrice,actualTotalPrice);

        mainPage.cleanShortCart();

        String expectedShortCart = "";
        String actualShortCart = mainPage.getItemsInShortCart();
        Assert.assertEquals("Not clean",expectedShortCart,actualShortCart);

    }


}
