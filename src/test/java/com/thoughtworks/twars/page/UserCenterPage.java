package com.thoughtworks.twars.page;

import com.thoughtworks.twars.data.TestUser;
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

        inputSchool.sendKeys(TestUser.SCHOOL);

        selectOption(schoolProvince,TestUser.SCHOOL_PROVINCE);

        selectOption(schoolCity,TestUser.SCHOOL_CITY );

        inputName.sendKeys(TestUser.NAME);

        gender.click();

        inputMajor.sendKeys(TestUser.MAJOR);

        selectOption(degree,TestUser.DEGREE );

        selectOption(entranceYear,TestUser.ENTRANCE_YEAR);

        submitBtn.click();

        return new PaperListPage(browser);
    }

    private void selectOption(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByValue(option);
    }
}
