import components.*;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ImageLoadTests extends BaseUITest {

    private CredentialEntity credentialEntity = new CredentialEntity();
    private String username = credentialEntity.getUsername();
    private String password = credentialEntity.getPassword();

    @Parameters("browsers")
    @BeforeMethod
    @Override
    public void beforeMethod(String browsers) {
        super.beforeMethod(browsers);

    }

    @Test(dataProvider = "submenu-data-provider", dataProviderClass = UIDataProvider.class, description = "Verify to all boutiques' images whether load.")
    void verifyBoutiquesImagesLoad(String data) {

        //PAGES INIT
        TrendyolMainPage trendyolMainPage = PageFactory.initElements(driver, TrendyolMainPage.class);
        TrendyolLoginPage trendyolLoginPage = PageFactory.initElements(driver,TrendyolLoginPage.class);
        TrendyolBoutiqueListPage trendyolBoutiqueListPage = PageFactory.initElements(driver,TrendyolBoutiqueListPage.class);

        //STEPS
        trendyolMainPage.goToTrendyolHome();
        trendyolMainPage.goToLoginPage();

        trendyolLoginPage.doLogin(username, password);

        //trendyolBoutiqueListPage.closeNotificationModal();
        trendyolBoutiqueListPage.navigationOnMainMenu(data);
        trendyolBoutiqueListPage.scrollDown();

        //ASSERTION
        System.out.println("Checking Big Boutique Images for: " + data);
        Assert.assertTrue(trendyolBoutiqueListPage.checkEachBigBoutiqueImage());

    }
    @Test(description = "Verify a random boutique's products' images load.")
    void verifyProductsImageLoaded(){

        //PAGES INIT
        TrendyolMainPage trendyolMainPage = PageFactory.initElements(driver, TrendyolMainPage.class);
        TrendyolLoginPage trendyolLoginPage = PageFactory.initElements(driver,TrendyolLoginPage.class);
        TrendyolBoutiqueListPage trendyolBoutiqueListPage = PageFactory.initElements(driver,TrendyolBoutiqueListPage.class);
        TrendyolBoutiqueDetailPage trendyolBoutiqueDetailPage = PageFactory.initElements(driver,TrendyolBoutiqueDetailPage.class);

        //STEPS
        trendyolMainPage.goToTrendyolHome();
        trendyolMainPage.goToLoginPage();

        trendyolLoginPage.doLogin(username, password);

        trendyolBoutiqueListPage.navigationOnMainMenu("/butik/liste/erkek");
        trendyolBoutiqueListPage.goToFirstBoutiqueDetail();

        trendyolBoutiqueDetailPage.scrollDown();

        //ASSERTION
        System.out.println("Checking products images...");
        Assert.assertTrue(trendyolBoutiqueDetailPage.checkEachProductsImage());

    }
    @Test(description = "Add to cart a product")
    void verifyAddProductToCart(){

        //PAGES INIT
        TrendyolMainPage trendyolMainPage = PageFactory.initElements(driver, TrendyolMainPage.class);
        TrendyolLoginPage trendyolLoginPage = PageFactory.initElements(driver,TrendyolLoginPage.class);
        TrendyolBoutiqueListPage trendyolBoutiqueListPage = PageFactory.initElements(driver,TrendyolBoutiqueListPage.class);
        TrendyolBoutiqueDetailPage trendyolBoutiqueDetailPage = PageFactory.initElements(driver,TrendyolBoutiqueDetailPage.class);
        TrendyolProductPage trendyolProductPage = PageFactory.initElements(driver,TrendyolProductPage.class);

        //STEPS
        trendyolMainPage.goToTrendyolHome();
        trendyolMainPage.goToLoginPage();

        trendyolLoginPage.doLogin(username, password);

        trendyolBoutiqueListPage.navigationOnMainMenu("/butik/liste/erkek");
        trendyolBoutiqueListPage.goToFirstBoutiqueDetail();

        trendyolBoutiqueDetailPage.goToFirstProduct();

        trendyolProductPage.addToCart();

        //There is no assertion in this task

    }
    @AfterMethod
    @Override
    public void afterMethod() {
        super.afterMethod();
    }
}
