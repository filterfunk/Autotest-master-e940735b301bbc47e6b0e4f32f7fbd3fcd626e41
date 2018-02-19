package com.gisauto.stepdefs;

import com.gisauto.pageObjects.AutoUpload;
import com.gisauto.pageObjects.PriceUpload;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class AutoUploadStepDefs {

    @Если("^пользователь нажимает создать загрузку$")
    public void пользовательНажимаетСоздатьЗагрузку() {
        PF.getPage(PriceUpload.class).clickOnCreateUpload();
    }

    @Если("^пользователь выбирает тип загрузки \"([^\"]*)\"$")
    public void пользовательВыбираетТипЗагрузки(String uploadType) {
        PF.getPage(AutoUpload.class).clickOnUploadType(uploadType);
    }

    @Если("^пользователь вводит имя файла \"([^\"]*)\" email$")
    public void пользовательВводитИмяФайлаEmail(String fileName) {
        PF.getPage(AutoUpload.class).typeEmailFileName(fileName);
    }

    @Если("^пользователь вводит электронную почту \"([^\"]*)\" email$")
    public void пользовательВводитЭлектроннуюПочтуEmail(String email) {
        PF.getPage(AutoUpload.class).typeAutoUploadEmail(email);
    }

    @Если("^пользователь вводит имя файла \"([^\"]*)\" ftp$")
    public void пользовательВводитИмяФайлаFTP(String fileName) {
        PF.getPage(AutoUpload.class).typeFTPFileName(fileName);
    }

    @Если("^пользователь вводит адрес ссылки \"([^\"]*)\"$")
    public void пользовательВводитАдресСсылки(String url) {
        PF.getPage(AutoUpload.class).typeLinkAdress(url);
    }

    @Если("^пользотвалье выбирает частоту обновления \"([^\"]*)\" для \"([^\"]*)\" типа загрузки^")
    public void пользовательВыбраетЧастотуОбновления(String refreshRate, String uploadType) {
        PF.getPage(AutoUpload.class)
                .clickOnRefreshRateSelect(
                        uploadType
                                .toLowerCase()
                                .equals("ftp"),
                        refreshRate);
    }

    @Если("^пользователь выбирает магазин \"([^\"]*)\" автозагрзуки$")
    public void пользовательВыбираетМагазин(String shopName) {
        PF.getPage(AutoUpload.class).clickOnShopSelect(shopName);
    }

    @Если("^пользователь выбирает шаблон \"([^\"]*)\" автозагрузки$")
    public void пользовательВыбираетШаблон(String templateName) {
        PF.getPage(AutoUpload.class).clickOnTemplateSelect(templateName);
    }

    @Если("^пользователь нажимает создать$")
    public void пользовательНажимаетСоздать() {
        PF.getPage(AutoUpload.class).clickOnCreateButton();
    }

    @Если("^пользователь создает шаблон для шин$")
    public void пользовательСоздаетШаблонДляШин(){

    }

    @Если("^пользователь создает шаблон для запчастей")
    public void пользовательСоздаетШаблонДляЗапчастей(){

    }

}
