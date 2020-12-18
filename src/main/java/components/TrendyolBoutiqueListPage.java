package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TrendyolBoutiqueListPage extends TrendyolBasePage{

    final static String BOUTIQUE_LIST_PAGE_URL = "https://www.trendyol.com/butik/liste";

    public TrendyolBoutiqueListPage(WebDriver driver) {
        super(driver);
    }

    //ELEMENTS
    /*
    private WebElement notificationModelCloseBtn(){
        return driver.findElement(By.xpath("//*[@id='modal-root']//*[contains(@title, 'Kapat')]"));
    }
    */

    private List<WebElement> getBigBoutiquesImages(){
        List<WebElement> imagesOfBigBoutiques;
        imagesOfBigBoutiques = driver.findElements(By.xpath("//div[@class='component-list component-big-list']/article[@class='component-item']//img"));
        return imagesOfBigBoutiques;
    }

    //BEHAVIOURS

    /*
    public void closeNotificationModal(){
        notificationModelCloseBtn().click();
    }
    */

    public boolean checkEachBigBoutiqueImage() {

        boolean isAllImagesLoad = true;
        List<WebElement> bigListofBoutiques = getBigBoutiquesImages();
        URL url=null;
        int httpStatusCode=0;
        HttpURLConnection connection;

        for(WebElement element: bigListofBoutiques){
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

    @Override
    public void navigationOnMainMenu(String submenuHref) {
        super.navigationOnMainMenu(submenuHref);
        isLoaded(TrendyolBoutiqueListPage.BOUTIQUE_LIST_PAGE_URL);
    }

    public void goToFirstBoutiqueDetail(){
        getBigBoutiquesImages().get(0).click();
        isLoaded(TrendyolBoutiqueDetailPage.BOUTIQUE_DETAIL_PAGE_URL_PART);
    }


}
