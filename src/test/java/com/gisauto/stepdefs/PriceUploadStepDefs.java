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

    @Если("^пользователь нажимает настройка шаблонов")
    public void пользовательНажимаетНастройкаШаблонов(){
        PF.getPage(PriceUpload.class).clickOnTemplateSettings();
    }

    @Если("^пользователь вводит название шаблона \"([^\"]*)\"$")
    public void пользовательВводитНазваниеШаблона(String templateName){
        PF.getPage(PriceUpload.TemplateSettings.class).typeTemplateName(templateName);
    }

    @Если("^пользователь выбирает первую строку шаблона (\\d+)$")
    public void пользовательВыбираетПервуюСтрокуШаблона(int count){
        PF.getPage(PriceUpload.TemplateSettings.class).clickOnFirstLinePlus(count);
    }

    @Если("^пользоваетль выбирает номер \"([^\"]*)\" шаблона$")
    public void пользовательВыбираетНомер(String num){
        PF.getPage(PriceUpload.TemplateSettings.class).chooseNumber(num);
    }

    @Если("^пользователь выбирает производителя \"([^\"]*)\"$")
    public void пользовательВыбираетПроизводителя(String manufacturer){
        PF.getPage(PriceUpload.TemplateSettings.class).chooseManufacturer(manufacturer);
    }

    @Если("^пользователь выбирает наименование \"([^\"]*)\"$")
    public void пользовательВыбираетНаименование(String name){
        PF.getPage(PriceUpload.TemplateSettings.class).choosePartName(name);
    }

    @Если("^пользователь выбирает оптовую цену \"([^\"]*)\"$")
    public void пользовательВыбираетОптовуюЦену(String price){
        PF.getPage(PriceUpload.TemplateSettings.class).choosePriceForUr(price);
    }

    @Если("^пользователь выбирает розничную цену \"([^\"]*)\"$")
    public void пользовательВыбираетРозничнуюЦену(String price){
        PF.getPage(PriceUpload.TemplateSettings.class).choosePriceForFiz(price);
    }

    @Если("^пользователь выбирает количество \"([^\"]*)\"$")
    public void пользовательВыбираетКоличество(String count){
        PF.getPage(PriceUpload.TemplateSettings.class).chooseCount(count);
    }

    @Если("^пользователь выбирает срок поставки \"([^\"]*)\"$")
    public void пользовательВыбираетСрокПоставки(String delivery){
        PF.getPage(PriceUpload.TemplateSettings.class).chooseDelivery(delivery);
    }

    @Если("^пользователь вводит срок поставки \"([^\"]*)\"$")
    public void пользовательВводитСрокПоставки(String delivery){
        PF.getPage(PriceUpload.TemplateSettings.class).typeDelivery(delivery);
    }

    @Если("^пользователь нажимает сохранить")
    public void пользовательНажимаетСохранить(){
        PF.getPage(PriceUpload.TemplateSettings.class).clickOnSaveButton();
    }

}
