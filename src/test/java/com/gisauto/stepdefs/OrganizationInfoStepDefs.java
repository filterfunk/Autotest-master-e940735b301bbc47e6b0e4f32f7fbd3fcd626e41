package com.gisauto.stepdefs;

import com.gisauto.pageObjects.OrganizationInfo;
import com.gisauto.users.LegalEntity;
import com.gisauto.utils.PF;
import com.gisauto.utils.UF;
import cucumber.api.java.ru.Если;

public class OrganizationInfoStepDefs {

    @Если("^пользователь вводит инн$")
    public void пользовательВводитИнн() {
        PF.getPage(OrganizationInfo.class).typeInn(UF.getUser(LegalEntity.class).getInn() + "");
    }

    @Если("^пользователь вводит название магазина \"([^\"]*)\"$")
    public void пользовательВводитНазваниеМагазина(String shopName) {
        PF.getPage(OrganizationInfo.class).typeShopName(shopName
         + " - " +UF.getUser(LegalEntity.class).getShopName());
    }

    @Если("^пользователь вводит телефон магазина$")
    public void пользовательВводитТелефонМагазина() {
        PF.getPage(OrganizationInfo.class).typeShopPhone(UF.getUser(LegalEntity.class).getPhoneNumber());
    }

    @Если("^пользователь вводит почту магазина$")
    public void пользовательВводитПочтуМагазина() {
        PF.getPage(OrganizationInfo.class).typeShopEmail(UF.getUser(LegalEntity.class).getLogin());
    }

    @Если("^пользователь вводит сайт магазина \"([^\"]*)\"$")
    public void пользовательВводитСайтМагазина(String site) {
        PF.getPage(OrganizationInfo.class).typeShopWebSite(site);
    }

    @Если("^пользователь вводит улицу магазина \"([^\"]*)\"$")
    public void пользовательВводитУлицуМагазина(String street) {
        PF.getPage(OrganizationInfo.class).typeShopStreet(street);
    }

    @Если("^пользователь вводит дом магазина \"([^\"]*)\"$")
    public void пользовательВводитДомМагазина(String house) {
        PF.getPage(OrganizationInfo.class).typeShopHouse(house);
    }

    @Если("^пользователь вводит офис магазина \"([^\"]*)\"$")
    public void пользовательВводитОфисМагазина(String office) {
        PF.getPage(OrganizationInfo.class).typeShopFlat(office);
    }

    @Если("^пользователь нажимает на выбор города магазина")
    public void пользовательНажимаетНаВыборГородаМагазина() {
        PF.getPage(OrganizationInfo.class).clickOnSelectShopCity().clickOnFirstCity();
    }

    @Если("^пользователь нажимает сохранить данные$")
    public void пользовательНажимаетСохранитьДанные() {
        PF.getPage(OrganizationInfo.class).clickOnSaveButton();
    }
}
