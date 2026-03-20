package com.kodilla.selenium.pom;

import com.kodilla.selenium.config.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

@Tag("integration")
@DisplayName("Kodilla Login Page Tests")
class KodillaLoginPageTestSuite {

    private static final String TEST_EMAIL = System.getenv().getOrDefault("KODILLA_TEST_EMAIL", "test@kodilla.com");
    private static final String TEST_PASSWORD = System.getenv().getOrDefault("KODILLA_TEST_PASSWORD", "kodilla123");

    private WebDriver driver;
    private KodillaLoginPage loginPage;

    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.createChromeDriver();
        loginPage = new KodillaLoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("should reject invalid credentials")
    void shouldRejectInvalidCredentials() {
        loginPage.open();
        boolean loggedIn = loginPage.login("invalid@test.com", "wrongpassword");
        assertFalse(loggedIn, "Login with invalid credentials should fail");
    }

    @Test
    @DisplayName("should accept valid credentials")
    void shouldAcceptValidCredentials() {
        loginPage.open();
        boolean loggedIn = loginPage.login(TEST_EMAIL, TEST_PASSWORD);
        assertTrue(loggedIn, "Login with valid credentials should succeed");
    }

    @Test
    @DisplayName("should reject valid email with wrong password")
    void shouldRejectValidEmailWithWrongPassword() {
        loginPage.open();
        boolean loggedIn = loginPage.login(TEST_EMAIL, "wrongpassword");
        assertFalse(loggedIn, "Login with wrong password should fail");
    }
}
