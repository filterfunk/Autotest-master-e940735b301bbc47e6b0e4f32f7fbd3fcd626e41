package com.gisauto.stepdefs;

import com.gisauto.pageObjects.OutgoingRequests;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;

public class OutgoingStepDefs {

    @То("^в таблице отображается созданный запрос на \"([^\"]*)\"$")
    public void вТаблицеОтображаетсяСозданныйЗапрос(String partName) {
        PF.getPage(OutgoingRequests.class).checkRequest(partName);
    }

    @Если("^пользователь нажимает выход физ")
    public void пользовательНажимаетВыходФиз() {
        PF.getPage(OutgoingRequests.class).logoutFiz();
    }

    @Если("^пользователь нажимает выход юр")
    public void пользовательНажимаетВыходЮр() {
        PF.getPage(OutgoingRequests.class).logoutUr();
    }

}
