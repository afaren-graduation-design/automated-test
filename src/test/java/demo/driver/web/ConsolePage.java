package demo.driver.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;

/**
 * Created by afaren on 12/20/16.
 */
public class ConsolePage extends Page {
    public ConsolePage(Browser browser) {
        super(browser);
        waitFor(By.className("tip"));
    }
}
