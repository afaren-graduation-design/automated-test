package homepage;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(ConcordionRunner.class)
public class LoginFixture {

    public Boolean login(String account, String password) {
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://192.168.99.100:8888/register.html#login");

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name
                        ("email")));

        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("loginPassword"));
        WebElement captcha = driver.findElement(By.name("captcha"));
        WebElement loginBtn = driver.findElement(By.id("login-btn"));

        emailInput.sendKeys(account);
        captcha.sendKeys("1234");
        passwordInput.sendKeys(password);

        loginBtn.click();

        WebElement dropdownMenu = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='dropdownMenu1']/span[1]")));

        return dropdownMenu.getText().equals(account);
    }
}