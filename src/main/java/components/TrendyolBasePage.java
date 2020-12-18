package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URL;

abstract class TrendyolBasePage {
    WebDriver driver;
    WebDriverWait wait;

    TrendyolBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    //BASE BEHAVIOURS
    void isLoaded(String containsURL) throws Error {
        try {
            Thread.sleep(3000);
            Assert.assertTrue(driver.getCurrentUrl().contains(containsURL));
        }
        catch (AssertionError e){
            Assert.fail(containsURL + " page was not loaded. " + e.getMessage());
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    void isLoaded() throws Error {
        try {
            Thread.sleep(3000);
            Assert.assertEquals(driver.getCurrentUrl(),TrendyolMainPage.MAIN_PAGE_URL);
        }
        catch (AssertionError e){
            Assert.fail(TrendyolMainPage.MAIN_PAGE_URL + " page was not loaded. " + e.getMessage());
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    void isLoadedElement(String locatorID) throws Error{
        try {
            Assert.assertTrue(driver.findElement(By.id(locatorID)).isDisplayed());
        }
        catch (AssertionError e){
            Assert.fail("Element is not displayed.");
        }

    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void navigationOnMainMenu(String submenuHref){
        driver.findElement(By.xpath("//div[@id='navigation']//a[contains(@href,'" + submenuHref + "')]")).click();
    }

}
