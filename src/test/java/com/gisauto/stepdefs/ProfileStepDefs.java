package com.gisauto.stepdefs;

import com.gisauto.pageObjects.Profile;
import com.gisauto.pageObjects.SearchByNumberPage;
import com.gisauto.users.Individual;
import com.gisauto.utils.PF;
import com.gisauto.utils.UF;
import cucumber.api.java.ru.Если;

public class ProfileStepDefs {

    @Если("^пользователь нажимает поиск по номеру")
    public void пользовательНажимаетПоискПоНомеру() {
        PF.getPage(Profile.class).clickOnSearchByNumber();
    }

    @Если("^пользователь вводит фамилию \"([^\"]*)\"$")
    public void пользовательВводитФамилию(String surname) {
        PF.getPage(Profile.class).typeSurName(surname);
    }

    @Если("^пользователь вводит имя физ лица$")
    public void пользовательВводитИмя() {
        PF.getPage(Profile.class).typeName(UF.getUser(Individual.class).getName());
    }

    @Если("^пользователь вводит отчество \"([^\"]*)\"$")
    public void пользовательВводитОтчество(String secondName) {
        PF.getPage(Profile.class).typeSecondName(secondName);
    }

    @Если("^пользователь вводит телефон физ лица$")
    public void пользовательВводитТелефон() {
        PF.getPage(Profile.class).typePhone(UF.getUser(Individual.class).getPhoneNumber());
    }

    @Если("^пользователь выбирает город")
    public void пользовательВыбираетГород() {
        PF.getPage(Profile.class).clickOnCitySelect().clickOnFirstCity();
    }

    @Если("^пользователь нажимает сохранить профиль$")
    public void пользовательНажимаетСохранитьПрофиль() {
        PF.getPage(Profile.class).clickOnSaveButton();
    }

    @Если("^пользователь нажимает данные организации")
    public void пользовательНажимаетДанныеОрганизации() {
        PF.getPage(Profile.class).clickOnOrgInfo();
    }

    @Если("^пользователь нажимает загрузить прайс")
    public void пользовательНажимаетЗагрузитьПрайс() {
        PF.getPage(Profile.class).clickOnPriceUpload();
    }

}
