package demo.driver.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by afaren on 12/17/16.
 */
public class LoginPage {


    private final WebDriver driver;

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
}


