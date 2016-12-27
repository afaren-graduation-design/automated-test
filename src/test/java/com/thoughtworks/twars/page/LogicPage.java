package com.thoughtworks.twars.page;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;

/**
 * Created by afaren on 12/27/16.
 */
public class LogicPage extends Page{
    public LogicPage(Browser browser) {
        super(browser);
    }

    @Override
    protected void waitUntilPageLoad() {
        waitFor(By.className("description"));
    }
}
