package com.gisauto.utils;

import com.gisauto.pageObjects.BasePage;
import com.gisauto.pageObjects.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class TestMain {

    public static WebDriver driver = null;

    protected TestMain(){
        main(null);
    }

    public void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        init();
    }

    private void init(){
        TargetBrowser targetBrowser = this.getClass().getAnnotation(TargetBrowser.class);
        switch (targetBrowser.browser().charAt(0)){
            case 'F': driver = new FirefoxDriver(); break;
            default: driver = new ChromeDriver(); break;
        }
        PF.getPage(BasePage.class);
        driver.manage().window().maximize();
    }

    protected void openPage(String url){
        driver.get(url);
    }

    protected WebElement get(By a){
        return driver.findElement(a);
    }

    public void inputText(WebElement textField, String string) {
        for (int i = 0; i < string.length(); i++) {
            textField.sendKeys(string.charAt(i) + "");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void await(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @AfterAll
    private static void quit(){
        driver.quit();
    }

    @Before
    public abstract void prepare();

    @Test
    public abstract void test();

    @After
    public abstract void validate();

}