package com.gisauto.stepdefs;

import com.gisauto.pageObjects.HomePage;
import com.gisauto.pageObjects.Profile;
import com.gisauto.utils.PF;
import com.gisauto.utils.TestMain;
import com.gisauto.utils.annotations.TargetBrowser;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;

@TargetBrowser(browser = "F")
public final class StepDefs extends TestMain {

    private HomePage homePage;
    private Profile profile;

    @Дано("^пользователь открывает главную страницу")
    public void пользовательОткрываетГлавнуюСтраницу() {
        homePage = PF.getPage(HomePage.class);
    }

    @Если("^пользователь вводит корректный \"([^\"]*)\" и \"([^\"]*)\"$")
    public void пользовательВводитКорректныйЛогинИПароль(String login, String password) {
        profile = ((HomePage) homePage
                .clickOnDropDown()).loginAs(login, password);
    }

    @Если("пользователь вводит некорректный \"([^\"]*)\" и \"([^\"]*)\"$")
    public void пользовательВводитНекорректныйЛогин(String login, String password) {
        ((HomePage) homePage
                .clickOnDropDown()).loginAs(login, password);
    }

    @То("^система редиректит на страницу профиля")
    public void системаРедиректитНаСтраницуПрофиля() {
        Assert.assertEquals("Автозапчасти России - Настройки - Мой профиль", TestMain.driver.getTitle());
    }

    @То("^система выводит сообщение, что введенные данные не верны")
    public void системаВыводитСообщениеЧтоВведенныеДанныеНеВерны() {

    }

}
