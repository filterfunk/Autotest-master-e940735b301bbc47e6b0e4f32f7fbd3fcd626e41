package com.gisauto.stepdefs;

import com.gisauto.pageObjects.VIN;
import com.gisauto.users.Individual;
import com.gisauto.users.LegalEntity;
import com.gisauto.utils.PF;
import com.gisauto.utils.UF;
import cucumber.api.PendingException;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;

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

    @Если("^пользователь вводит VIN имя \"([^\"]*)\"$")
    public void пользовательВводитИмя(String name) {
        PF.getPage(VIN.class).typeName(name);
    }

    @Если("^пользователь вводит VIN email \"([^\"]*)\"$")
    public void пользовательВводитEmail(String emailInput) {
        PF.getPage(VIN.class).typeEmail(emailInput);
    }

    @Если("^пользователь выбирает VIN город \"([^\"]*)\"$")
    public void пользовательВыбираетГород(String cityInput) {
        PF.getPage(VIN.class).chooseCity(cityInput);
    }

    @Если("^пользователь вводит VIN электронную почту физ лица")
    public void пользовательВводитЭлектроннуюПочтуФизЛица() {
        PF.getPage(VIN.class).typeEmail(UF.getUser(Individual.class).getLogin());
    }

    @Если("^пользователь вводит VIN электронную почту юр лица")
    public void пользовательВводитЭлектроннуюПочтуЮрЛица() {
        PF.getPage(VIN.class).typeEmail(UF.getUser(LegalEntity.class).getLogin());
    }

    @Если("пользователь нажимает кнопку отправить запрос")
    public void пользовательНажимаетКнопкуОтправитьЗапрос() {
        PF.getPage(VIN.class).clickOnSendRequest();
    }

    @Если("^пользователь нажимает кнопку я не знаю VIN")
    public void пользовательНажимаетКнопкуЯНеЗнаюVin() {
        PF.getPage(VIN.class).clickOnDontKnowVinButton();
    }

    @Если("^пользователь выбирает марку \"([^\"]*)\"$")
    public void пользовательВыбираетМарку(String brandButton) {
        PF.getPage(VIN.class).chooseBrand(brandButton);
    }

    @Если("^пользователь выбирает модель \"([^\"]*)\"$")
    public void пользовательВыбираетМодель(String modelButton) {
        PF.getPage(VIN.class).chooseModel(modelButton);
    }

    @Если("^пользователь вводит год \"([^\"]*)\"$")
    public void пользовательВводитГод(String yearInput) {
        PF.getPage(VIN.class).typeYear(yearInput);
    }

    @И("^пользователь нажимает зарегистрироваться VIN$")
    public void пользовательНажимаетЗарегистрироватьсяVIN() {
        PF.getPage(VIN.class).clickOnRegisterVIN();
    }

    @И("^пользователь нажимает физ лицо VIN$")
    public void пользовательНажимаетФизЛицоVIN() {
        PF.getPage(VIN.class).chooseFiz();
    }

    @И("^пользователь вводит пароль VIN \"([^\"]*)\"$")
    public void пользовательВводитПарольVIN(String user) {
        String pass;

        if (user.toLowerCase().trim().equals("физ")) {
            pass = UF.getUser(Individual.class).getPassword();
        } else if (user.toLowerCase().trim().equals("юр")) {
            pass = UF.getUser(LegalEntity.class).getPassword();
        } else throw new IllegalArgumentException("Неожиданный тип пользователя. " +
                "Ожидалось физ или юр, получено " + user);

        PF.getPage(VIN.class).typePassword(pass);
    }

    @И("^пользователь нажимает регистрация VIN$")
    public void пользовательНажимаетРегистрацияVIN() {
        PF.getPage(VIN.class).clickOnRegisterDone();
    }

    @И("^пользователь нажимает войти VIN$")
    public void пользовательНажимаетВойтиVIN() {
        PF.getPage(VIN.class).clickOnLogIn();
    }

    @И("^пользователь вводит пароль \"([^\"]*)\" VIN$")
    public void пользовательВводитПарольVINLogin(String pass) {
        PF.getPage(VIN.class).typePasswordLogin(pass);
    }

    @И("^пользователь нажимает на кнопку входа VIN$")
    public void пользовательНажимаетНаКнопкуВходаVIN() {
        PF.getPage(VIN.class).clickOnLoginButton();
    }
}

