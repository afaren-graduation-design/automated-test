package demo.twa.rs;

import org.concordion.api.extension.Extension;
import org.concordion.ext.ScreenshotExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.concordion.selenium.Browser;
import org.concordion.selenium.SeleniumScreenshotTaker;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ConcordionRunner.class)
public class RecruitingSystem {

    private String HOME_PAGE_URL = "http://localhost";

    @Extension
    private ScreenshotExtension extension = new ScreenshotExtension();
    private SeleniumScreenshotTaker screenshotTaker;


    public String openHomePage() {

        Browser browser = new Browser();
        screenshotTaker = new SeleniumScreenshotTaker(browser);
        extension
                .setScreenshotTaker(screenshotTaker)
                .setScreenshotOnAssertionFailure(true)
                .setScreenshotOnAssertionSuccess(true)
                .setMaxWidth(600);

        WebDriver driver = browser.getDriver();

        WebDriver.Navigation navigate = driver.navigate();
        navigate.to(HOME_PAGE_URL);
        return driver.getTitle();
    }


}
