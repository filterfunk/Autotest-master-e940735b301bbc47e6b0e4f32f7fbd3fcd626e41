package com.gisauto.stepdefs;

import com.gisauto.pageObjects.VIN;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class VINRequestStepDefs {
    @Если("^пользователь вводит в строку vin \"([^\"]*)\"$")
    public void пользовательВводитВСтрокуVin(String vin) {
        PF.getPage(VIN.class).inputVIN(vin);
    }

    @Если("пользователь нажимает кнопку проверить")
    public void пользовательНажимаетКнопкуПроверить() {
        PF.getPage(VIN.class).clickVINCheckButton();
    }

    @Если("пользователь нажимает кнопку далее")
    public void пользовательНажимаетКнопкуДалее() {
        PF.getPage(VIN.class).nextButton();
    }

    @Если("^пользователь вводит название запчасти \"([^\"]*)\"$")
    public void пользовательВводитНазваниеЗапчасти(String partName) {
        PF.getPage(VIN.class).partNameInput(partName);
    }

    @Если("^пользователь выбирает тип запчасти \"([^\"]*)\"$")
    public void пользовательВыбираетТипЗапчасти(String partType) {
        PF.getPage(VIN.class).clickOnPartType(partType);
    }

    @Если("^пользователь вводит имя \"([^\"]*)\"$")
    public void пользовательВводитИмя(String name) {
        PF.getPage(VIN.class).nameInput(name);
    }

    @Если("^пользователь вводит email \"([^\"]*)\"$")
    public void пользовательВводитEmail(String emailInput) {
        PF.getPage(VIN.class).emailInput(emailInput);
    }

    @Если("^пользователь выбирает город \"([^\"]*)\"$")
    public void пользовательВыбираетГород(String cityInput) {
        PF.getPage(VIN.class).cityInput(cityInput);
    }


}

