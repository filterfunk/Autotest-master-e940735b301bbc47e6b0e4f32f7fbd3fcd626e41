package com.gisauto.stepdefs;

import com.gisauto.pageObjects.VIN;
import com.gisauto.users.Individual;
import com.gisauto.utils.PF;
import com.gisauto.utils.UF;
import cucumber.api.java.ru.Если;

public class VINRequestStepDefs {

    @Если("^пользователь вводит в строку vin \"([^\"]*)\"$")
    public void пользовательВводитВСтрокуVin(String vin) {
        PF.getPage(VIN.class).typeVIN(vin);
    }

    @Если("пользователь нажимает кнопку проверить")
    public void пользовательНажимаетКнопкуПроверить() {
        PF.getPage(VIN.class).clickVINCheckButton();
    }

    @Если("пользователь нажимает кнопку далее")
    public void пользовательНажимаетКнопкуДалее() {
        PF.getPage(VIN.class).clickOnNextButton();
    }

    @Если("^пользователь вводит название запчасти \"([^\"]*)\"$")
    public void пользовательВводитНазваниеЗапчасти(String partName) {
        PF.getPage(VIN.class).typePartName(partName);
    }

    @Если("^пользователь выбирает тип запчасти \"([^\"]*)\"$")
    public void пользовательВыбираетТипЗапчасти(String partType) {
        PF.getPage(VIN.class).clickOnPartType(partType);
    }

    @Если("^пользователь вводит имя \"([^\"]*)\"$")
    public void пользовательВводитИмя(String name) {
        PF.getPage(VIN.class).typeName(name);
    }

    @Если("^пользователь вводит email \"([^\"]*)\"$")
    public void пользовательВводитEmail(String emailInput) {
        PF.getPage(VIN.class).typeEmail(emailInput);
    }

    @Если("^пользователь выбирает город \"([^\"]*)\"$")
    public void пользовательВыбираетГород(String cityInput) {
        PF.getPage(VIN.class).chooseCity(cityInput);
    }

    @Если("^пользователь вводит случайную электронную почту")
    public void пользовательВводитСлучайнуюЭлектроннуюПочту() {
        PF.getPage(VIN.class).typeEmail(UF.getUser(Individual.class).getLogin());
    }

}

