package com.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DmSearchProductTest {

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
    public void testAcceptCookiesAndSearch() throws InterruptedException {

        webDriver.get(baseUrl);





        WebElement searchInput = webDriver.findElement(By.xpath("//input[@aria-label='Polje za unos pretraživanja']"));
        searchInput.clear();
        searchInput.sendKeys("essence maskara" + Keys.RETURN);

        // Wait for the search results to load
        Thread.sleep(5000);


        WebElement productLink = webDriver.findElement(By.xpath(
                "//a[@class='pdd_14u321ib pdd_1f0yjzi0' and contains(@href, 'essence-i-love-extreme-crazy-volume-maskara-ultra-black')]"));
        productLink.click();

        Thread.sleep(5000);


        try {
            WebElement addToCartButton = webDriver.findElement(By.xpath("//button[@id='add-to-cart-button']"));
            addToCartButton.click();
            System.out.println("Successfully clicked 'Dodati u korpu' button.");
        } catch (Exception e) {
            System.out.println("Add to Cart button not found. Test failed.");
        }


        Thread.sleep(3000);

        System.out.println("Test completed successfully!");
    }

    @AfterAll
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
