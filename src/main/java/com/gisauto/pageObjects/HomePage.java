package com.gisauto.pageObjects;

import com.gisauto.utils.PF;
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

    public HomePage() {
        openPage("http://test.gisauto.ru/");
        if (!checkTitle("Поиск автозапчастей по всей России")) {
            throw new IllegalStateException("Открытая страница не является главной страницей");
        }
    }

    public Profile loginAs(String username, String password) {
        return (Profile) typeUsername(username)
                .typePassword(password)
                .submitLogin();
    }

    @Step(value = "Нажатие на поиск по номеру")
    public SearchByNumberPage clickOnSearchByNumber() {
        super.clickOnSearchByNumber();
        return PF.getPage(SearchByNumberPage.class);
    }

}
