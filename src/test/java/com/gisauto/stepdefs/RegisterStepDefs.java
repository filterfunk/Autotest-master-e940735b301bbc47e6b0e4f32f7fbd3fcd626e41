package com.gisauto.stepdefs;

import com.gisauto.pageObjects.HomePage;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class RegisterStepDefs {

    @Если("^пользователь вводит корректный \"([^\"]*)\" и \"([^\"]*)\" и \"([^\"]*)\"$")
    public void пользовательВводитКорректныйЛогинИПарольИОрганизацию(String login, String password, String org) {
        ((HomePage) PF
                .getPage(HomePage.class)
                .clickOnDropDown())
                .loginAs(login, password);
    }
}
