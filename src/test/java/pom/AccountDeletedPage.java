package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountDeletedPage {
    private WebDriver driver;

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountDeleted() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[data-qa='account-deleted']")));
            WebElement header = driver.findElement(By.cssSelector("h2[data-qa='account-deleted']"));
            return header.getText().equals("ACCOUNT DELETED!");
        } catch (Exception e) {
            return false;
        }
    }
}
