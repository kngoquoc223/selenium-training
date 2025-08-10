package com.example.tests;

import com.example.config.DriverFactory;
import com.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.example.config.ConfigReader;
import com.example.pages.LoginPage;
import org.testng.Assert;


public class SampleTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        String baseUrl = ConfigReader.get("base.url");
        driver.get(baseUrl);
    }

    @Test
    public void testSearch() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginPageLoaded();
        boolean visible = loginPage.areLoginElementsVisible();
        Assert.assertTrue(visible, "Login elements are not all visible");
        String name = "Admin";
        String password = "admin123";
        loginPage.login(name, password);
    }

    // @AfterClass
    // public void tearDown() {
    //     DriverFactory.quitDriver();
    // }
}