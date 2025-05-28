package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By signupButton = By.partialLinkText("Signup");
    private By loggedInNav = By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Logged in as')]");
    private By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
    private By accountDeletedHeader = By.cssSelector("h2[data-qa='account-deleted']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickSignup() {
        driver.findElement(signupButton).click();
        return new LoginPage(driver);
    }

    public boolean isLoggedIn(String as) {
        try {
            WebElement loggedInElement = driver.findElement(loggedInNav);
            return loggedInElement.isDisplayed() && loggedInElement.getText().contains(as);
        } catch (Exception e) {
            return false;
        }
    }

    public AccountDeletedPage clickDeleteAccount() {
        driver.findElement(deleteAccountButton).click();
        return new AccountDeletedPage(driver);
    }
}
