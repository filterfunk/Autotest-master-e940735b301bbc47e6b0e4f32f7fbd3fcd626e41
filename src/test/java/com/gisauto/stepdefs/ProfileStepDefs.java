package com.gisauto.stepdefs;

import com.gisauto.pageObjects.Profile;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class ProfileStepDefs {

    @Если("^пользователь нажимает поиск по номеру")
    public void пользовательНажимаетПоискПоНомеру() {
        PF.getPage(Profile.class).clickOnSearchByNumber();
    }

    @Если("^пользователь вводит фамилию \"([^\"]*)\"$")
    public void пользовательВводитФамилию(String surname){
        PF.getPage(Profile.class).typeSurName(surname);
    }

    @Если("^пользователь вводит имя \"([^\"]*)\"$")
    public void пользовательВводитИмя(String name){
        PF.getPage(Profile.class).typeName(name);
    }

    @Если("^пользователь вводит отчество \"([^\"]*)\"$")
    public void пользовательВводитОтчество(String secondName){
        PF.getPage(Profile.class).typeSecondName(secondName);
    }

    @Если("^пользователь вводит телефон \"([^\"]*)\"$")
    public void пользовательВводитТелефон(String phone){
        PF.getPage(Profile.class).typePhone(phone);
    }

    @Если("^пользователь выбирает город")
    public void пользовательВыбираетГород(){
        PF.getPage(Profile.class).clickOnCitySelect().clickOnFirstCity();
    }

    @Если("^пользователь нажимает сохранить")
    public void пользовательНажимаетСохранить(){
        PF.getPage(Profile.class).clickOnSaveButton();
    }

    @Если("^пользователь нажимает данные организации")
    public void пользовательНажимаетДанныеОрганизации(){
        PF.getPage(Profile.class).clickOnOrgInfo();
    }


}
