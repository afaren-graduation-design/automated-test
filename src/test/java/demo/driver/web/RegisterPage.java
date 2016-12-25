package demo.driver.web;

import demo.data.TestUser;
import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by afaren on 12/21/16.
 */
public class RegisterPage extends Page {


    @CacheLookup
    @FindBy(name = "mobilePhone")
    private WebElement mobilePhone;

    @CacheLookup
    @FindBy(name = "email")
    private WebElement email;


    @CacheLookup
    @FindBy(name = "password")
    private WebElement pwssword;


    @CacheLookup
    @FindBy(name = "captcha")
    private WebElement captcha;


    @CacheLookup
    @FindBy(className = "agree-check")
    private WebElement agreeCheck;


    @CacheLookup
    @FindBy(id = "register-btn")
    private WebElement registerBtn;


    public RegisterPage(Browser browser) {
        super(browser);
    }

    @Override
    protected void waitUntilPageLoad() {
        waitForCaptcha();
    }

    private void waitForCaptcha() {
        waitFor(By.tagName("img"));
    }

    public UserCenterPage fillForm() {

        mobilePhone.clear();
        mobilePhone.sendKeys(TestUser.PHONE);
        mobilePhone.sendKeys(Keys.ESCAPE);

        email.clear();
        email.sendKeys(TestUser.EMAIL);
        email.sendKeys(Keys.ESCAPE);

        pwssword.clear();
        pwssword.sendKeys(TestUser.PASSWORD);
        pwssword.sendKeys(Keys.ESCAPE);

        captcha.clear();
        captcha.sendKeys(TestUser.CAPTCHA);
        captcha.sendKeys(Keys.ESCAPE);

        agreeCheck.click();

        registerBtn.click();

        waitTillUserCenterPageLoad();
        return new UserCenterPage(browser);
    }

    private void waitTillUserCenterPageLoad() {
        waitFor(By.id("inputSchool"));
    }
}
