package com.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DmSearchTest {

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
    public void testSearchFunctionality() throws InterruptedException {

        webDriver.get(baseUrl);

        // search terms
        String[] searchTerms = {"šampon", "essence", "parfemi"};

        // Loop through each searching terms
        for (String term : searchTerms) {
            // Locate the search input field
            WebElement searchInput = webDriver.findElement(By.xpath("//input[@aria-label='Polje za unos pretraživanja']"));

            // Enter the search term and simulate pressing Enter
            searchInput.clear(); // Clear any existing text in the search box
            searchInput.sendKeys(term + Keys.RETURN);

            // Wait to observe the results for each search term
            Thread.sleep(5000); // Adjust as needed
        }


        System.out.println("Test finished successfully!");
    }

    @AfterAll
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
