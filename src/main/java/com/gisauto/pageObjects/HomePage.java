package com.gisauto.pageObjects;

import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Map;

/**
 * PageObject главной страницы
 * <p>
 * Хранит в себе информацию и набор методов для работы с WebElement'ами, присутствующими
 * на главной странице.
 *
 * @author Neradko Artsiom
 */
public class HomePage extends BasePage {

    private final By searchByNumber = new By.ByXPath("/html/body/div[2]/nav/ul/li[1]/a");

    public HomePage() {
        super();
        openPage(System.getenv("HOMEPAGE"));
        Assert.assertEquals("Открытая страница не является главной страницей",
                "Поиск автозапчастей по всей России",
                Driver.getDriver().getTitle());
    }

    public Profile loginAs(String username, String password) {
        typeUsername(username).typePassword(password);
        return submitLogin();
    }

    public SearchByNumberPage clickOnSearchByNumber() {
        getElement(this.searchByNumber).click();
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
