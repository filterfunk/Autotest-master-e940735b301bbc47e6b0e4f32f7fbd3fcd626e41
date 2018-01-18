package com.gisauto.stepdefs;

import com.gisauto.pageObjects.BasePage;
import com.gisauto.pageObjects.HomePage;
import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;

public final class BasePageStepDefs {

    @Дано("^пользователь открывает главную страницу")
    public void пользовательОткрываетГлавнуюСтраницу() {
        PF.getPage(HomePage.class);
    }

    @Если("^пользователь нажимает войти")
    public void пользовательНажимаетВойти(){
        PF.getPage(BasePage.class).clickOnDropDown();
    }

    @Если("^пользователь нажимает зарегистрироваться")
    public void пользовательНажимаетЗарегистрироваться(){
        PF.getPage(HomePage.class).clickOnDropDown();
    }

    @Если("^пользователь вводит корректный \"([^\"]*)\" и \"([^\"]*)\"$")
    public void пользовательВводитКорректныйЛогинИПароль(String login, String password) {
        ((HomePage) PF
                .getPage(HomePage.class)
                .clickOnDropDown())
                .loginAs(login, password);
    }

    @Если("пользователь вводит некорректный \"([^\"]*)\" и \"([^\"]*)\"$")
    public void пользовательВводитНекорректныйЛогин(String login, String password) {
        ((HomePage) PF
                .getPage(HomePage.class)
                .clickOnDropDown())
                .loginAs(login, password);
    }

    @То("^система редиректит на страницу профиля")
    public void системаРедиректитНаСтраницуПрофиля() {
        Assert
                .assertEquals("Автозапчасти России - Настройки - Мой профиль", Driver.getDriver()
                        .getTitle());
    }

    @То("^система выводит сообщение, что введенные данные не верны")
    public void системаВыводитСообщениеЧтоВведенныеДанныеНеВерны() {

    }

    public boolean isLoggedIn() {
        return PF
                .getPage(HomePage.class)
                .isLoggedIn();
    }

}
