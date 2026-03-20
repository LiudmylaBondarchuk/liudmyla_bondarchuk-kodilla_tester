package com.kodilla.selenium.allegro;

import com.kodilla.selenium.config.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("integration")
@DisplayName("Allegro Search Tests")
class AllegroSearchTestSuite {

    private WebDriver driver;
    private AllegroPage allegroPage;

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.createChromeDriver();
        allegroPage = new AllegroPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("should find products after search")
    void shouldFindProductsAfterSearch() {
        allegroPage.open();
        allegroPage.acceptCookies();
        allegroPage.selectCategory("Elektronika");
        allegroPage.searchFor("Mavic mini");

        List<WebElement> products = allegroPage.getProducts();
        assertFalse(products.isEmpty(), "Expected at least one product in search results");

        for (WebElement product : products) {
            assertNotNull(product.getText(), "Product text should not be null");
            assertFalse(product.getText().isEmpty(), "Product text should not be empty");
        }
    }
}
