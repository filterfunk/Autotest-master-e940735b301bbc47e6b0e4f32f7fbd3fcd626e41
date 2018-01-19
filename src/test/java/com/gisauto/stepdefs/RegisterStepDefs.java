package com.gisauto.stepdefs;

import com.gisauto.pageObjects.Register;
import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;

public class RegisterStepDefs {

    @Если("^пользователь нажимает организация")
    public void пользовательНажимаетОрганизация() {
        PF.getPage(Register.class).clickOnOrganization();
    }

    @Если("^пользователь нажимает частное лицо")
    public void пользовательНажимаетЧастноеЛицо() {
        PF.getPage(Register.class).clickOnFizLico();
    }

    @Если("^пользователь вводит \"([^\"]*)\" и \"([^\"]*)\" и \"([^\"]*)\" и \"([^\"]*)\"$")
    public void пользовательВводитЛогинИПарольИОрганизацию(String login, String password, String passwordConfirm, String org) {
        PF.getPage(Register.class)
                .typeEmail(login)
                .typePassword(password)
                .typePasswordConfirm(passwordConfirm)
                .typeOrganizationName(org)
                .submitt();
    }

    @Если("^пользователь вводит \"([^\"]*)\" и \"([^\"]*)\" и \"([^\"]*)\"$")
    public void пользовательВводитЛогинИПароль(String login, String password, String passwordConfirm) {
        PF.getPage(Register.class)
                .typeEmail(login)
                .typePassword(password)
                .typePasswordConfirm(passwordConfirm)
                .submitt();
    }

    @То("^появляется 4 поля ввода и кнопка зарегистрироваться")
    public void появляется4ПоляВводаИКнопкаЗарегистрироваться() {
        Assert
                .assertEquals("Поля ввода скрыты", true, PF.getPage(Register.class)
                        .isOrgElementsVisible());
    }

    @То("^появляется 3 поля ввода и кнопка зарегистрироваться")
    public void появляется3ПоляВводаИКнопкаЗарегистрироваться() {
        Assert
                .assertEquals("Поля ввода скрыты", true, PF.getPage(Register.class)
                        .isFizLicoElementsVisible());
    }

    @То("^система редиректит на страницу регистрации")
    public void системаРедиректитНаСтраницуРегистрации() {
        PF.getPage(Register.class).isPageLoaded("Регистрация на портале GisAuto.ru");
        Assert.assertEquals("Регистрация на портале GisAuto.ru", Driver.getDriver().getTitle());
    }
}
