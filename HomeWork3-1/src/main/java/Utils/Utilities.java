package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Utilities {

    public static int randomInt(){
        Random rn = new Random();
        return rn.nextInt();
    }


}
