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

    @Если("^пользователь нажимает выход \"([^\"]*)\"$")
    public void пользовательНажимаетВыход(String user) {
        if (user.toLowerCase().trim().equals("физ")) {
            PF.getPage(OutgoingRequests.class).logoutFiz();
        } else if (user.toLowerCase().trim().equals("юр")) {
            PF.getPage(OutgoingRequests.class).logoutUr();
        } else {
            throw new IllegalArgumentException("Ожидался аргумент физ или юр, но получен " + user);
        }
    }


}
