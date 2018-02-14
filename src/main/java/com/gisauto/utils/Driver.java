package com.gisauto.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
//
//        ChromeOptions options = new ChromeOptions();
//        driver = new ChromeDriver(options);

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

    /**
     * Делает скриншот и прикрепляет к отчёту Yandex.allure
     *
     * @return массив байт с изображением
     */
    @Attachment
    public static byte[] screenShot() {
        byte[] out = null;

        try {
            BufferedImage screenShot = new Robot().createScreenCapture(
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ImageIO.write(screenShot, "png", bo);
            out = bo.toByteArray();
            bo.close();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    public static void refreshPage(){
        driver.navigate().refresh();
    }

}
