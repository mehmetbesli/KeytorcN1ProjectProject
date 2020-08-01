package com.n11;

import com.n11.pages.Home;
import com.n11.pages.Login;
import com.n11.pages.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestScenarios {

    private Automation automation;
    private Home home;
    private Login login;
    private Product product;


    @Before
    public void openBrowser() {
        automation = new Automation();
        automation.openChromeBrowser();
        home=new Home(automation.getDriver());
        login =new Login(automation.getDriver());
        product=new Product(automation.getDriver());
    }

    @Test
    public void gotoN11WebPageTest() {
        home.navigateToUrl();
    }

    @Test
    public void gotoLoginPage() {
        home.navigateToUrl();
        home.kvkkPopupClose();
        login.gotoLoginPage();
        login.controlLoginPage();
    }

    @Test
    public void searchProduct() {
        home.navigateToUrl();
        home.kvkkPopupClose();
        login.gotoLoginPage();
        login.typeUsernameAndPassword();
        login.clickLoginBtn();
        product.searchProduct();
        product.controlSearchedList();
    }

    @Test
    public void gotoSecondPageAndControl() {
        home.navigateToUrl();
        home.kvkkPopupClose();
        login.gotoLoginPage();
        login.typeUsernameAndPassword();
        login.clickLoginBtn();
        product.searchProduct();
        product.controlSearchedList();
        product.gotoSecondPageAndControl();
    }

    @After
    public void closeBrowser() {
        automation.getDriver().quit();
    }
}