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

    private String HOME_PAGE_URL = "http://afaren.graduation.design:8888"; 

    private Browser browser;


    private HomePage homePage;
    private PaperListPage paperListPage;
    private ConsolePage consolePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private LogicPuzzlePage logicPuzzlePage;
    private HomeworkQuizPage homeworkQuizPage;
    private UserCenterPage userCenterPage;

    private SeleniumScreenshotTaker screenshotTaker;

    @Extension
    private ScreenshotExtension extension = new ScreenshotExtension();

    @BeforeSpecification
    private void setup() {
        browser = new Browser(new ChromeDriver());

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


    public LogicPuzzlePage clickStartBtn() {
        logicPuzzlePage = consolePage.clickLogicPuzzle();;
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

    public String answerFirstHomeworkQuiz() {
        return homeworkQuizPage.answerFirstQuiz();
    }
}
