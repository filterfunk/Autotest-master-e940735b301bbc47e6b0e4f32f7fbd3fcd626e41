package com.gisauto.stepdefs;

import com.gisauto.pageObjects.gisauto.PriceUpload;
import com.gisauto.pageObjects.gisauto.TemplateSettings;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class PriceUploadStepDefs {

    @Если("^пользователь нажимает ручная загрузка")
    public void пользовательНажимаетРучнаяЗагрузка() {
        PF.getPage(PriceUpload.class).clickOnManualUploadButton();
    }

    @Если("^пользователь нажимает выбрать файл \"([^\"]*)\"$")
    public void пользовательНажимаетВыбратьФайл(String fileName) {
        PF.getPage(PriceUpload.class).clickOnFileUpload(fileName);
    }

    @Если("^пользователь выбирает первую строку \"\\d+\"$")
    public void пользовательВыбираетПервуюСтроку(int a) {
        PF.getPage(PriceUpload.class).clickOnFirstLinePlus(a);
    }

    @Если("^пользователь выбирает первый разделитель")
    public void пользовательВыбираетПервыйРазделитель() {
        PF.getPage(PriceUpload.class).clickOnDeviderSelect().clickOnFirstDevider();
    }

    @Если("^пользователь выбирает первый шаблон")
    public void пользовательВыбираетПервыйШаблон() {
        PF.getPage(PriceUpload.class).clickOnTemplateSelect().clickOnFirstTemplate();
    }

    @Если("^пользователь нажимает сохранить и отправить на обработку")
    public void пользовательНажимаетСохранитьИОтправитьНаОбработку() {
        PF.getPage(PriceUpload.class).clickOnSaveButton();
    }

    @Если("^пользователь нажимает настройка шаблонов")
    public void пользовательНажимаетНастройкаШаблонов() {
        PF.getPage(PriceUpload.class).clickOnTemplateSettings();
    }

    @Если("^пользователь вводит название шаблона \"([^\"]*)\"$")
    public void пользовательВводитНазваниеШаблона(String templateName) {
        PF.getPage(TemplateSettings.class).typeTemplateName(templateName);
    }

    @Если("^пользователь выбирает первую строку шаблона (\\d+)$")
    public void пользовательВыбираетПервуюСтрокуШаблона(int count) {
        PF.getPage(TemplateSettings.class).clickOnFirstLinePlus(count);
    }

    @Если("^пользоваетль выбирает номер \"([^\"]*)\" шаблона$")
    public void пользовательВыбираетНомер(String num) {
        PF.getPage(TemplateSettings.class).chooseNumber(num);
    }

    @Если("^пользователь выбирает производителя \"([^\"]*)\"$")
    public void пользовательВыбираетПроизводителя(String manufacturer) {
        PF.getPage(TemplateSettings.class).chooseManufacturer(manufacturer);
    }

    @Если("^пользователь выбирает наименование \"([^\"]*)\"$")
    public void пользовательВыбираетНаименование(String name) {
        PF.getPage(TemplateSettings.class).choosePartName(name);
    }

    @Если("^пользователь выбирает оптовую цену \"([^\"]*)\"$")
    public void пользовательВыбираетОптовуюЦену(String price) {
        PF.getPage(TemplateSettings.class).choosePriceForUr(price);
    }

    @Если("^пользователь выбирает розничную цену \"([^\"]*)\"$")
    public void пользовательВыбираетРозничнуюЦену(String price) {
        PF.getPage(TemplateSettings.class).choosePriceForFiz(price);
    }

    @Если("^пользователь выбирает количество \"([^\"]*)\"$")
    public void пользовательВыбираетКоличество(String count) {
        PF.getPage(TemplateSettings.class).chooseCount(count);
    }

    @Если("^пользователь выбирает срок поставки \"([^\"]*)\"$")
    public void пользовательВыбираетСрокПоставки(String delivery) {
        PF.getPage(TemplateSettings.class).chooseDelivery(delivery);
    }

    @Если("^пользователь вводит срок поставки \"([^\"]*)\"$")
    public void пользовательВводитСрокПоставки(String delivery) {
        PF.getPage(TemplateSettings.class).typeDelivery(delivery);
    }

    @Если("^пользователь нажимает сохранить$")
    public void пользовательНажимаетСохранить() {
        PF.getPage(TemplateSettings.class).clickOnSaveButton();
    }

    @Если("^пользователь нажимает история$")
    public void пользовательНажимаетИстория() {
        PF.getPage(PriceUpload.class).clickOnUploadHistory();
    }

    @Если("^пользователь выбирает тип ручной загрузки \"([^\"]*)\"$")
    public void пользовательВыбираетТипРучнойЗагрузки(String type) {
        PF.getPage(PriceUpload.class).chooseTypeOfManualUpload(type);
    }

}
