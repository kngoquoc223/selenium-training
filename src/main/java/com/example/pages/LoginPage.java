package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.utils.LocatorLoader; 

public class LoginPage extends BasePage {
    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginBtn;
    private final Map<String, String> locators;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.locators = LocatorLoader.getLocators("LoginPage");
    }

    public void waitForLoginPageLoaded() {
        waitForUrlContains("login");
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public boolean areLoginElementsVisible() {
        usernameInput = waitForElement(By.xpath(locators.get("usernameInput")));
        passwordInput = waitForElement(By.xpath(locators.get("passwordInput")));
        loginBtn = waitForElement(By.xpath(locators.get("loginBtn")));

        return usernameInput.isDisplayed()
                && passwordInput.isDisplayed()
                && loginBtn.isDisplayed();
    }
}
