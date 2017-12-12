package com.gisauto.utils;

import com.gisauto.pageObjects.BasePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TestMain {

    public static WebDriver driver = null;
    public static final String TEST_EMAIL = "test.gisauto@yandex.ru", TEST_EMAIL_PASSWORD = "testgisauto",
                                TEST_UR_EMAIL = "testur.gisauto@yandex.ru";

    protected TestMain() {
        main(null);
    }

    public void main(String[] args) {
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
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("os.name")
                                .equals("Linux")
                                ? "/home/artsiom/ChromeDriver"
                                : "C:/WD/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        PF.getPage(BasePage.class);
        driver.manage().window().maximize();
    }

    protected void openPage(String url) {
        driver.get(url);
    }

    protected WebElement get(By a) {
        return driver.findElement(a);
    }

    public void await(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    @AfterAll
    private static void quit() {
        driver.quit();
    }

    /**
     * Метод <code>prepare()</code> вызывается перед запуском теста.
     *<p>
     * Рекомендуется использовать для подготовки тестовых данных,
     * открытия нужных страниц и т.д.
     */
    @Before
    public abstract void prepare();

    @Test
    public abstract void process();

    @After
    public void validate() {
        ConditionChecker.assertAll();
    }

}