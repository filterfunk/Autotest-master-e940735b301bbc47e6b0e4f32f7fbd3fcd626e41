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
        if (System.getenv("TARGET_BROWSER").equals("FireFox")) {

            System.setProperty("webdriver.gecko.driver",
                    System.getenv("FIREFOX_PATH"));

            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);

        } else if (System.getenv("TARGET_BROWSER").equals("Chrome")) {

            System.setProperty("webdriver.chrome.driver",
                    System.getenv("CHROME_PATH"));

            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);

        } else {
            throw new RuntimeException("Не удалось инициализировать WebDriver.\n" +
                    "Неверное значение у TARGET_BROWSER! Ожидалось FireFox или Chrome, но оказалось "
                    + System.getenv("TARGET_BROWSER"));
        }

        driver.manage().window().maximize();
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

    public static void refreshPage() {
        driver.navigate().refresh();
    }

}
