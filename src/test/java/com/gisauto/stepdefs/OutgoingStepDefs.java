package com.gisauto.stepdefs;

import com.gisauto.pageObjects.gisauto.OutgoingRequests;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;

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

    @То("^в таблице появляется дата$")
    public void вТаблицеПоявляетсяДата() {
        Assert.assertEquals("Запрос с текущей датой не обнаружен. ",
                true,
                PF.getPage(OutgoingRequests.class).checkDate());
    }

    @То("^в таблице появляется бренд \"([^\"]*)\"$")
    public void вТаблицеПоявляетсяБренд(String brand) {
        Assert.assertEquals("Бренд " + brand + " не обнаружен.",
                true,
                PF.getPage(OutgoingRequests.class).checkBrand(brand));
    }

    @То("^в таблице появляется наименование \"([^\"]*)\"$")
    public void вТаблицеПоявляетсяНаименование(String name) {
        Assert.assertEquals(" Наименование " + name + " не обнаружено.",
                true,
                PF.getPage(OutgoingRequests.class).checkName(name));
    }


}
