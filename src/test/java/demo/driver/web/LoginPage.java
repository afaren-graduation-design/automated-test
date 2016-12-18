package demo.driver.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by afaren on 12/17/16.
 */
public class LoginPage {

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


    private final WebDriver driver;

    private class TestLoginUser {
        String email;
        String loginPassword;
        String captcha;

        public TestLoginUser(String email, String loginPassword, String captcha) {
            this.email = email;
            this.loginPassword = loginPassword;
            this.captcha = captcha;
        }
    }

    public LoginPage(Browser browser) {
        this.driver = browser.getDriver();
        PageFactory.initElements(this.driver, this);
        waitForCaptcha();
    }


    private void waitForCaptcha() {
        WebDriverWait wait = new  WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img"))); // TODO: 12/17/16  这里应该等待加载验证码图片，但是要用到 xPath
    }



    public  String getPageTitle(){
        return driver.getTitle();

    }

    public String fillForm() {
        TestLoginUser user = new TestLoginUser("test@163.com", "12345678", "1234");

        email.clear();
        email.sendKeys(user.email);
        email.sendKeys(Keys.ESCAPE);

        loginPassword.clear();
        loginPassword.sendKeys(user.loginPassword);
        loginPassword.sendKeys(Keys.ESCAPE);

        // FIXME: 12/17/16 why captcha tip was throw???
        captcha.clear();
        captcha.sendKeys(user.captcha);
        captcha.sendKeys(Keys.ESCAPE);


        submitButton.click();
        return "TODO";
    }
}


