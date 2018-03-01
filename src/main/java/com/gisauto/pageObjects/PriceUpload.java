package com.gisauto.pageObjects;

import com.gisauto.utils.FileUploader;
import com.gisauto.utils.PF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PriceUpload extends BasePage {

    private By manualUploadButton = new By.ByXPath("//*[@id=\"mainWin\"]/div[2]/div[1]/div/button[3]"),
            fileUpload = new By.ByXPath("//*[@id=\"item_import_hand_upload_itemImport_sourceFileTmp\"]"),
            shopSelect = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[2]/div/div[1]/div[1]/input"),
            firstLinePlus = new By.ByXPath("//*[@id=\"item_import_template_firstLine-styler\"]/div[3]"),
            deviderSelect = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[3]/div[3]/div[2]/div/div[1]/div[1]/input"),
            firstDevider = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[3]/div[3]/div[2]/div/div[1]/div[2]/ul/li[1]"),
            secondDevider = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[3]/div[3]/div[2]/div/div[1]/div[2]/ul/li[2]"),
            thirdDevider = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[3]/div[3]/div[2]/div/div[1]/div[2]/ul/li[3]"),
            templateSelect = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[4]/div[1]/div/div[1]/input"),
            firstTemplate = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[4]/div[1]/div/div[2]/ul/li[1]"),
            createTemplateButton = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[4]/div[1]/button"),
            currencySelect = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[4]/div[2]/div[1]/div[1]/div[1]/input"),
            saveButton = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/button"),
            createUpolad = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/button"),
            templateSettings = new By.ByXPath("//*[@id=\"mainWin\"]/div[2]/div[1]/div/button[2]"),
            uploadHistory = new By.ByXPath("//*[@id=\"mainWin\"]/div[1]/ul/li[2]/a"),
            manualTypeTyres = new By.ByXPath("//*[@id=\"handUpload\"]/div/div/div[1]/ul/li[2]/a");

    public AutoUpload clickOnCreateUpload() {
        await(1500);
        getElement(createUpolad).click();
        return PF.getPage(AutoUpload.class);
    }

    public PriceUpload clickOnManualUploadButton() {
        getElement(manualUploadButton).click();
        return this;
    }

    public PriceUpload clickOnFileUpload(String file) {
        getElement(fileUpload).click();
        FileUploader.uploadFile(file);
        return this;
    }

    public PriceUpload clickOnShopSelect() {
        getElement(shopSelect).click();
        return this;
    }

    public PriceUpload clickOnFirstLinePlus(int times) {
        for (int i = 0; i < times; i++)
            getElement(firstLinePlus).click();
        return this;
    }

    public PriceUpload clickOnDeviderSelect() {
        getElement(deviderSelect).click();
        return this;
    }

    public PriceUpload clickOnFirstDevider() {
        getElement(firstDevider).click();
        return this;
    }

    public PriceUpload clickOnSecondDevider() {
        getElement(secondDevider).click();
        return this;
    }

    public PriceUpload clickOnThirdDevider() {
        getElement(thirdDevider).click();
        return this;
    }

    public PriceUpload clickOnTemplateSelect() {
        getElement(templateSelect).click();
        return this;
    }

    public PriceUpload clickOnFirstTemplate() {
        getElement(firstTemplate).click();
        return this;
    }

    public PriceUpload clickOnCreateTemplateButton() {
        getElement(createTemplateButton).click();
        return this;
    }

    public PriceUpload clickOnCurrencySelect() {
        getElement(currencySelect).click();
        return this;
    }

    public PriceUpload clickOnSaveButton() {
        getElement(saveButton).click();
        return this;
    }

    public TemplateSettings clickOnTemplateSettings() {
        getElement(templateSettings).click();
        return PF.getPage(TemplateSettings.class);
    }

    public UploadHistory clickOnUploadHistory(){
        getElement(uploadHistory).click();
        return PF.getPage(UploadHistory.class);
    }

    public PriceUpload chooseTypeOfManualUpload(String type){
        if (type.toLowerCase().trim().equals("запчасти")){
            return this;
        } else if (type.toLowerCase().trim().equals("шины")){
            getElement(manualTypeTyres).click();
            return this;
        } else {
            throw new RuntimeException("Неизвестный тип загрузки.");
        }
    }

}
