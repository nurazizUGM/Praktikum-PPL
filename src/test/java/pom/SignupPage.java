package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    private WebDriver driver;
    private By enterAccountHeader = By.cssSelector(".login-form > h2.title > b");
    private By titleRadioButton = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By dayOfBirthField = By.id("days");
    private By monthOfBirthField = By.id("months");
    private By yearOfBirthField = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By specialOffersCheckbox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyEnterAccountHeader() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(enterAccountHeader));
            WebElement header = driver.findElement(enterAccountHeader);
            return header.getText().equals("ENTER ACCOUNT INFORMATION");
        } catch (Exception e) {
            return false;
        }
    }

    public void selectTitle() {
        driver.findElement(titleRadioButton).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectDateOfBirth(int day, int month, int year) {
        Select daySelect = new Select(driver.findElement(dayOfBirthField));
        daySelect.selectByValue(String.valueOf(day));
        Select monthSelect = new Select(driver.findElement(monthOfBirthField));
        monthSelect.selectByValue(String.valueOf(month));
        Select yearSelect = new Select(driver.findElement(yearOfBirthField));
        yearSelect.selectByValue(String.valueOf(year));
    }

    public void checkNewsletter() {
        WebElement checkbox = driver.findElement(newsletterCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void checkSpecialOffers() {
        WebElement checkbox = driver.findElement(specialOffersCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
    }

    public void enterAddress1(String address1) {
        driver.findElement(address1Field).sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        driver.findElement(address2Field).sendKeys(address2);
    }

    public void selectCountry(String country) {
        Select countrySelect = new Select(driver.findElement(countryDropdown));
        countrySelect.selectByVisibleText(country);
    }

    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        driver.findElement(zipcodeField).sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public AccountCreatedPage clickCreateAccount() {
        driver.findElement(createAccountButton).click();
        return new AccountCreatedPage(driver);
    }
}