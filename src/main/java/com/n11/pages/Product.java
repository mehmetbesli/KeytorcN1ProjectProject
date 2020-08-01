package com.n11.pages;

import com.n11.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Product extends AbstractPage {
    private final By searchProductBy = By.id("searchData");
    private final By searchBtnBy = By.className("searchBtn");
    private final By itemListBy = By.id("view");
    private final By secondPageBy = By.xpath("//div[@class='pagination']//a[2]");
    private final By addFavoritesOfThirdProductBy = By.xpath("//div[@id='view']//li[3]//span[@title='Favorilere ekle']");
    private final By accountBy = By.xpath("//a[text()='Hesabım']");
    private final By favoritesBy = By.cssSelector("a[href='//www.n11.com/hesabim/istek-listelerim']");
    private final By thirdProductNameBy = By.xpath("//div[@id='view']//li[3]//h3[@class='productName ']");
    private final By thirdProductNameBoldBy = By.xpath("//div[@id='view']//li[3]//h3[@class='productName bold']");
    private final By okButtonBy = By.cssSelector("span[class='btn btnBlack confirm']");

    private final String urunAdi = "samsung";
    private String productName;

    public Product(WebDriver driver) {
        this.driver = driver;
    }

    public void gotoFavorites() {
        moveToElement(accountBy);
        log.info("Moved to Hesabım");
        click(favoritesBy);
        log.info("Clicked Favorites");
    }

    public void getThirdProductName() {
        if (isElementExist((thirdProductNameBy), 2)) {
            productName = findElement(thirdProductNameBy).getText().trim();
        }
        if (isElementExist((thirdProductNameBoldBy), 2)) {
            productName = findElement(thirdProductNameBoldBy).getText().trim();
        }
        log.info("Selected 3. Product name: " + productName);
    }

    public void addThirdProductFavourites(){
        moveToElement(addFavoritesOfThirdProductBy);
        log.info("Moved to Third Product field");
        click(addFavoritesOfThirdProductBy);
        log.info("Clicked Add Favorites field");
        if(isElementExist((okButtonBy),1)) {
            click(okButtonBy);//Daha öncede eklendi ise oky butonuna basıp devam edecek
        }
    }

    public void gotoSecondPageAndControl() {
        moveToElement(secondPageBy);
        click(secondPageBy);
        log.info(" Clicked to go to the second page");
        String secondPage=driver.getCurrentUrl();
        control(secondPage.contains("pg=2"),"You are in second page","You are not in second page");
    }

    public void controlSearchedList() {
        control(isElementExist(itemListBy), " Products list appeared", " Products List is not appeared");
    }

    public void searchProduct() {
        sendKeys(searchProductBy,urunAdi);
        log.info(urunAdi+" typed in search field");
        click(searchBtnBy);
        log.info("Clicked Ara button");
    }

    public String getProductName() {
        return productName;
    }

}