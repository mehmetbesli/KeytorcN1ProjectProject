package com.n11.pages;

import com.n11.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login extends AbstractPage {
    private final By loginBy = By.className("btnSignIn");
    private final By emailBy = By.id("email");
    private final By passwordBy = By.id("password");
    private final By loginButtonBy = By.id("loginButton");

    private final String n11LoginPageUrl = "giris-yap";
    private final String username= "mehmetkarakay63@gmail.com";
    private final String password= "12345mb63..";

    public Login(WebDriver driver){
        this.driver=driver;
    }

    public void gotoLoginPage() {
        control(isElementExist(loginBy), " Login Button appear", " Login Button is not appeared");
        click(loginBy);
        log.info(" Clicked Giris Yap");
    }

    public void controlLoginPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains(n11LoginPageUrl), "N11 login page did not open");
        log.info("N11 login page opened");
    }

    public void typeUsernameAndPassword() {
        sendKeys(emailBy,username);
        log.info("Email: '"+ emailBy +"' typed");
        sendKeys(passwordBy,password);
        log.info("Password: '"+password+"' typed");
    }

    public void clickLoginBtn() {
        click(loginButtonBy);
        log.info("Clicked Giris Yap button");
    }

}