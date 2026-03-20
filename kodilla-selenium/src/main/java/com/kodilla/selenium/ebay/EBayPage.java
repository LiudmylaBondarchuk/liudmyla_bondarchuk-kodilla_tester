package com.kodilla.selenium.ebay;

import com.kodilla.selenium.pom.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EBayPage extends AbstractPage {

    private static final String PAGE_URL = "https://www.ebay.com/";

    private static final By SEARCH_INPUT = By.id("gh-ac");
    private static final By SEARCH_BUTTON = By.id("gh-search-btn");
    private static final By SEARCH_RESULTS = By.cssSelector(".s-item");

    public EBayPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

    public void searchFor(String query) {
        typeInto(SEARCH_INPUT, query);
        click(SEARCH_BUTTON);
    }

    public List<WebElement> getSearchResults() {
        return waitForPresenceOfAll(SEARCH_RESULTS);
    }
}
