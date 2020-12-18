package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TrendyolProductPage extends TrendyolBasePage{

    public TrendyolProductPage(WebDriver driver) {
        super(driver);
    }

    //ELEMENTS
    private WebElement addToCartBtn(){
        return driver.findElement(By.xpath("//button[@class='pr-in-btn add-to-bs']"));
    }

    //BEHAVIOURS
    public void addToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn()));
        addToCartBtn().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
