package com.n11.pages;

import com.n11.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Favorites extends AbstractPage {

    private final By clickFavoritesInFavoritesMenuBy = By.cssSelector("li[class='wishGroupListItem favorites'] h4[class='listItemTitle']");
    private final By thirdProductNameInFavoritesMenuBy = By.xpath("//div[@id='view']//li[1]//h3[@class='productName ']");
    private final By thirdProductNameInFavoritesMenuBoldBy = By.xpath("//div[@id='view']//li[1]//h3[@class='productName bold']");
    private final By removeProductBy = By.cssSelector("span[class='deleteProFromFavorites']");
    private final By removedProductMessageBy = By.cssSelector("div[class='content'] span[class='message']");
    private final By okyBtnBy = By.cssSelector("span[class='btn btnBlack confirm']");

    private final String productDeleted = "Ürününüz listeden silindi.";


    public Favorites(WebDriver driver) {
        this.driver = driver;
    }

    public void controlMessagePopup() {
        String removedProductText = getTextOfElement(removedProductMessageBy);
        log.info("Popup mesage should appear: "+productDeleted);
        log.info("Popup mesage from screen: "+removedProductText);
        Assert.assertEquals(productDeleted.trim(),removedProductText.trim());
        log.info("Product deleted appeared");

        click(okyBtnBy);
        log.info("Clicked oky button");
    }

    public void clickRemoveProductFromFavorites() {
        click(removeProductBy);
        log.info("Clicked remove Product");
    }

    public void thirdProductNameControl(String productName) {
        String productNameInFavoritesMenu = "";
        if(isElementExist(thirdProductNameInFavoritesMenuBy,1 )) {
            productNameInFavoritesMenu = findElement(thirdProductNameInFavoritesMenuBy).getText().trim();
        }
        if(isElementExist(thirdProductNameInFavoritesMenuBoldBy,1 )) {
            productNameInFavoritesMenu = findElement(thirdProductNameInFavoritesMenuBoldBy).getText().trim();
        }
        log.info("Product name in favorites: " + productNameInFavoritesMenu);
        Assert.assertEquals(productName,productNameInFavoritesMenu,"Products are not same ");
        log.info("Products are same. Control successful");
    }

    public void clickFavorites() {
        click(clickFavoritesInFavoritesMenuBy);
        log.info("Clicked Favorites in favorite Menu");
    }
}