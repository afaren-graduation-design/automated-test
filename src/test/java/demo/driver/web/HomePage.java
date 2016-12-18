package demo.driver.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by afaren on 12/17/16.
 */
public class HomePage extends Page{
    @CacheLookup
    @FindBy(linkText = "登录")
    private WebElement login;

    @CacheLookup
    @FindBy(linkText = "注册")
    private WebElement register;


    public HomePage(Browser browser, String homePageUrl) {
        super(browser);
        PageFactory.initElements(driver, this);
        driver.get(homePageUrl);
    }

    public LoginPage login() {
        login.click();
        return new LoginPage(browser);
    }
}
