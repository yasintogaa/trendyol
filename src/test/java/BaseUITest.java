import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public abstract class BaseUITest {

    static WebDriver driver = null;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/drivers/geckodriver_macos");
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver_macos");
    }

    @BeforeMethod
    public void beforeMethod(String browsers) {

        //testng.xml Browser Parameters

        if(browsers.equalsIgnoreCase("FF"))
        {
            //For Firefox
            driver = new FirefoxDriver();
        }else if(browsers.equalsIgnoreCase("CH"))
        {
            //For Chrome
            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,10);

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
