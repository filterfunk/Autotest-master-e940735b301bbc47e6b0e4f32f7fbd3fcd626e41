package com.gisauto.pageObjects;

import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
            register = new By.ByXPath("//*[@id=\"loginModal\"]/div/div/div[2]/div"),
            wareHouse = new By.ByXPath("//*[@id=\"modalProfile\"]/div/div/div[2]/div[2]/div[4]/div/a"),
            profile = new By.ByXPath("//*[@id=\"login-menu-block\"]/div/div[2]");

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

    public BasePage clickOnIncomingRequests() {
        UrLicoModal.clickOnIncomingRequest();
        return this;
    }

    public BasePage clickOnOutgoingRequestsFiz() {
        FizLicoModal.clickOnOutGoingRequest();
        return this;
    }

    public BasePage clickOnOutgoingRequestsUr() {
        UrLicoModal.clickOnOutgoingRequest();
        return this;
    }

    public BasePage clickOnWarehouse() {
        getElement(wareHouse).click();
        return this;
    }

    public BasePage logoutFiz() {
        FizLicoModal.clickOnExit();
        await(1000);
        return this;
    }

    public BasePage logoutUr() {
        UrLicoModal.clickOnLogOut();
        return this;
    }

    public BasePage clickOnProfileButton() {
        await(1000);
        getElement(profile).click();
        return this;
    }


    public BasePage refreshPage() {
        Driver.getDriver().navigate().refresh();
        return this;
    }

    private static class FizLicoModal {

        private static final By outgoingRequests = new By.ByXPath("//*[@id=\"modalProfile\"]/div/div/div[2]/div[2]/div/div[1]/a[text() = 'Мои запросы']"),
                exit = new By.ByXPath("//*[@id=\"modalProfile\"]/div/div/div[2]/div[2]/div[5]/div[1]/div");

        public static void clickOnOutGoingRequest() {
            getElement(outgoingRequests).click();
        }

        public static void clickOnExit() {
            getElement(exit).click();
        }

    }

    private static class UrLicoModal {

        private static final By incomingRequests = new By.ByXPath("//*[@id=\"modalProfile\"]/div/div/div[2]/div[2]/div[5]/div[1]/a[text() = 'Входящие запросы']"),
                exit = new By.ByClassName("modal-profile__text med logout-btn"),
                outgoingRequests = new By.ByXPath("//*[@id=\"modalProfile\"]/div/div/div[2]/div[2]/div[6]/div[1]/a[text() = 'Исходящие запросы']");

        public static void clickOnLogOut() {
            getElement(exit).click();
        }

        public static void clickOnIncomingRequest() {
            getElement(incomingRequests).click();
        }

        public static void clickOnOutgoingRequest() {
            getElement(outgoingRequests).click();
        }
    }

}
