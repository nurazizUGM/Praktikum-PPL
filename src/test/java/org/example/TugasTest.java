package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TugasTest {
    @Test
    public void testFirefox() {
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://tedi.sv.ugm.ac.id");

        String title = firefox.getTitle();
        assertEquals(title, "Website Departemen Teknik Elektro dan Informatika (TEDI), Sekolah Vokasi, UGM – TEDI SV UGM");

        String currentUrl = firefox.getCurrentUrl();
        assertEquals(currentUrl, "https://tedi.sv.ugm.ac.id/id/muka/");
        firefox.quit();
    }

    @Test
    public void testEdge() {
        WebDriver edge = new EdgeDriver();
        edge.get("https://tedi.sv.ugm.ac.id");

        String title = edge.getTitle();
        assertEquals(title, "Website Departemen Teknik Elektro dan Informatika (TEDI), Sekolah Vokasi, UGM – TEDI SV UGM");

        String currentUrl = edge.getCurrentUrl();
        assertEquals(currentUrl, "https://tedi.sv.ugm.ac.id/id/muka/");
        edge.quit();
    }
}
