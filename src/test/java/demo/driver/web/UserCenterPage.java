package demo.driver.web;

import org.concordion.selenium.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by afaren on 12/21/16.
 */
public class UserCenterPage extends Page {

    @CacheLookup
    @FindBy(id = "inputSchool")
    private WebElement inputSchool;

    @CacheLookup
    @FindBy(name = "schoolProvince")
    private WebElement schoolProvince;

    @CacheLookup
    @FindBy(name = "schoolCity")
    private WebElement schoolCity;

    @CacheLookup
    @FindBy(id = "inputName")
    private WebElement inputName;

    @CacheLookup
    @FindBy(name = "inputMobilePhone")
    private WebElement inputMobilePhone;


    @CacheLookup
    @FindBy(id = "inputEmail")
    private WebElement inputEmail;


    @CacheLookup
    @FindBy(id = "male")
    private WebElement gender;


    @CacheLookup
    @FindBy(id = "inputMajor")
    private WebElement inputMajor;


    @CacheLookup
    @FindBy(name = "degree")
    private WebElement degree;

    @CacheLookup
    @FindBy(name = "entranceYear")
    private WebElement entranceYear;


    @CacheLookup
    @FindBy(tagName = "button")
    private WebElement submitBtn;

    public UserCenterPage(Browser browser) {
        super(browser);
    }

    @Override
    protected void waitUntilPageLoad() {
        waitFor(By.tagName("button"));
    }

    public PaperListPage fillUpUserInfo() {

        inputSchool.sendKeys("陕西邮电大学");

        selectOption(schoolProvince, "陕西省");

        selectOption(schoolCity, "西安市");

        inputName.sendKeys("Afaren");

        gender.click();

        inputMajor.sendKeys("计算机科学与技术");

        selectOption(degree, "本科");

        selectOption(entranceYear, "2013");

        submitBtn.click();

        return new PaperListPage(browser);
    }

    private void selectOption(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByValue(option);
    }
}
