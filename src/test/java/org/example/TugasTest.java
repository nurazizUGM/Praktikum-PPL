package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TugasTest {
    static WebDriver chrome = new ChromeDriver();
    static WebDriver edge = new EdgeDriver();

    @Test
    public void testChrome() {
        chrome.get("https://tedi.sv.ugm.ac.id");

        String title = chrome.getTitle();
        assertEquals(title, "Website Departemen Teknik Elektro dan Informatika (TEDI), Sekolah Vokasi, UGM – TEDI SV UGM");

        String currentUrl = chrome.getCurrentUrl();
        assertEquals(currentUrl, "https://tedi.sv.ugm.ac.id/id/muka/");
    }

    @Test
    public void testEdge() {
        edge.get("https://tedi.sv.ugm.ac.id");

        String title = edge.getTitle();
        assertEquals(title, "Website Departemen Teknik Elektro dan Informatika (TEDI), Sekolah Vokasi, UGM – TEDI SV UGM");

        String currentUrl = edge.getCurrentUrl();
        assertEquals(currentUrl, "https://tedi.sv.ugm.ac.id/id/muka/");
    }

    @AfterAll
    public static void clear() {
        chrome.quit();
        edge.quit();
    }
}
