package com.gisauto.stepdefs;

import com.gisauto.pageObjects.HomePage;
import com.gisauto.pageObjects.Profile;
import com.gisauto.pageObjects.Register;
import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;

public final class HomePageStepDefs {

    @Дано("^пользователь открывает главную страницу")
    public void пользовательОткрываетГлавнуюСтраницу() {
        PF.getPage(HomePage.class);
    }

    @Если("^пользователь нажимает войти")
    public void пользовательНажимаетВойти() {
        PF.getPage(HomePage.class).clickOnDropDown();
    }

    @Если("^пользователь нажимает зарегистрироваться")
    public void пользовательНажимаетЗарегистрироваться() {
        PF.getPage(HomePage.class).clickOnRegister();
    }

    @Если("^пользователь вводит \"([^\"]*)\" и \"([^\"]*)\"$")
    public void пользовательВводитЛогинИПароль(String login, String password) {
        PF
                .getPage(HomePage.class)
                .loginAs(login, password);
    }

    @То("^система редиректит на страницу профиля")
    public void системаРедиректитНаСтраницуПрофиля() {
        PF.getPage(Profile.class).isPageLoaded("Автозапчасти России - Настройки - Мой профиль");
        Assert
                .assertEquals("Автозапчасти России - Настройки - Мой профиль", Driver.getDriver()
                        .getTitle());
    }

    @То("^система выводит сообщение, что введенные данные не верны")
    public void системаВыводитСообщениеЧтоВведенныеДанныеНеВерны() {

    }

    @То("^открывается модалка входа")
    public void открываетсяМодалкаВхода() {
        Assert.
                assertEquals("Модалка входа окрыта", true, PF.getPage(HomePage.class)
                        .isModalVisible());
    }

    public boolean isLoggedIn() {
        return PF
                .getPage(HomePage.class)
                .isLoggedIn();
    }

}
