package com.gisauto.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public final class Driver {

    private static WebDriver driver = null;

    private static WebDriver initDriver(boolean isMobile) {
        driver = new ChromeDriver(getDriverOptions(isMobile));
        waitForLoad(driver);
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            return initDriver(false);
        }
        return driver;
    }

    public static WebDriver getMobileDriver(){
        if (driver == null) {
            return initDriver(true);
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

    private static ChromeOptions getDriverOptions(boolean isMobile){
        System.setProperty("webdriver.chrome.driver",
                System.getenv("CHROME_PATH"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        if (isMobile){
            Map<String, String> mobileEmulation = new HashMap<>();

            mobileEmulation.put("deviceName", "Nexus 5");

            options.setExperimentalOption("mobileEmulation", mobileEmulation);
        }

        return options;
    }

}
