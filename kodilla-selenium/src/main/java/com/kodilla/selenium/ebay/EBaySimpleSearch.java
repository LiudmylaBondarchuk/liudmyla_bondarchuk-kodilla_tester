package com.kodilla.selenium.ebay;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EBaySimpleSearch {

    public static void main(String[] args) {
        // Konfiguracja sterownika Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium-drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Otwórz stronę eBay
            driver.get("https://www.ebay.com/");
            driver.manage().window().maximize();

            // Znajdź pole wyszukiwania i wpisz hasło "Laptop"
            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));
            WebElement searchBox = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("gh-ac"))
            );
            searchBox.clear();
            searchBox.sendKeys("Laptop");

            // Znajdź przycisk wyszukiwania i kliknij
            WebElement searchButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("gh-search-btn"))
            );
            searchButton.click();


        } finally {
            // Zamknij przeglądarkę
            driver.quit();
        }
    }

    private static long ofSeconds(int i) {
                return 0;
    }
}