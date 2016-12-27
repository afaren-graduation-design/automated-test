package com.thoughtworks.twars.page;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by afaren on 12/27/16.
 */
public class LogicPage extends Page {

    @CacheLookup
    @FindBy(xpath = "descendant::button/span[text()='下一题']")
    WebElement next;

    @CacheLookup
    @FindBy(linkText = "交卷")
    WebElement submit;

    @CacheLookup
    @FindBy(xpath = "descendant::button/span[text()='确认提交']")
    WebElement modalConfirm;

    public LogicPage(Browser browser) {
        super(browser);
    }

    @Override
    protected void waitUntilPageLoad() {
        waitFor(By.className("description"));
    }

    public void clickNextQuiz() {
        sleep();
        next.click();
    }

    public void clickSubmit() {
        sleep();
        submit.click();
    }


    public ConsolePage clickModalOkBtn() {
        sleep();
        modalConfirm.click();
        return new ConsolePage(browser);
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

