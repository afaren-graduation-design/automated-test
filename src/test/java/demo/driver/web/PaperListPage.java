package demo.driver.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by afaren on 12/20/16.
 */
public class PaperListPage extends Page {

    @CacheLookup
    @FindBy(linkText = "简单的试卷")   // TODO: 12/20/16 使用 xpath 语法获取第一个 a 链接
    private WebElement anchor;


    public PaperListPage(Browser browser) {
        super(browser);
        waitFor(By.linkText("简单的试卷"));
    }

    public ConsolePage clickEasyPaper() {
        anchor.click();
        return new ConsolePage(browser);
    }
}
