import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class UIDataProvider {

    @DataProvider(name="submenu-data-provider")
    public Object[][] getSubmenuLinks(){
        // TODO: 18.12.2020 Menuler httprequest ile parse ederek çekilebilir??

        //Generation Trendyol Category Data

        WebDriver driver = null;

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver_macos");
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com/butik/liste");
        List<WebElement> submenuItems;
        submenuItems = driver.findElements(By.xpath("//ul[@class='main-nav']//a[@class='category-header']"));


        List<String> submenuItemsLinks = new ArrayList<String>();
        for (WebElement element: submenuItems) {

            submenuItemsLinks.add(element.getAttribute("href").replace("https://www.trendyol.com",""));
        }

        Object[][] data = new Object[submenuItemsLinks.size()][1];
        for (int i = 0;i < submenuItemsLinks.size();i++)
        {
            data[i][0] = submenuItemsLinks.get(i);
        }
        driver.quit();
        return data;
    }

}
