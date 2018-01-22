package com.gisauto.stepdefs;

import com.gisauto.pageObjects.Profile;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class ProfileStepDefs {

    @Если("^пользователь нажимает поиск по номеру")
    public void пользовательНажимаетПоискПоНомеру() {
        PF.getPage(Profile.class).clickOnSearchByNumber();
    }

}
