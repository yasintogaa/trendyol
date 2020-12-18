package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TrendyolLoginPage extends TrendyolBasePage {

    final static String LOGIN_PAGE_URL = "https://www.trendyol.com/giris";

    public TrendyolLoginPage(WebDriver driver) {
        super(driver);
    }

    //ELEMENTS
    private WebElement loginEmailInput(){
        return driver.findElement(By.id("login-email"));
    }

    private WebElement loginPasswordInput(){
        return driver.findElement(By.id("login-password-input"));
    }
    private WebElement loginBtn(){
        return driver.findElement(By.xpath("//div[@class='q-layout login']//span[text()='Giriş Yap']"));
    }

    //BEHAVIOURS
    private void enterEmail(String email){
        loginEmailInput().sendKeys(email);
    }
    private void enterPassword(String password){
        loginPasswordInput().sendKeys(password);
    }
    private void clickToLoginBtn(){
        loginBtn().click();
    }

    public void doLogin(String username, String password) {
        enterEmail(username);
        enterPassword(password);
        clickToLoginBtn();
        this.isLoaded(TrendyolBoutiqueListPage.BOUTIQUE_LIST_PAGE_URL);
    }

}
