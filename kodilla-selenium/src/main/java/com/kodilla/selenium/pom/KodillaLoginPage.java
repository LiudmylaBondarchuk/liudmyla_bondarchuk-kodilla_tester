package com.kodilla.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KodillaLoginPage extends AbstractPage {

    private static final String PAGE_URL =
            "https://kodilla.com/pl/test/login";

    private static final By EMAIL_INPUT = By.cssSelector("#email");
    private static final By PASSWORD_INPUT = By.cssSelector("#password");
    private static final By LOGIN_BUTTON =
            By.cssSelector("button[type='submit']");
    private static final String LOGIN_SUCCESS_TEXT = "zalogowany";

    public KodillaLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }

    public boolean login(String email, String password) {
        typeInto(EMAIL_INPUT, email);
        typeInto(PASSWORD_INPUT, password);
        click(LOGIN_BUTTON);

        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        return alertText.contains(LOGIN_SUCCESS_TEXT);
    }
}
