package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllegroTestingApp {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium-drivers\\Chrome\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, 20);

            driver.get("https://allegro.pl/");

            try {
                WebElement acceptCookies = wait.until(
                        ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-role='accept-consent']"))
                );
                acceptCookies.click();
                System.out.println("Accepted cookies.");
            } catch (Exception e) {
                System.out.println("No cookies popup found.");
            }

            WebElement categoryDropdown = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[data-role='search-scope-select']"))
            );
            Select selectCategory = new Select(categoryDropdown);
            selectCategory.selectByVisibleText("Elektronika");
            System.out.println("Selected category 'Electronics'.");

            WebElement searchBox = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-role='search-input']"))
            );
            searchBox.clear();
            searchBox.sendKeys("Mavic mini");
            System.out.println("Entered 'Mavic mini'.");

            WebElement searchButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'] span"))
            );
            searchButton.click();
            System.out.println("Clicked 'Search'.");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section > div > article")));

            List<WebElement> products = driver.findElements(By.cssSelector("section > div > article"));

            System.out.println("Found " + products.size() + " products:");
            for (WebElement product : products) {
                System.out.println(product.getText());
                System.out.println("--------------------");
            }

        } finally {
            driver.quit();
        }
    }
}