package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By errorsAdress = By.xpath("//*[@class='alert alert-danger']");
    private final By accountName  = By.xpath("//div[@class='header_user_info']//span");

    public String getErrorText(){
        return this.driver.findElement(errorsAdress).getText();
    }

    public String getAccountName(){
        return this.driver.findElement(accountName).getText();
    }

}
