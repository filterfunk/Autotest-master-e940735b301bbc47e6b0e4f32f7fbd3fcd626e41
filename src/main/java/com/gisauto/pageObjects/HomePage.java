package com.gisauto.pageObjects;

import com.gisauto.utils.PF;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

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
        openPage("https://beta.gisauto.ru/");
        if (!checkTitle("Поиск автозапчастей по всей России")) {
            throw new IllegalStateException("Открытая страница не является главной страницей");
        }
    }

    public Profile loginAs(String username, String password) {
        typeUsername(username).typePassword(password);
        return submitLogin();
    }

    public SearchByNumberPage clickOnSearchByNumber() {
        super.clickOnSearchByNumber();
        return PF.getPage(SearchByNumberPage.class);
    }

    @Override
    public Profile submitLogin() {
        try {
            getElement(submit).click();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AssertionError("Не удалось нажать на \"Войти\". Возможно элемент входа скрыт.");
        }
        await(2000);
        return PF.getPage(Profile.class);
    }

}
