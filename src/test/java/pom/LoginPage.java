package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By signupHeader = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private By nameField = By.cssSelector(".signup-form input[name='name']");
    private By emailField = By.cssSelector(".signup-form input[name='email']");
    private By submitButton = By.xpath("//button[contains(text(),'Signup')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifySignupHeader() {
        WebElement header = driver.findElement(signupHeader);
        return header.isDisplayed() && header.getText().equals("New User Signup!");
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public SignupPage clickSubmit() {
        driver.findElement(submitButton).click();
        return new SignupPage(driver);
    }
}