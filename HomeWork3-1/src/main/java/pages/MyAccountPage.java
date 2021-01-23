package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath = "//*[@class='alert alert-danger']")
    private WebElement errorsAdress;

    @FindBy (xpath = "//div[@class='header_user_info']//span")
    private  WebElement accountName;

    public String getErrorText(){
        return errorsAdress.getText();
    }

    public String getAccountName(){
        return accountName.getText();
    }

}
