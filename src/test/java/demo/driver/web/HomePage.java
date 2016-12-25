package demo.driver.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by afaren on 12/17/16.
 */
public class HomePage extends Page {
    @CacheLookup
    @FindBy(linkText = "登录")
    private WebElement login;

    @CacheLookup
    @FindBy(linkText = "注册")
    private WebElement register;


    public HomePage(Browser browser, String url) {
        super(browser);
        browser.requestPageOf(url);
    }

    public LoginPage clickLoginBtn() {
        login.click();
        return new LoginPage(browser);
    }

    @Override
    protected void waitUntilPageLoad() {
    }

    public RegisterPage clickRegisterBtn() {
        register.click();
        return new RegisterPage(browser);
    }
}
