package com.n11;

import com.n11.pages.Favorites;
import com.n11.pages.Home;
import com.n11.pages.Login;
import com.n11.pages.Product;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Automation extends  AbstractPage{

    private Home home;
    private Login login;
    private Product product;
    private Favorites favorites;


    public void n11WebSiteTestCase() {
        try {
            openChromeBrowser();
//            openFirefoxBrowser();

            home=new Home(driver);
            login =new Login(driver);
            product=new Product(driver);
            favorites=new Favorites(driver);

            navigateToUrl();
            kvkkPopupClose();
            gotoLoginPage();
            controlLoginPagePopup();
            typeUsernameAndPassword();
            clickLoginBtn();
            searchProduct();
            controlSearchedList();
            gotoSecondPageAndControl();
            addThirdProductFavourites();
            getThirdProductName();
            gotoFavorites();
            clickFavorites();
            thirdProductNameControl(product.getProductName());
            clickRemoveProductFromFavorites();
            controlMessagePopup();
        }catch (Exception e){
            log.error("An error occurred ",e);
        }finally {
            if (driver != null) {
                driver.quit();
            }
        }

    }



    public void controlMessagePopup() {
        favorites.controlMessagePopup();
    }

    public void clickRemoveProductFromFavorites() {
        favorites.clickRemoveProductFromFavorites();
    }

    public void thirdProductNameControl(String productName) {
        favorites.thirdProductNameControl(productName);
    }

    public void clickFavorites() {
        favorites.clickFavorites();
    }

    public void gotoFavorites() {
        product.gotoFavorites();
    }

    public void getThirdProductName() {
        product.getThirdProductName();
    }

    public void addThirdProductFavourites(){
        product.addThirdProductFavourites();
    }

    public void gotoSecondPageAndControl() {
        product.gotoSecondPageAndControl();
    }

    public void controlSearchedList() {
        product.controlSearchedList();
    }

    public void searchProduct() {
        product.searchProduct();
    }

    public void clickLoginBtn() {
        login.clickLoginBtn();
    }

    public void typeUsernameAndPassword() {
        login.typeUsernameAndPassword();
    }

    public void controlLoginPagePopup() {
        login.controlLoginPage();
    }

    public void gotoLoginPage() {
        login.gotoLoginPage();
    }

    public void kvkkPopupClose() {
        home.kvkkPopupClose();
    }

    public void openChromeBrowser() {
        String path = System.getProperty("user.dir");
        System.out.println("Proje path : " + path);
        System.setProperty("webdriver.chrome.driver", path + "\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void openFirefoxBrowser() {
        String path = System.getProperty("user.dir");
        System.out.println("Proje path : " + path);
        System.setProperty("webdriver.gecko.driver", path + "\\lib\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void navigateToUrl() {
        home.navigateToUrl();
    }

}