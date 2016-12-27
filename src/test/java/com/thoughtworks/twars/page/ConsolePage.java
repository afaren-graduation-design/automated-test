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
    private WebElement logic;


    public ConsolePage(Browser browser) {
        super(browser);
    }

    @Override
    protected void waitUntilPageLoad() {
        waitFor(By.className("dashboard-icon"));
    }

    public NeedKnowPage clickLogicQuizzes() {
        logic.click();
        return new NeedKnowPage(browser);
    }
}
