package com.thoughtworks.twars.page;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by afaren on 12/26/16.
 */
public class NeedKnowPage extends Page {

    @CacheLookup
    @FindBy(tagName = "button")
    WebElement startBtn;

    public NeedKnowPage(Browser browser) {
        super(browser);
    }

    @Override
    protected void waitUntilPageLoad() {
        waitFor(By.className("start-button"));
    }

    public LogicPuzzlePage clickStartBtn() {
        startBtn.click();
        return new LogicPuzzlePage(browser);
    }
}
