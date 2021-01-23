package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.Utilities.randomInt;

public class SignInPage {
    private final WebDriver driver;


    private final By emailToCreateAccount = By.id("email_create");
    private final String Email = "testexample" + randomInt() + "@google.com";
    private final By createAccount = By.name("SubmitCreate");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail() {
        driver.findElement(emailToCreateAccount).clear();
        this.driver.findElement(emailToCreateAccount).sendKeys(Email);

    }

    public SignInPage clickCreate() {
        this.driver.findElement(createAccount).click();
        return new SignInPage(driver);
    }

    public RegistrationPage openRegPage() {
        enterEmail();
        this.driver.findElement(createAccount).click();

        return new RegistrationPage(driver);
    }
}
