package com.gisauto.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Driver {

    private static WebDriver driver = null;

    private static WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver",
                System.getenv("CHROME_PATH"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);


        driver.manage().window().maximize();
        waitForLoad(driver);
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            return initDriver();
        }
        return driver;
    }

    public static void kill() {
        driver.quit();
        driver = null;
        System.gc();
    }

    private static void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

}
