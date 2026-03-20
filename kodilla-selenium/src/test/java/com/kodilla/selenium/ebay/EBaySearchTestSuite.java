package com.kodilla.selenium.ebay;

import com.kodilla.selenium.config.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("integration")
@DisplayName("eBay Search Tests")
class EBaySearchTestSuite {

    private WebDriver driver;
    private EBayPage ebayPage;

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.createChromeDriver();
        ebayPage = new EBayPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("should find search results for Laptop")
    void shouldFindSearchResults() {
        ebayPage.open();
        ebayPage.searchFor("Laptop");

        List<WebElement> results = ebayPage.getSearchResults();
        assertFalse(results.isEmpty(), "Expected at least one search result");
    }
}
