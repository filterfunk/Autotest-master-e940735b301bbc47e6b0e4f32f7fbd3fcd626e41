package com.gisauto.pageObjects;

import com.gisauto.utils.FileUploader;
import com.gisauto.utils.PF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PriceUpload extends BasePage {

    private By manualUploadButton = new By.ByXPath("//*[@id=\"mainWin\"]/div[2]/div[1]/div/button[3]"),
            fileUpload = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[1]/div[1]/div/div[1]"),
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
            templateSettings = new By.ByXPath("//*[@id=\"mainWin\"]/div[2]/div[1]/div/button[2]"),
            createUploadButton = new By.ByXPath("//*[@id=\"mainWin\"]/div[2]/div[1]/div/button[1]"),
            uploadByEmail = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[2]/div[2]/ul/li[1]/a/button"),
            uploadByFTP = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[2]/div[2]/ul/li[3]/a/button"),
            uploadByLink = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[2]/div[2]/ul/li[4]/a/button"),
            fileNameInput = new By.ByXPath("//*[@id=\"item_autoload_emailFileName\"]"),
            email = new By.ByXPath("//*[@id=\"item_autoload_email\"]"),
            shopMultiSelect = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[1]/div/div/div[1]/div[2]"),
            templateMultiSelect = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[2]/div/div/div[1]/div[2]");

    public PriceUpload clickOnCreateUploadButton() {
        getElement(createUploadButton).click();
        return this;
    }

    public PriceUpload clickOnUploadByEmail() {
        getElement(uploadByEmail).click();
        return this;
    }

    public PriceUpload clickOnUploadByFTP() {
        getElement(uploadByFTP).click();
        return this;
    }

    public PriceUpload clickOnUploadByLink() {
        getElement(uploadByLink).click();
        return this;
    }

    public PriceUpload inputFileName(String text) {
        getElement(fileNameInput).sendKeys(text);
        return this;
    }

    public PriceUpload inputEmail(String text) {
        getElement(email).sendKeys(text);
        return this;
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

    public PriceUpload clickOnShop(String shopName) {
        getShopFromSelector(shopName).click();
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

    private WebElement getShopFromSelector(String shopName) {
        int i = 0;
        WebElement element = null;
        do {
            i++;
            element = getElement(new By.ByXPath("\"//*[@id=\\\"parts-hand\\\"]/div/form/div[2]/div/div[1]/div[2]/ul/li[" + i + "]\""));
        }
        while (element.getText().equals(shopName));
        return element;
    }

    public TemplateSettings clickOnTemplateSettings() {
        getElement(templateSettings).click();
        return PF.getPage(TemplateSettings.class);
    }

    public PriceUpload clickOnShopFromSelect(String shopName){
        getShopFromMultiSelect(shopName).click();
        return this;
    }

    private WebElement getShopFromMultiSelect(String shopName) {
        int i = 0;
        WebElement element = null;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[1]/div/div/div[2]/ul/li[" + i + "]/label"));
        }
        while (element.getText().equals(shopName));
        return element;
    }

}
