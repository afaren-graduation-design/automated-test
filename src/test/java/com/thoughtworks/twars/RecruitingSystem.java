package com.thoughtworks.twars;

import com.thoughtworks.twars.page.*;
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

    private String HOME_PAGE_URL = "http://localhost"; // local, not in docker container

    private Browser browser;
    private HomePage homePage;
    private PaperListPage paperListPage;
    private ConsolePage consolePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    private SeleniumScreenshotTaker screenshotTaker;

    @Extension
    private ScreenshotExtension extension = new ScreenshotExtension();
    private UserCenterPage userCenterPage;
    private NeedKnowPage needKnowPage;
    private LogicPuzzlePage logicPuzzlePage;
    private HomeworkQuizPage homeworkQuizPage;

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
    private void close() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }

    public String openHomePage() {
        homePage = new HomePage(browser, HOME_PAGE_URL);
        return homePage.getPageTitle();
    }


    public LoginPage toLogin() {
        loginPage = homePage.clickLoginBtn();
        return loginPage;
    }

    public PaperListPage fillLoginForm() {
        paperListPage = loginPage.fillForm();
        return paperListPage;
    }


    public ConsolePage clickEasyPaper() {
        consolePage = paperListPage.clickEasyPaper();
        return consolePage;
    }

    public RegisterPage toRegister() {
        registerPage = homePage.clickRegisterBtn();
        return registerPage;
    }

    public UserCenterPage fillRegisterForm() {
        userCenterPage = registerPage.fillForm();
        return userCenterPage;
    }

    public PaperListPage fillUpInfo() {
        paperListPage = userCenterPage.fillUpUserInfo();
        return paperListPage;
    }

    public String reOpenHomePage() {
        return openHomePage();
    }

    public NeedKnowPage clickLogicPuzzles() {
        needKnowPage = consolePage.clickLogicPuzzle();
        return needKnowPage;
    }


    public LogicPuzzlePage clickStartBtn() {
        logicPuzzlePage = needKnowPage.clickStartBtn();
        return logicPuzzlePage;
    }

    public ConsolePage answerLogicQuizzes() {
        int numberOfPuzzles = 12;
        for (int i = 0; i < numberOfPuzzles; i++) {
            logicPuzzlePage.clickNextQuiz();
        }

        logicPuzzlePage.clickSubmit();
        consolePage = logicPuzzlePage.clickModalOkBtn();
        return consolePage;
    }

    public HomeworkQuizPage clickHomeworkQuizzes() {
        homeworkQuizPage  = consolePage.clickHomeworkQuiz();
        return homeworkQuizPage;
    }
}
