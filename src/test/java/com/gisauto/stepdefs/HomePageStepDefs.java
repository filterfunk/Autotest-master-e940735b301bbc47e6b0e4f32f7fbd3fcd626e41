package com.gisauto.stepdefs;

import com.gisauto.pageObjects.HomePage;
import com.gisauto.pageObjects.Profile;
import com.gisauto.users.Individual;
import com.gisauto.users.LegalEntity;
import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import com.gisauto.utils.UF;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;

public class HomePageStepDefs {

    @Если("^пользователь нажимает на поиск по номеру")
    public void пользовательНажимаетНаПоискПоНомеру() {
        PF.getPage(HomePage.class).clickOnSearchByNumber();
    }

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

    @Если("^пользователь вводит логин и пароль физ лица$")
    public void пользовательВводитЛогинИПарольФизЛица() {
        PF
                .getPage(HomePage.class)
                .loginAs(UF.getUser(Individual.class).getLogin(), UF.getUser(Individual.class).getPassword());
    }

    @Если("^пользователь вводит логин и пароль юр лица$")
    public void пользовательВводитЛогинИПарольЮрЛица() {
        PF
                .getPage(HomePage.class)
                .loginAs(UF.getUser(LegalEntity.class).getLogin(), UF.getUser(LegalEntity.class).getPassword());
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

    @Если("^пользователь вводит логин пароль \"([^\"]*)\" \"([^\"]*)\"$")
    public void пользовательВводитЛогинПароль(String login, String password) {
        PF.getPage(HomePage.class).loginAs(login, password);
    }

}
