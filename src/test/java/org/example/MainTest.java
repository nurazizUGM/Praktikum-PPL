package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void driverTest() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://google.com/");
        String title = driver.getTitle();
        System.out.println(title);
//        driver.quit();
    }
}