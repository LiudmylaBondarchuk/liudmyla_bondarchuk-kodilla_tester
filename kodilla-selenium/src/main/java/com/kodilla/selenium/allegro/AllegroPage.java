package com.kodilla.selenium.allegro;

import com.kodilla.selenium.pom.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AllegroPage extends AbstractPage {

    private static final String PAGE_URL = "https://allegro.pl/";

    private static final By COOKIE_ACCEPT_BUTTON = By.cssSelector("button[data-role='accept-consent']");
    private static final By CATEGORY_DROPDOWN = By.cssSelector("select[data-role='search-scope-select']");
    private static final By SEARCH_INPUT = By.cssSelector("input[data-role='search-input']");
    private static final By SEARCH_BUTTON = By.cssSelector("button[type='submit'] span");
    private static final By PRODUCT_ARTICLE = By.cssSelector("section > div > article");

    public AllegroPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

    public void acceptCookies() {
        try {
            click(COOKIE_ACCEPT_BUTTON);
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
        typeInto(SEARCH_INPUT, query);
        click(SEARCH_BUTTON);
    }

    public List<WebElement> getProducts() {
        return waitForPresenceOfAll(PRODUCT_ARTICLE);
    }
}
