import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import pom.*;

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
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignup();

        assertTrue(loginPage.verifySignupHeader());

        String name = "Nur Aziz";
        loginPage.enterName(name);
        loginPage.enterEmail("nuraziz"+ System.currentTimeMillis() + "@example.com");

        SignupPage signupPage = loginPage.clickSubmit();
        assertTrue(signupPage.verifyEnterAccountHeader());

        signupPage.selectTitle();
        signupPage.enterPassword("password123");
        signupPage.selectDateOfBirth(1, 1, 2000);
        signupPage.checkNewsletter();
        signupPage.checkSpecialOffers();
        signupPage.enterFirstName("Aziz");
        signupPage.enterLastName("Nur");
        signupPage.enterCompany("Company");
        signupPage.enterAddress1("123 Main St");
        signupPage.enterAddress2("Apt 4B");
        signupPage.selectCountry("United States");
        signupPage.enterState("California");
        signupPage.enterCity("Los Angeles");
        signupPage.enterZipcode("90001");
        signupPage.enterMobileNumber("1234567890");

        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccount();
        assertTrue(accountCreatedPage.verifyAccountCreated());

        HomePage homePageAfterSignup = accountCreatedPage.clickContinue();
        assertTrue(homePageAfterSignup.isLoggedIn(name));

        AccountDeletedPage accountDeletedPage = homePageAfterSignup.clickDeleteAccount();
        assertTrue(accountDeletedPage.isAccountDeleted());

        driver.close();
    }
}