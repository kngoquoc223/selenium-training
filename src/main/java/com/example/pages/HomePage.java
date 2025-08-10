package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String keyword) {
        searchBox.sendKeys(keyword);
        searchBox.submit();
    }
}
