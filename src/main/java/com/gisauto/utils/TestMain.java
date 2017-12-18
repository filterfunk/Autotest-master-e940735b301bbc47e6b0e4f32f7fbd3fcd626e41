package com.gisauto.utils;

import com.gisauto.pageObjects.BasePage;
import com.gisauto.utils.annotations.TargetBrowser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.gisauto.pageObjects.Page.screenShot;


public abstract class TestMain {

    public static WebDriver driver = null;
    public static final String TEST_EMAIL = "test.gisauto@yandex.ru", TEST_EMAIL_PASSWORD = "testgisauto";

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

    public static void await(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод <code>prepare()</code> вызывается перед запуском теста.
     * <p>
     * Рекомендуется использовать для подготовки тестовых данных,
     * открытия нужных страниц и т.д.
     */
    @Before
    public abstract void prepare();

    public abstract void process();

    @After
    public void validate() {
        screenShot();
        driver.quit();
    }

}