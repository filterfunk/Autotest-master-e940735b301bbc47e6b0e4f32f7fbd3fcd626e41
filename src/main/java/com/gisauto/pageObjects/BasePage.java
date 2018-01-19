package com.gisauto.pageObjects;

import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

/**
 * Базовый клас PageObject'ов, от которого наследуются все прочие Page GisAuto.
 * <p>
 * Хранит в себе информацию и набор методов для работы с WebElement'ами, присутствующими
 * на каждой странице.
 *
 * @author Neradko Artsiom
 */
public abstract class BasePage extends Page {

    private static Logger logger = LogManager.getRootLogger();
    final By login = new By.ByXPath("//*[@id=\"username\"]"),
            password = new By.ByXPath("//*[@id=\"password\"]"),
            dropDownToogle = new By.ByXPath("//*[@id=\"login-menu-block\"]"),
            submit = new By.ByXPath("//*[@id=\"formLogin-modal\"]/button"),
            city = new By.ByXPath("//*[@id=\"modalSelectCity\"]/div/div/div[1]"),
            selectCity = new By.ByXPath("/html/body/div[1]/div[3]/div[1]/span"),
            searchByNumber = new By.ByXPath("/html/body/div[1]/div[1]/nav/ul/li[1]"),
            catalog = new By.ByXPath("/html/body/div[2]/nav/ul/li[2]/a"),
            vinRequest = new By.ByXPath("/html/body/div[2]/nav/ul/li[3]/a"),
            toHome = new By.ByXPath("/html/body/div[1]/div[1]/div[2]/div[1]"),
            priceUpload = new By.ByXPath("//*[@id=\"price-up\"]"),
            closeCity = new By.ByXPath("//*[@id=\"modalSelectCity\"]/div/div/div[1]/div[1]/div"),
            contacts = new By.ByXPath("//*[@id=\"openContactsModal\"]"),
            cart = new By.ByXPath("//*[@id=\"openCart\"]"),
            register = new By.ByXPath("//*[@id=\"loginModal\"]/div/div/div[2]/div");

    public BasePage clickOnSelectCity() {
        getElement(selectCity).click();
        return this;
    }

    public BasePage clickAny() {
        getElement(closeCity).click();
        return this;
    }

    public BasePage clickOnDropDown() {
        getElement(dropDownToogle).click();
        return this;
    }

    public BasePage typeUsername(String username) {
        try {
            getElement(login).sendKeys(username);
        } catch (Exception ex) {
            logger.error("Не удалось ввести имя пользователя. Возможно элемент входа скрыт.");
            ex.printStackTrace();
            throw new AssertionError("Не удалось ввести имя пользователя. Возможно элемент входа скрыт.");
        }
        return this;
    }

    public BasePage typePassword(String pass) {
        try {
            getElement(password).sendKeys(pass);
        } catch (Exception ex) {
            logger.error("Не удалось ввести пароль. Возможно элемент входа скрыт.");
            ex.printStackTrace();
            throw new AssertionError("Не удалось ввести пароль. Возможно элемент входа скрыт.");
        }
        return this;
    }

    public BasePage submitLogin() {
        try {
            getElement(submit).click();
        } catch (Exception ex) {
            logger.error("Не удалось нажать на \"Войти\". Возможно элемент входа скрыт.");
            ex.printStackTrace();
            throw new AssertionError("Не удалось нажать на \"Войти\". Возможно элемент входа скрыт.");
        }
        return this;
    }

    public SearchByNumberPage clickOnSearchByNumber() {
        try {
            getElement(searchByNumber).click();
        } catch (Exception ex) {
            logger.error("Не удалось нажать на \"Поиск по номеру\".");
            ex.printStackTrace();
            throw new AssertionError("Не удалось нажать на \"Поиск по номеру\".");
        }
        return PF.getPage(SearchByNumberPage.class);
    }

    public BasePage clickOnCatalog() {
        getElement(catalog).click();
        return this;
    }

    public BasePage clickOnVINRequest() {
        getElement(vinRequest).click();
        return this;
    }

    public BasePage clickOnCart() {
        getElement(cart).click();
        return this;
    }

    public HomePage clickOnToHome() {
        getElement(toHome).click();
        return PF.getPage(HomePage.class);
    }

    public BasePage clickOnPriceUpload() {
        getElement(priceUpload).click();
        return this;
    }

    public BasePage clickOnContacts() {
        getElement(contacts).click();
        return this;
    }

    public Register clickOnRegister() {
        getElement(register).click();
        return PF.getPage(Register.class);
    }

    public boolean isModalVisible() {
        return isVisible(getElement(register));
    }

    public boolean isCityVisible() {
        return isVisible(getElement(city));
    }

    public boolean isLoggedIn() {
        return !isVisible(getElement(dropDownToogle));
    }

}
