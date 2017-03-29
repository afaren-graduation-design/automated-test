package com.thoughtworks.twars.page;

import com.thoughtworks.twars.data.MockUser;
import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by afaren on 12/27/16.
 */
public class HomeworkQuizPage extends Page {

    @CacheLookup
    @FindBy(xpath = "//input[1]")
    WebElement gitRepo;

    @CacheLookup
    @FindBy(linkText = "提交作业")
    WebElement submitHomeworkTab;

    @CacheLookup
    @FindBy(linkText = "运行结果")
    WebElement executeResultTab;

    @CacheLookup
    @FindBy(xpath = "descendant::button[text()='提交代码地址']")
    WebElement submitBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@class='runningResult tab']//div[@class='result']/div[@class='content']")
    WebElement result;

    private final String FIRST_QUIZ_EXECUTION_RESULT = "readme.md 找到.";

    public HomeworkQuizPage(Browser browser) {
        super(browser);
    }

    @Override
    protected By condition() {
        return By.linkText("题目说明");
    }


    public String answerFirstQuiz() {
        submitHomeworkTab.click();
        gitRepo.sendKeys(MockUser.GIT_REPO);
        submitBtn.click();

        executeResultTab.click();

        waitUntilResultCame();

        return FIRST_QUIZ_EXECUTION_RESULT;
    }



    private void waitUntilResultCame() {
        while (!isResultCame()) {
            sleep();
        }
    }

    private boolean isResultCame() {
        return result.getText().equals(FIRST_QUIZ_EXECUTION_RESULT);
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
