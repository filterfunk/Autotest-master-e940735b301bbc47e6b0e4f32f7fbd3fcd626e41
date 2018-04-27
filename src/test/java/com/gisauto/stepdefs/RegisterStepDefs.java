package com.gisauto.stepdefs;

import com.gisauto.pageObjects.gisauto.Register;
import com.gisauto.users.Individual;
import com.gisauto.users.LegalEntity;
import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import com.gisauto.utils.UF;
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

    @Если("^пользователь вводит логин пароль подтверждения пароля организацию юр лица$")
    public void пользовательВводитЛогинИПарольИОрганизацию() {
        PF.getPage(Register.class)
                .typeEmail(UF.getUser(LegalEntity.class).getLogin())
                .typePassword(UF.getUser(LegalEntity.class).getPassword())
                .typePasswordConfirm(UF.getUser(LegalEntity.class).getPassword())
                .typeOrganizationName(UF.getUser(LegalEntity.class).getShopName())
                .clickOnAcceptOfferButton()
                .submitt();
    }

    @Если("^пользователь вводит логин пароль подтверждения пароля физ лица$")
    public void пользовательВводитЛогинИПароль() {
        PF.getPage(Register.class)
                .typeEmail(UF.getUser(Individual.class).getLogin())
                .typePassword(UF.getUser(Individual.class).getPassword())
                .typePasswordConfirm(UF.getUser(Individual.class).getPassword())
                .clickOnAcceptOfferButton()
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
