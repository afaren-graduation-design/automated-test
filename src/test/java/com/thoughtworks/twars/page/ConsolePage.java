package com.thoughtworks.twars.page;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by afaren on 12/20/16.
 */
public class ConsolePage extends Page {

    @CacheLookup
    @FindBy(linkText = "逻辑题")
    private WebElement logicPuzzle;

    @CacheLookup
    @FindBy(linkText = "编程题")
    private WebElement homeworkQuiz;


    public ConsolePage(Browser browser) {
        super(browser);
    }

    @Override
    protected By condition() {
        return By.className("dashboard-icon");
    }

    public LogicPuzzlePage clickLogicPuzzle() {
        logicPuzzle.click();
        return new LogicPuzzlePage(browser);
    }

    public HomeworkQuizPage clickHomeworkQuiz() {
        homeworkQuiz.click();
        return new HomeworkQuizPage(browser);

    }
}
