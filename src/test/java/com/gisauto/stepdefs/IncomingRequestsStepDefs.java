package com.gisauto.stepdefs;

import com.gisauto.pageObjects.gisauto.IncomingRequest;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import org.junit.Assert;

/**
 * @autor neradko, created on 17.04.18
 */

public class IncomingRequestsStepDefs {

    @То("^в таблице входящих запросов появляется текущая дата$")
    public void вТаблицеВходящихЗапросовПоявляетсяТекущаяДата() {
        Assert.assertEquals("", true, PF.getPage(IncomingRequest.class).checkDate());
    }

    @И("^в таблице входящих запросов появляется покупатель \"([^\"]*)\"$")
    public void вТаблицеВходящихЗапросовПоявляетсяПокупатель(String customer) {
        Assert.assertEquals("", true, PF.getPage(IncomingRequest.class).checkCustomer(customer));
    }

    @И("^в таблице входящих запросов появляется авто \"([^\"]*)\"$")
    public void вТаблицеВходящихЗапросовПоявляетсяАвто(String auto) {
        Assert.assertEquals("", true, PF.getPage(IncomingRequest.class).checkAuto(auto));
    }

    @И("^в таблице входящих запросов появляется запчасть \"([^\"]*)\"$")
    public void вТаблицеВходящихЗапросовПоявляетсяЗапчасть(String part) {
        Assert.assertEquals("", true, PF.getPage(IncomingRequest.class).checkPart(part));
    }
}
