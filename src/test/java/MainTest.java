import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    WebDriver driver = new EdgeDriver();

    @Test
    void testBing() {
        driver.get("https://bing.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        WebElement searchForm = driver.findElement(By.id("sb_form"));
        searchForm.submit();
    }

    @Test
    void testLogin() {
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Test
    void testLoginLocked() {
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("locked_out_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
        assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMessage.getText());
    }


    @Test
    void testHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> figures = driver.findElements(By.cssSelector(".figure"));

        Actions actions = new Actions(driver);
        actions.moveToElement(figures.get(0)).perform();

        WebElement userName = figures.get(0).findElement(By.cssSelector("h5"));
        assertEquals("name: user1", userName.getText());
    }

    @Test
    void testDrag() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

        assertEquals("B", source.getText());
        assertEquals("A", target.getText());
    }

    @Test
    void testKeyPress() {
        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement input = driver.findElement(By.id("target"));
        input.click();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).perform();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals("You entered: SHIFT", result.getText());
    }

    @Test
    void testRegister() {
        driver.get("https://automationexercise.com/");

        WebElement signupButton = driver.findElement(By.partialLinkText("Signup"));
        signupButton.click();

        WebElement signUpHeader = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]"));
        assertEquals("New User Signup!", signUpHeader.getText());

        WebElement signupForm = driver.findElement(By.cssSelector(".signup-form > form"));
        WebElement nameField = signupForm.findElement(By.name("name"));
        nameField.sendKeys("Aziz");

        WebElement emailField = signupForm.findElement(By.name("email"));
        String randomEmail = "aziz" + System.currentTimeMillis() + "@example.com";
        emailField.sendKeys(randomEmail);

        WebElement submitButton = signupForm.findElement(By.xpath("//button[contains(text(),'Signup')]"));
        submitButton.click();

        try {
            Thread.sleep(2000); // Wait for the next page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement enterAccountHeader = driver.findElement(By.cssSelector(".login-form > h2.title > b"));
        assertEquals("ENTER ACCOUNT INFORMATION", enterAccountHeader.getText());

        WebElement titleRadioButton = driver.findElement(By.id("id_gender1"));
        titleRadioButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        WebElement dayOfBirthField = driver.findElement(By.id("days"));
        dayOfBirthField.click();
        dayOfBirthField.findElement(By.xpath("//option[@value='1']")).click();

        WebElement monthOfBirthField = driver.findElement(By.id("months"));
        monthOfBirthField.click();
        monthOfBirthField.findElement(By.xpath("//option[@value='1']")).click();

        WebElement yearOfBirthField = driver.findElement(By.id("years"));
        yearOfBirthField.click();
        yearOfBirthField.findElement(By.xpath("//option[@value='2000']")).click();

        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }

        WebElement specialOffersCheckbox = driver.findElement(By.id("optin"));
        if (!specialOffersCheckbox.isSelected()) {
            specialOffersCheckbox.click();
        }

        WebElement firstNameField = driver.findElement(By.id("first_name"));
        firstNameField.sendKeys("Aziz");

        WebElement lastNameField = driver.findElement(By.id("last_name"));
        lastNameField.sendKeys("Nur");

        WebElement companyNameField = driver.findElement(By.id("company"));
        companyNameField.sendKeys("Company");

        WebElement address1Field = driver.findElement(By.id("address1"));
        address1Field.sendKeys("123 Main St");

        WebElement address2Field = driver.findElement(By.id("address2"));
        address2Field.sendKeys("Apt 4B");

        WebElement countryDropdown = driver.findElement(By.id("country"));
        countryDropdown.click();
        countryDropdown.findElement(By.xpath("//option[@value='United States']")).click();

        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("California");

        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("Los Angeles");

        WebElement zipcodeField = driver.findElement(By.id("zipcode"));
        zipcodeField.sendKeys("90001");

        WebElement mobileNumberField = driver.findElement(By.id("mobile_number"));
        mobileNumberField.sendKeys("1234567890");

        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
        createAccountButton.click();

        try {
            Thread.sleep(2000); // Wait for the next page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement accountCreatedHeader = driver.findElement(By.cssSelector("h2[data-qa='account-created']"));
        assertEquals("ACCOUNT CREATED!", accountCreatedHeader.getText());
    }
}