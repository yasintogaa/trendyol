package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TrendyolMainPage extends TrendyolBasePage {

    final static String MAIN_PAGE_URL = "https://www.trendyol.com/";

    public TrendyolMainPage(WebDriver driver) {
        super(driver);
    }

    //ELEMENTS
    private WebElement fancyboxCloseBtn(){
        return driver.findElement(By.className("fancybox-close"));
    }
    private WebElement accountBtn(){
        return driver.findElement(By.id("accountBtn"));
    }


    //BEHAVIOURS
    private void closeFancybox(){
        fancyboxCloseBtn().click();
    }

    private void clickToAccountBtn(){
        accountBtn().click();
    }

    public void goToTrendyolHome(){
        driver.get(MAIN_PAGE_URL);
        this.isLoaded();
    }

    public void goToLoginPage() {
        closeFancybox();
        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("fancybox-overlay-fixed"))));
        }
        catch (Exception e){
            System.out.println("the fancybox could not be closed.");
        }
        clickToAccountBtn();
        isLoaded(TrendyolLoginPage.LOGIN_PAGE_URL);
    }
}
