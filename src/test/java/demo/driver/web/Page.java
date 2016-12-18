package demo.driver.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by afaren on 12/18/16.
 */
public class Page {
    protected Browser browser;
    protected WebDriver driver;

    public Page(Browser browser) {
        this.driver = browser.getDriver();
        this.browser = browser;
    }

    public String getPageTitle() {
        return browser.getCurrentPageTitle();
    }

    protected void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
