package com.kodilla.selenium.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EBayPage {
    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    private static final By SEARCH_INPUT = By.id("gh-ac");
    private static final By SEARCH_BUTTON = By.id("gh-search-btn");
    private static final By SEARCH_RESULTS = By.cssSelector(".s-item");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public EBayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void open() {
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
    }

    public void searchFor(String query) {
        WebElement searchBox = wait.until(
                ExpectedConditions.presenceOfElementLocated(SEARCH_INPUT)
        );
        searchBox.clear();
        searchBox.sendKeys(query);

        WebElement searchButton = wait.until(
                ExpectedConditions.elementToBeClickable(SEARCH_BUTTON)
        );
        searchButton.click();
    }

    public List<WebElement> getSearchResults() {
        wait.until(ExpectedConditions.presenceOfElementLocated(SEARCH_RESULTS));
        return driver.findElements(SEARCH_RESULTS);
    }
}
