package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllegroTestingApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        try {
            driver.get("https://allegro.pl/");

            try {
                WebElement acceptCookies = wait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-role='accept-consent']"))
                );
                acceptCookies.click();
                System.out.println("Accepted cookies.");
            } catch (Exception e) {
                System.out.println("No cookies popup found.");
            }

            WebElement categoryDropdown = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@data-role='search-scope-select']"))
            );
            Select selectCategory = new Select(categoryDropdown);
            selectCategory.selectByVisibleText("Elektronika");
            System.out.println("Selected category 'Electronics'.");

            WebElement searchBox = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-role='search-input']"))
            );
            searchBox.clear();
            searchBox.sendKeys("Mavic mini");
            System.out.println("Entered 'Mavic mini'.");

            WebElement searchButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']//span[text()='szukaj']"))
            );
            searchButton.click();
            System.out.println("Clicked 'Search'.");

        } finally {
        }
    }
}