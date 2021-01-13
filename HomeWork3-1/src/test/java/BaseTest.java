import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public abstract class BaseTest {
    protected static WebDriver chrome;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver_win32\\chromedriver.exe");
        chrome = new ChromeDriver();

        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void cleanup(){
        chrome.close();
    }

}
