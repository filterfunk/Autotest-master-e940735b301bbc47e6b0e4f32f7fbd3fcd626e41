package com.gisauto.stepdefs;

import com.gisauto.pageObjects.OrganizationInfo;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class OrganizationInfoStepDefs {

    @Если("^пользователь вводит инн \"([^\"]*)\"$")
    public void пользовательВводитИНН(String inn){
        PF.getPage(OrganizationInfo.class).typeInn(inn);
    }

    @Если("^пользователь вводит название магазина \"([^\"]*)\"$")
    public void пользовательВводитНазваниеМагазина(String shopName){
        PF.getPage(OrganizationInfo.class).typeShopName(shopName);
    }

    @Если("^пользователь вводит телефон магазина \"([^\"]*)\"$")
    public void пользовательВводитТелефонМагазина(String phone){
        PF.getPage(OrganizationInfo.class).typeShopPhone(phone);
    }

    @Если("^пользователь вводит почту магазина \"([^\"]*)\"$")
    public void пользовательВводитПочтуМагазина(String email){
        PF.getPage(OrganizationInfo.class).typeShopEmail(email);
    }

    @Если("^пользователь вводит сайт магазина \"([^\"]*)\"$")
    public void пользовательВводитСайтМагазина(String site){
        PF.getPage(OrganizationInfo.class).typeShopWebSite(site);
    }

    @Если("^пользователь вводит улицу магазина \"([^\"]*)\"$")
    public void пользовательВводитУлицуМагазина(String street){
        PF.getPage(OrganizationInfo.class).typeShopStreet(street);
    }

    @Если("^пользователь вводит дом магазина \"([^\"]*)\"$")
    public void пользовательВводитДомМагазина(String house){
        PF.getPage(OrganizationInfo.class).typeShopHouse(house);
    }

    @Если("^пользователь вводит офис магазина \"([^\"]*)\"$")
    public void пользовательВводитОфисМагазина(String office){
        PF.getPage(OrganizationInfo.class).typeShopFlat(office);
    }

    @Если("^пользователь нажимает на выбор города магазина")
    public void пользовательНажимаетНаВыборГородаМагазина(){
        PF.getPage(OrganizationInfo.class).clickOnSelectShopCity().clickOnFirstCity();
    }

    @Если("^пользователь нажимает сохранить данные")
    public void пользовательНажимаетСохранитьДанные(){
        PF.getPage(OrganizationInfo.class).clickOnSaveButton();
    }
}
