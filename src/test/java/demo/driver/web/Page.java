package demo.driver.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by afaren on 12/18/16.
 */
public class Page {
    protected Browser browser;

    public Page(Browser browser) {
        this.browser = browser;
        PageFactory.initElements(browser.getDriver(), this);
    }

    public String getPageTitle() {
        return browser.getCurrentPageTitle();
    }

    protected void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
