package com.gisauto.pageObjects;

import com.gisauto.utils.PF;
import com.gisauto.utils.TestMain;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * PageObject главной страницы
 * <p>
 * Хранит в себе информацию и набор методов для работы с WebElement'ами, присутствующими
 * на главной странице.
 *
 * @author Neradko Artsiom
 */
public class HomePage extends BasePage {

    private final By.ByXPath submit = new By.ByXPath("//*[@id=\"formLogin-modal\"]/button");

    public HomePage() {
        openPage("https://gisauto.ru/");
        if (!checkTitle("Поиск автозапчастей по всей России")) {
            throw new IllegalStateException("Открытая страница не является главной страницей");
        }
    }

    public Profile loginAs(String username, String password) {
        typeUsername(username).typePassword(password);
        return submitLogin();
    }

    @Step(value = "Нажатие на поиск по номеру")
    public SearchByNumberPage clickOnSearchByNumber() {
        super.clickOnSearchByNumber();
        return PF.getPage(SearchByNumberPage.class);
    }

    @Step(value = "Нажати на кнопку \"Войти\"")
    @Override
    public Profile submitLogin() {
        try {
            getElement(submit).click();
            TestMain.await(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AssertionError("Не удалось нажать на \"Войти\". Возможно элемент входа скрыт.");
        }
        return PF.getPage(Profile.class);
    }

}
