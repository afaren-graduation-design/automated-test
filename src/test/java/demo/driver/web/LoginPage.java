package demo.driver.web;

import demo.data.TestUser;
import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by afaren on 12/17/16.
 */
public class LoginPage extends Page {

    @CacheLookup
    @FindBy(name = "email")
    private WebElement email;

    @CacheLookup
    @FindBy(name = "loginPassword")
    private WebElement loginPassword;

    @CacheLookup
    @FindBy(name = "captcha")
    private WebElement captcha;


    @CacheLookup
    @FindBy(id = "login-btn")
    private WebElement submitButton;



    public LoginPage(Browser browser) {
        super(browser);
    }

    @Override
    protected void waitUntilPageLoad() {
        waitForCaptcha();
    }


    private void waitForCaptcha() {
        waitFor(By.tagName("img"));
    }


    public PaperListPage fillForm() {

        /*
         FIXME: 12/17/16
         problem:
            fill clickLoginBtn form in normal order, clickLoginBtn-info-component would print error msg
            NORMAL ORDER:  name -> password -> captcha
         solution:
            in chrome & phantom, adjust filling order of clickLoginBtn form to work around
            however, firefox still cannot work around
            WORK AROUND: captcha -> name -> password
        */

        captcha.clear();
        captcha.sendKeys(TestUser.CAPTCHA);
        captcha.sendKeys(Keys.ESCAPE);

        email.clear();
        email.sendKeys(TestUser.EMAIL);
        email.sendKeys(Keys.ESCAPE);

        loginPassword.clear();
        loginPassword.sendKeys(TestUser.PASSWORD);
        loginPassword.sendKeys(Keys.ESCAPE);

        submitButton.click();

        return new PaperListPage(browser);
    }
}


