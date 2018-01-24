package com.gisauto.stepdefs;

import com.gisauto.pageObjects.PriceUpload;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class PriceUploadStepDefs {

    @Если("^пользователь нажимает ручная загрузка")
    public void пользовательНажимаетРучнаяЗагрузка(){
        PF.getPage(PriceUpload.class).clickOnHandUploadButton();
    }

    @Если("^пользователь нажимает выбрать файл \"([^\"]*)\"$")
    public void пользовательНажимаетВыбратьФайл(String fileName){
        PF.getPage(PriceUpload.class).clickOnFileUpload(fileName);
    }

    @Если("^пользователь выбирает магазин \"([^\"]*)\"$")
    public void пользовательВыбираетМагазин(String shopName){
        PF.getPage(PriceUpload.class).clickOnShopSelect().clickOnShop(shopName);
    }

    @Если("^пользователь выбирает первую строку \"\\d+\"$")
    public void пользовательВыбираетПервуюСтроку(int a){
        PF.getPage(PriceUpload.class).clickOnFirstLinePlus(a);
    }

    @Если("^пользователь выбирает первый разделитель")
    public void пользовательВыбираетПервыйРазделитель(){
        PF.getPage(PriceUpload.class).clickOnDeviderSelect().clickOnFirstDevider();
    }

    @Если("^пользователь выбирает первый шаблон")
    public void пользовательВыбираетПервыйШаблон(){
        PF.getPage(PriceUpload.class).clickOnTemplateSelect().clickOnFirstTemplate();
    }

    @Если("^пользователь нажимает сохранить и отправить на обработку")
    public void пользовательНажимаетСохранитьИОтправитьНаОбработку(){
        PF.getPage(PriceUpload.class).clickOnSaveButton();
    }

}
