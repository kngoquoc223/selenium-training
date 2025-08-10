package com.example.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Tạo ChromeOptions nếu muốn thêm tùy chọn
            ChromeOptions options = new ChromeOptions();
            // ví dụ chạy headless
            // options.addArguments("--headless");
            // options.addArguments("--disable-gpu");
            // options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    // Phương thức đóng driver khi test xong
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}