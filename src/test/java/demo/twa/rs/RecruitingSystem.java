package demo.twa.rs;

import demo.driver.web.HomePage;
import demo.driver.web.LoginPage;
import org.concordion.api.AfterSpecification;
import org.concordion.api.BeforeSpecification;
import org.concordion.api.extension.Extension;
import org.concordion.ext.ScreenshotExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.concordion.selenium.Browser;
import org.concordion.selenium.SeleniumScreenshotTaker;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(ConcordionRunner.class)
public class RecruitingSystem {

    private String HOME_PAGE_URL = "http://localhost";

    private Browser browser;
    private HomePage homePage;
    private LoginPage loginPage;
    private SeleniumScreenshotTaker screenshotTaker;

    @Extension
    private ScreenshotExtension extension = new ScreenshotExtension();

    @BeforeSpecification
    private void setup() {
        browser = new Browser(new ChromeDriver());
//        browser = new Browser(new FirefoxDriver());
//        browser = new Browser(new PhantomJSDriver());

        screenshotTaker = new SeleniumScreenshotTaker(browser);
        extension.setScreenshotTaker(screenshotTaker)
                .setScreenshotOnAssertionFailure(true)
                .setScreenshotOnAssertionSuccess(true)
                .setMaxWidth(600);
    }

    @AfterSpecification
    private void close(){
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }

    public String openHomePage() {
        homePage = new HomePage(browser, HOME_PAGE_URL);
        return homePage.getPageTitle();
    }


    public LoginPage login() {
        loginPage =  homePage.login();
        return loginPage;
    }

    public String fillForm() {
        return loginPage.fillForm();
    }



}
