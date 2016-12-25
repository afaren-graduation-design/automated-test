package com.thoughtworks.twars.page;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;

/**
 * Created by afaren on 12/20/16.
 */
public class ConsolePage extends Page {
    public ConsolePage(Browser browser) {
        super(browser);
    }

    @Override
    protected void waitUntilPageLoad() {
        waitFor(By.className("tip"));
    }
}
