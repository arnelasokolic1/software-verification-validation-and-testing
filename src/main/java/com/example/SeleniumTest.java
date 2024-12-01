package com.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumTest {

    private WebDriver webDriver;
    private String baseUrl;

    @BeforeAll
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);


        baseUrl = "https://www.dm-drogeriemarkt.ba/";
    }

    @Test
    public void testWebsiteTitle() {

        webDriver.get(baseUrl);

        // Fetching the page title
        String title = webDriver.getTitle();

        // Printing the title to the console for debugging
        System.out.println("Page Title: " + title);


        assertEquals("Dobrodošli u dm online shop | dm Bosna i Hercegovina", title, "The page title did not match the expected value.");
    }




    @AfterAll
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
