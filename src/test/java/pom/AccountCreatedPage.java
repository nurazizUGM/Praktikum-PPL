package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage {
    private WebDriver driver;
    private By accountCreatedHeader = By.cssSelector("h2[data-qa='account-created']");
    private By continueButton = By.xpath("//a[contains(text(),'Continue')]");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyAccountCreated() {
        WebElement header = driver.findElement(accountCreatedHeader);
        return header.isDisplayed() && header.getText().equals("ACCOUNT CREATED!");
    }

    public HomePage clickContinue() {
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
}