package com.kodilla.selenium.pom;

import com.kodilla.selenium.config.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("integration")
@DisplayName("Kodilla Store Page Tests")
class KodillaStorePageTestSuite {

    private WebDriver driver;
    private KodillaStorePage storePage;

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.createChromeDriver();
        storePage = new KodillaStorePage(driver);
        storePage.open();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("should display all products when no search query")
    void shouldDisplayAllProducts() {
        int count = storePage.getProductCount();
        assertEquals(6, count, "Store should display 6 products by default");
    }

    @Test
    @DisplayName("should find products matching 'NoteBook'")
    void shouldFindNoteBookProducts() {
        storePage.searchFor("NoteBook");
        int count = storePage.getProductCount();
        assertTrue(count > 0, "Expected at least one product for 'NoteBook'");
    }

    @Test
    @DisplayName("should find products matching 'School'")
    void shouldFindSchoolProducts() {
        storePage.searchFor("School");
        int count = storePage.getProductCount();
        assertTrue(count > 0, "Expected at least one product for 'School'");
    }

    @Test
    @DisplayName("should find products matching 'Brand'")
    void shouldFindBrandProducts() {
        storePage.searchFor("Brand");
        int count = storePage.getProductCount();
        assertTrue(count > 0, "Expected at least one product for 'Brand'");
    }

    @Test
    @DisplayName("should find products matching 'Business'")
    void shouldFindBusinessProducts() {
        storePage.searchFor("Business");
        int count = storePage.getProductCount();
        assertTrue(count > 0, "Expected at least one product for 'Business'");
    }

    @Test
    @DisplayName("should find products matching 'Gaming'")
    void shouldFindGamingProducts() {
        storePage.searchFor("Gaming");
        int count = storePage.getProductCount();
        assertTrue(count > 0, "Expected at least one product for 'Gaming'");
    }

    @Test
    @DisplayName("should find products matching 'Powerful'")
    void shouldFindPowerfulProducts() {
        storePage.searchFor("Powerful");
        int count = storePage.getProductCount();
        assertTrue(count > 0, "Expected at least one product for 'Powerful'");
    }

    @Test
    @DisplayName("should return same results regardless of letter case")
    void shouldIgnoreCaseInSearch() {
        storePage.searchFor("notebook");
        int lowerCaseCount = storePage.getProductCount();

        storePage.open();
        storePage.searchFor("NOTEBOOK");
        int upperCaseCount = storePage.getProductCount();

        storePage.open();
        storePage.searchFor("NoteBook");
        int mixedCaseCount = storePage.getProductCount();

        assertEquals(lowerCaseCount, upperCaseCount,
                "Search should be case-insensitive (lowercase vs uppercase)");
        assertEquals(lowerCaseCount, mixedCaseCount,
                "Search should be case-insensitive (lowercase vs mixed)");
    }

    @Test
    @DisplayName("should return product titles as non-blank strings")
    void shouldReturnProductTitles() {
        List<String> titles = storePage.getProductTitles();
        assertFalse(titles.isEmpty(), "Expected at least one product title");
        titles.forEach(title ->
                assertFalse(title.isBlank(), "Product title should not be blank"));
    }

    @Test
    @DisplayName("should return no results for nonexistent product")
    void shouldReturnNoResultsForNonexistentProduct() {
        storePage.searchFor("xyznonexistent");
        int count = storePage.getProductCount();
        assertEquals(0, count, "Expected no products for nonexistent search term");
    }
}
