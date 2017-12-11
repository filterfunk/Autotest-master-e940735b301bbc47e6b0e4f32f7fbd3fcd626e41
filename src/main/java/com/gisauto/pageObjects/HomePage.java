package com.gisauto.pageObjects;

import com.gisauto.utils.TestMain;
import com.gisauto.webElements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver = TestMain.driver;

    public HomePage(){
        openPage("http://gisauto.ru/");
        if (!"Поиск автозапчастей по всей России".equals(driver.getTitle())){
            throw new IllegalStateException("This page isn't homepage.");
        }
    }

    public HomePage loginAs(String username, String password) {
        return (HomePage) typeUsername(username)
                .typePassword(password)
                .submitLogin();
    }

}
