package com.gisauto.pageObjects;

import com.gisauto.utils.TestMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    //TODO: 11.12.2017 artem.neradko - написать JavaDoc для всех методов и классов
    private final WebDriver driver = TestMain.driver;
    private final By login = By.name("_username"),
            password = By.name("_password"),
            dropDownToogle = new By.ByClassName("dropdown-toggle"),
            submit = new By.ByXPath("//*[@id=\"formLogin\"]/div[7]/button");

    public BasePage() {

    }

    private By selectCity = new By.ByXPath("//*[@id=\"btnOpenCity\"]"),
            searchByNumber = new By.ByXPath("/html/body/div[1]/div[2]/div/nav/a[1]"),
            catalog = new By.ByXPath("/html/body/div[1]/div[2]/div/nav/a[2]"),
            vinRequest = new By.ByXPath("/html/body/div[1]/div[2]/div/nav/a[3]"),
            about = new By.ByXPath("/html/body/div[1]/div[3]/div[1]/a"),
            top100 = new By.ByXPath("/html/body/div[1]/div[3]/div[2]/span");

    public BasePage clickOnSelectCity() {
        getElement(selectCity).click();
        return this;
    }

    public BasePage clickAny() {
        getElement(new By.ByXPath("//*[@id=\"modalSelectCity\"]")).click();
        return this;
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public BasePage clickOnDropDown() {
        getElement(dropDownToogle).click();
        return this;
    }

    public BasePage typeUsername(String username) {
        getElement(login).sendKeys(username);
        return this;
    }

    public BasePage typePassword(String pass) {
        getElement(password).sendKeys(pass);
        return this;
    }

    public BasePage submitLogin() {
        getElement(submit).click();
        return this;
    }

    public BasePage clickOnSearchByNumber(By by) {
        getElement(by).click();
        return this;
    }

    public BasePage clickOnCatalog() {
        getElement(catalog).click();
        return this;
    }
    public BasePage clickOnVINRequest() {
        getElement(vinRequest).click();
        return this;
    }

}
