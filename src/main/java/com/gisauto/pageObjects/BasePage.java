package com.gisauto.pageObjects;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

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
    private final By login = new By.ByXPath("//*[@id=\"username\"]"),
            password = new By.ByXPath("//*[@id=\"password\"]"),
            dropDownToogle = new By.ByXPath("//*[@id=\"login-menu-block\"]"),
            submit = new By.ByXPath("//*[@id=\"formLogin-modal\"]/button"),
            city = new By.ByXPath("//*[@id=\"modalSelectCity\"]/div/div/div[1]"),
            selectCity = new By.ByXPath("/html/body/div[1]/div[3]/div[1]/span"),
            searchByNumber = new By.ByXPath("/html/body/div[2]/nav/ul/li[1]/a"),
            catalog = new By.ByXPath("/html/body/div[2]/nav/ul/li[2]/a"),
            vinRequest = new By.ByXPath("/html/body/div[2]/nav/ul/li[3]/a"),
            toHome = new By.ByXPath("/html/body/div[1]/div[1]/div[2]/div[1]"),
            priceUpload = new By.ByXPath("//*[@id=\"price-up\"]"),
            bg = new By.ByXPath("/html/body/div[4]"),
            contacts = new By.ByXPath("//*[@id=\"openContactsModal\"]"),
            cart = new By.ByXPath("//*[@id=\"openCart\"]");

    @Step(value = "Нажатие на кнопку выбора города")
    public BasePage clickOnSelectCity() {
        getElement(selectCity).click();
        return this;
    }

    @Step(value = "Нажатие на футер, для закрытия модального окна")
    public BasePage clickAny() {
        getElement(bg).click();
        return this;
    }

    @Step(value = "Нажатие на кнопку входа/пользователя")
    public BasePage clickOnDropDown() {
        getElement(dropDownToogle).click();
        return this;
    }

    @Step(value = "Ввод логина")
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

    @Step(value = "Ввод пароля")
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

    @Step(value = "Нажати на кнопку \"Войти\"")
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

    @Step(value = "Нажатие на \"Поиск по номеру\"")
    public BasePage clickOnSearchByNumber() {
        try {
            getElement(searchByNumber).click();
        } catch (Exception ex) {
            logger.error("Не удалось нажать на \"Поиск по номеру\".");
            ex.printStackTrace();
            throw new AssertionError("Не удалось нажать на \"Поиск по номеру\".");
        }
        return this;
    }

    @Step(value = "Нажатие на \"Каталоги запчастей\"")
    public BasePage clickOnCatalog() {
        getElement(catalog).click();
        return this;
    }

    @Step(value = "Нажатие на \"Запрос по VIN\"")
    public BasePage clickOnVINRequest() {
        getElement(vinRequest).click();
        return this;
    }

    public boolean isCityVisible() {
        return isVisible(getElement(city));
    }

}
