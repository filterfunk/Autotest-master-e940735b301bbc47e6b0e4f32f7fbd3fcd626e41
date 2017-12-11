package com.gisauto.pageObjects;

import com.gisauto.utils.PF;
import com.gisauto.utils.TestMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //TODO: 11.12.2017 artem.neradko - написать JavaDoc для всех методов и классов

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

    public SearchByNumberPage clickOnSearchByNumber(){
        super.clickOnSearchByNumber(new By.ByXPath("/html/body/div[2]/div[1]/a[1]"));
        return PF.getPage(SearchByNumberPage.class);
    }

}
