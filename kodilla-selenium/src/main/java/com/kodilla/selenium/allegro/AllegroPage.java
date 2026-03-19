package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllegroPage {
    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    private static final By COOKIE_ACCEPT_BUTTON = By.cssSelector("button[data-role='accept-consent']");
    private static final By CATEGORY_DROPDOWN = By.cssSelector("select[data-role='search-scope-select']");
    private static final By SEARCH_INPUT = By.cssSelector("input[data-role='search-input']");
    private static final By SEARCH_BUTTON = By.cssSelector("button[type='submit'] span");
    private static final By PRODUCT_ARTICLE = By.cssSelector("section > div > article");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public AllegroPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void open() {
        driver.get("https://allegro.pl/");
        driver.manage().window().maximize();
    }

    public void acceptCookies() {
        try {
            WebElement acceptButton = wait.until(
                    ExpectedConditions.elementToBeClickable(COOKIE_ACCEPT_BUTTON)
            );
            acceptButton.click();
        } catch (org.openqa.selenium.TimeoutException ignored) {
            // Cookie popup may not be present — this is expected
        }
    }

    public void selectCategory(String categoryName) {
        WebElement dropdown = wait.until(
                ExpectedConditions.presenceOfElementLocated(CATEGORY_DROPDOWN)
        );
        new Select(dropdown).selectByVisibleText(categoryName);
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

    public List<WebElement> getProducts() {
        wait.until(ExpectedConditions.presenceOfElementLocated(PRODUCT_ARTICLE));
        return driver.findElements(PRODUCT_ARTICLE);
    }
}
