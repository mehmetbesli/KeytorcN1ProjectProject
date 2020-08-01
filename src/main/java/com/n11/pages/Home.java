package com.n11.pages;

import com.n11.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Home extends AbstractPage {

    private final String urlN11= "https://www.n11.com/";
    private final By tamamBtn = By.cssSelector("span[class='btn btnBlack']");

    public Home(WebDriver driver){
        this.driver=driver;
    }

    public void navigateToUrl() {
        log.info(" Navigate To Website");
        driver.get(urlN11);
        control(driver.getCurrentUrl().contains(urlN11), "N11 page opened", "N11 did not open");
    }

    public void kvkkPopupClose() {
        if (isElementExist(tamamBtn, 3)) {
            click(tamamBtn);
            log.info("Clicked Kvkk Popup");
        }
    }

}