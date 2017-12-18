package com.gisauto.test.pageObjects;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Базовый клас PageObject'ов, от которого наследуются все прочие Page GisAuto.
 * <p>
 * Хранит в себе информацию и набор методов для работы с WebElement'ами, присутствующими
 * на каждой странице.
 *
 * @author Neradko Artsiom
 */
public class BasePage extends Page {

    private final By login = By.name("_username"),
            password = By.name("_password"),
            dropDownToogle = new By.ByClassName("dropdown-toggle"),
            submit = new By.ByXPath("//*[@id=\"formLogin\"]/div[7]/button"),
            city = new By.ByXPath("//*[@id=\"formSetCity\"]");

    private static Logger logger = LogManager.getRootLogger();

    private By selectCity = new By.ByXPath("//*[@id=\"btnOpenCity\"]"),
            searchByNumber = new By.ByXPath("/html/body/div[1]/div[2]/div/nav/a[1]"),
            catalog = new By.ByXPath("/html/body/div[1]/div[2]/div/nav/a[2]"),
            vinRequest = new By.ByXPath("/html/body/div[1]/div[2]/div/nav/a[3]"),
            about = new By.ByXPath("/html/body/div[1]/div[3]/div[1]/a"),
            top100 = new By.ByXPath("/html/body/div[1]/div[3]/div[2]/span");

    /**
     * Имитация нажатия на кнопку выбора города.
     *
     * @return самого себя.
     */
    @Step(value = "Нажатие на кнопку выбора города")
    public BasePage clickOnSelectCity() {
        getElement(selectCity).click();
        return this;
    }

    /**
     * Имитация нажатия в любое место страницы.
     * <p>
     * Используется для закрытия модальных окон.
     *
     * @return самого себя.
     */
    @Step(value = "Нажатие на любое место страницы, для закрытия модального окна")
    public BasePage clickAny() {
        getElement(new By.ByXPath("//*[@id=\"modalSelectCity\"]")).click();
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
            throw new AssertionError();
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
            throw new AssertionError();
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
            throw new AssertionError();
        }
        return this;
    }

    @Step(value = "Нажатие на \"Поиск по номеру\"")
    public BasePage clickOnSearchByNumber(By by) {
        try {
            getElement(by).click();
        } catch (Exception ex) {
            logger.error("Не удалось нажать на \"Поиск по номеру\".");
            ex.printStackTrace();
            screenShot();
            throw new AssertionError();
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
