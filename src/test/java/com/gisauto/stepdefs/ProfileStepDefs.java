package com.gisauto.stepdefs;

import com.gisauto.pageObjects.gisauto.Profile;
import com.gisauto.pageObjects.gisauto.Warehouse;
import com.gisauto.users.Individual;
import com.gisauto.users.LegalEntity;
import com.gisauto.utils.PF;
import com.gisauto.utils.UF;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;

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
    public void пользовательВводитИмяФизЛица() {
        PF.getPage(Profile.class).typeName(UF.getUser(Individual.class).getName());
    }

    @Если("^пользователь вводит имя юр лица$")
    public void пользовательВводитИмяЮрЛица() {
        PF.getPage(Profile.class).typeName(UF.getUser(LegalEntity.class).getName());
    }

    @Если("^пользователь вводит отчество \"([^\"]*)\"$")
    public void пользовательВводитОтчество(String secondName) {
        PF.getPage(Profile.class).typeSecondName(secondName);
    }

    @Если("^пользователь вводит телефон физ лица$")
    public void пользовательВводитТелефонФизЛица() {
        PF.getPage(Profile.class).typePhone(UF.getUser(Individual.class).getPhoneNumber());
    }

    @Если("^пользователь вводит телефон юр лица$")
    public void пользовательВводитТелефонЮрЛица() {
        PF.getPage(Profile.class).typePhone(UF.getUser(LegalEntity.class).getPhoneNumber());
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

    @Если("^пользователь нажимает входящие запросы")
    public void пользовательНажимаетНаAВходящиеЗапросы() {
        PF.getPage(Profile.class).clickOnIncomingRequests();
    }

    @Если("^пользователь нажимает мои запчасти$")
    public void пользовательНажимаетМоиЗапчасти() {
        PF.getPage(Profile.class).clickOnWarehouse();
    }

    @То("^в таблице появлется производитель \"([^\"]*)\"$")
    public void вТаблицеПоявляетсяПроизводитель(String manufacturer) {
        Assert.assertEquals("Производитель " + manufacturer + " не обнаружен на складе.",
                true,
                PF.getPage(Warehouse.class).checkManufacturer(manufacturer));
    }

    @Если("^пользователь нажимает запрос по VIN$")
    public void пользовательНажимаетЗапросПоVIN() {
        PF.getPage(Profile.class).clickOnRequestToSpare();
    }

}
