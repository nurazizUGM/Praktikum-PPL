import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class WaitTest {
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

        WebElement row2 = driver.findElement(By.id("row2"));
        assertTrue(row2.isDisplayed(), "Row 2 should be displayed after clicking the add button");
    }

    @Test
    public void testInvalidElementState() {
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

        assertFalse(instructions.isDisplayed(), "Instructions should not be displayed after clicking the add button");
    }

    @Test
    public void testTimeout() {
        WebElement addBtn = driver.findElement(By.id("add_btn"));
        addBtn.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement row2 = driver.findElement(By.id("row2"));
        assertTrue(row2.isDisplayed(), "Row 2 should be displayed after clicking the add button");
    }
}
