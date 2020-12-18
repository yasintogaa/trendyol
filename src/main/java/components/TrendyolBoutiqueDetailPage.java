package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TrendyolBoutiqueDetailPage extends TrendyolBasePage {

    final static String BOUTIQUE_DETAIL_PAGE_URL_PART = "/butikdetay/";

    public TrendyolBoutiqueDetailPage(WebDriver driver) {
        super(driver);
    }

    //ELEMENTS
    private List<WebElement> getProductsImages(){
        List<WebElement> listOfProducts;
        listOfProducts = driver.findElements(By.xpath("//div[@class='products']//img[@class='p-card-img ']"));
        return listOfProducts;
    }

    //BEHAVIOURS
    public boolean checkEachProductsImage() {

        boolean isAllImagesLoad = true;
        List<WebElement> productsImages = getProductsImages();
        URL url=null;
        int httpStatusCode=0;
        HttpURLConnection connection;

        for(WebElement element: productsImages){
            try {
                url = new URL(element.getAttribute("src"));
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                httpStatusCode = connection.getResponseCode();
            }
            catch (IOException e){
                e.printStackTrace();
            }

            // TODO: 18.12.2020 LOGGER Class kullan
            System.out.println(url + " STATUS: " + httpStatusCode);

            if(200 != httpStatusCode){
                isAllImagesLoad = false;
            }
        }
        return isAllImagesLoad;
    }

    @Override
    public void scrollDown() {
        super.scrollDown();
    }
}
