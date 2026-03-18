package com.kodilla.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class KodillaStorePage extends AbstractPage {

    private static final String PAGE_URL = "https://kodilla.com/pl/test/store";

    private static final By SEARCH_INPUT = By.cssSelector("#searchField");
    private static final By PRODUCT_ITEMS = By.cssSelector(".element");
    private static final By PRODUCT_TITLE = By.cssSelector(".header h3:first-child");
    private static final By NO_RESULTS_MESSAGE = By.cssSelector("h3.missing");

    public KodillaStorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

    public void searchFor(String query) {
        typeInto(SEARCH_INPUT, query);
    }

    public List<WebElement> getProducts() {
        return driver.findElements(PRODUCT_ITEMS);
    }

    public int getProductCount() {
        return getProducts().size();
    }

    public List<String> getProductTitles() {
        return getProducts().stream()
                .map(product -> product.findElement(PRODUCT_TITLE).getText())
                .collect(Collectors.toList());
    }

    public boolean isNoResultsMessageDisplayed() {
        List<WebElement> messages = driver.findElements(NO_RESULTS_MESSAGE);
        return !messages.isEmpty() && messages.get(0).isDisplayed();
    }
}
