package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.utils.LocatorLoader; 

public class LoginPage extends BasePage {
    private final Map<String, String> locators;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.locators = LocatorLoader.getLocators("LoginPage");
    }
        private By getLocator(String key) {
        return By.xpath(locators.get(key));
    }

    public void login(String username, String password) {
        waitForElement(getLocator("usernameInput")).sendKeys(username);
        waitForElement(getLocator("passwordInput")).sendKeys(password);
        waitForElement(getLocator("loginBtn")).click();
    }

    public void waitForLoginPageLoaded() {
        waitForUrlContains("login");
    }

    public boolean areLoginElementsVisible() {
        return waitForElement(getLocator("usernameInput")).isDisplayed()
            && waitForElement(getLocator("passwordInput")).isDisplayed()
            && waitForElement(getLocator("loginBtn")).isDisplayed();
    }
}
