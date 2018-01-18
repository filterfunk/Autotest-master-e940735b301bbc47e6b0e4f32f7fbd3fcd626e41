package com.gisauto.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class Driver {

    private static WebDriver driver = null;

    private static WebDriver initDriver() {

        System.setProperty("webdriver.gecko.driver",
                System.getProperty("os.name")
                        .equals("Linux")
                        ? "/usr/bin/geckodriver"
                        : "C:/WD/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);

//        System.setProperty("webdriver.chrome.driver",
//                System.getProperty("os.name")
//                        .equals("Linux")
//                        ? "/home/artsiom/chromedriver"
//                        : "C:/WD/chromedriver.exe");
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null){
            return initDriver();
        }
        return driver;
    }

    public static void kill(){
        driver.quit();
        driver = null;
        System.gc();
    }
}
