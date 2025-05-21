import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class WaitTestNew {
    WebDriver driver = new EdgeDriver();

    @BeforeEach
    public void setup() {
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    @AfterEach
    public void clear() {
        driver.quit();
    }

    @Test
    public void testNoSuchElement() {
        WebElement addBtn = driver.findElement(By.id("add_btn"));
        addBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("row2")));

        WebElement row2 = driver.findElement(By.id("row2"));
        assertTrue(row2.isDisplayed(), "Row 2 should be displayed after clicking the add button");
    }

    @Test
    public void testInvalidElementState() {
        WebElement editBtn = driver.findElement(By.id("edit_btn"));
        editBtn.click();

        WebElement input = driver.findElement(By.cssSelector("#row1 input"));
        input.clear();
        input.sendKeys("Test");

        assertEquals("Test", input.getAttribute("value"), "Input value should be 'Test' after sending keys");
    }

    @Test
    public void testStaleElement() {
        WebElement instructions = driver.findElement(By.id("instructions"));
        WebElement addBtn = driver.findElement(By.id("add_btn"));
        addBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(instructions));
        try {
            instructions.isDisplayed();
            fail("Instructions should not be displayed after clicking the add button");
        } catch (StaleElementReferenceException e) {
            // Expected exception
        }
    }

    @Test
    public void testTimeout() {
        WebElement addBtn = driver.findElement(By.id("add_btn"));
        addBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("row2")));

        WebElement row2 = driver.findElement(By.id("row2"));
        assertTrue(row2.isDisplayed(), "Row 2 should be displayed after clicking the add button");
    }
}
