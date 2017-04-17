package org.concordion.selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Manages the browser session.
 */
public class Browser {
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
        if (driver.getClass().getName() == "org.openqa.selenium.chrome.ChromeDriver") {
            this.driver.manage().window().maximize();
        } else {
            this.driver.manage().window().setSize(new Dimension(1024, 768));
        }
        setEventLogger();
    }

    private void setEventLogger() {
        EventFiringWebDriver efwd = new EventFiringWebDriver(driver);
        efwd.register(new SeleniumEventLogger());
        driver = efwd;
    }

    public void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }


    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void requestPageOf(String url) {
        driver.get(url);
    }
}
