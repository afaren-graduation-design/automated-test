package demo.twa.rs;

import demo.driver.web.HomePage;
import demo.driver.web.LoginPage;
import org.concordion.api.AfterExample;
import org.concordion.api.extension.Extension;
import org.concordion.ext.ScreenshotExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.concordion.selenium.Browser;
import org.concordion.selenium.SeleniumScreenshotTaker;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class RecruitingSystem {

    private String HOME_PAGE_URL = "http://localhost";

    private Browser browser;
    private HomePage homePage;
    private SeleniumScreenshotTaker screenshotTaker;

    @Extension
    private ScreenshotExtension extension = new ScreenshotExtension();

    private void open() {
        browser = new Browser();
        screenshotTaker = new SeleniumScreenshotTaker(browser);
        extension.setScreenshotTaker(screenshotTaker)
                .setScreenshotOnAssertionFailure(true)
                .setScreenshotOnAssertionSuccess(true)
                .setMaxWidth(600);
    }

    public String openHomePage() {
        if (browser == null) {
            open();
        }

        homePage = new HomePage(browser, HOME_PAGE_URL);
        return homePage.getPageTitle();
    }



    @AfterExample
    public void close(){
        if (browser != null) {
            browser.close();
            browser = null;
        }

    }

    public LoginPage login() {
        return homePage.login();
    }
}
