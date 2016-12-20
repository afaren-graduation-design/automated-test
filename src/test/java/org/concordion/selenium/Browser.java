package org.concordion.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Manages the browser session.
 */
public class Browser {
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
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
