import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;

import static Utils.Utilities.randomInt;

public class Test6thLesson extends BaseTest {
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
    public void testAccRegistrationAndBuyingGoods() {
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
        account.setFirstName("");
        account.setLastName("");
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

        mainPage = mainPage.clickDressesTab();
        mainPage.setListView();
        /*mainPage.sortBySizeL();   //those two method's doesn't work on the site
        mainPage.selectPriceSort();*/
        mainPage.navigateAndClickItem1();
        mainPage.clickContinueShop();
        mainPage.navigateAndClickItem2();
        mainPage.clickContinueShop();
        mainPage.clickShopCart();

        String actualItemsInShopCart = mainPage.getItemsInShortCart();
        String expectedItemsItShopCart = "2 Products";
        soft.assertEquals(actualItemsInShopCart, expectedItemsItShopCart, "Invalid products quantity");

        String expectedClearanceFirstGoods = "-20%";
        String actualClearanceFirstGoods = mainPage.getClearanceFirstGoods();
        soft.assertEquals(actualClearanceFirstGoods, expectedClearanceFirstGoods,
                "Different clearance of first good");

        String expectedClearanceSecondGoods = "-5%";
        String actualClearanceSecondGoods = mainPage.getClearanceSecondGoods();
        soft.assertEquals(actualClearanceSecondGoods, expectedClearanceSecondGoods,
                "Different clearance of second good");


        mainPage.clickProceedToCheckout();

        String expectedFirstLastName = mainPage.getBillingFormFirstLastName();
        String actualFirstLastName = account.getFirstCustomerName() + " " + account.getLastCustomerName();
        soft.assertEquals(actualFirstLastName,expectedFirstLastName,
                "Firstname and lastname are incorrect in billing form");

        String expectedFormAdress = mainPage.getBillingFormAddress();
        String actualFormAdress = account.getAddress1() + " " + account.getAddress2();
        soft.assertEquals(expectedFormAdress,actualFormAdress,
                "Adress1 and adress2 are incorrect in billing form");

        String expectedFormCityStatePost = mainPage.getBillingFormCityStatePost();
        String actualFormCityStatePost = account.getCity() + ", " + account.getState() + " " + account.getPostcode();
        soft.assertEquals(expectedFormCityStatePost, actualFormCityStatePost,
                "City, state, post is incorrect in billing form");

        String expectedFormCountry = mainPage.getBillingFormCountry();
        String actualFormCountry = account.getCountry();
        soft.assertEquals(expectedFormCountry,actualFormCountry,"Country is incorrect in billing form ");

        String expectedFormMobilePhone = mainPage.getBillingFormMobilePhone();
        String actualFormMobilePhone = account.getMobilePhone();
        soft.assertEquals(expectedFormMobilePhone,actualFormMobilePhone,"Mobile phone is incorrect in billing form ");


        mainPage.clickProceedToCheckout();
        mainPage.clickIAgreeButton();
        mainPage.clickProceedToCheckout();

        String actualPaymentTotalPrice = mainPage.getTotalPrice();
        String expectedCardTotalPrice = mainPage.getShopCartTotal();
        soft.assertEquals(actualPaymentTotalPrice, expectedCardTotalPrice, "Payment and card total differs");


        soft.assertAll();

    }
}
