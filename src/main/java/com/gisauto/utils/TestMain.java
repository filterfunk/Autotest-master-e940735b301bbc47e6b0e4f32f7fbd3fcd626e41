package com.gisauto.utils;

import com.gisauto.utils.annotations.TargetBrowser;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Пригоден только для unit-тестов
 * Для использования унаследоваться от этого класса и реализовать метод test()
 */
@Deprecated
public abstract class TestMain {

    public static WebDriver driver = null;
    public static final String TEST_EMAIL = "test.gisauto@yandex.ru", TEST_EMAIL_PASSWORD = "testgisauto";

    protected TestMain() {
        init();
    }

    private void init() {
        TargetBrowser targetBrowser = this.getClass().getAnnotation(TargetBrowser.class);
        switch (targetBrowser.browser().charAt(0)) {
            case 'F':
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("os.name")
                                .equals("Linux")
                                ? "/usr/bin/geckodriver"
                                : "C:/WD/geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setLogLevel(FirefoxDriverLogLevel.ERROR);
                driver = new FirefoxDriver(options);
                break;
            default:
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("os.name")
                                .equals("Linux")
                                ? "/home/artsiom/chromedriver"
                                : "C:/WD/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    @Test
    public abstract void test();

    @After
    public void validate() {
        driver.quit();
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

    /**
     * Метод ожидания. Используется после выполнения шага теста для
     * ожидания подгрузки страниц/элементов.
     *
     * @param waitTime время ожидания в миллисекундах
     */
    public static void await(long waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}