package com.gisauto.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TemplateSettings extends BasePage {

    private By templateNameInput = new By.ByXPath("//*[@id=\"item_import_template_title\"]"),
            firstLinePlus = new By.ByXPath("//*[@id=\"item_import_template_firstLine-styler\"]/div[3]"),
            numberSelect = new By.ByXPath("//*[@id=\"partTab\"]/form/div[3]/div/div/div[1]/div[1]/input"),
            manufacturerSelect = new By.ByXPath("//*[@id=\"partTab\"]/form/div[4]/div/div/div[1]/div[1]/input"),
            partNameSelect = new By.ByXPath("//*[@id=\"partTab\"]/form/div[5]/div/div[1]/div[1]/div[1]/input"),
            priceForUrSelect = new By.ByXPath("//*[@id=\"partTab\"]/form/div[6]/div/div[1]/div[1]/input"),
            priceForFizSelect = new By.ByXPath("//*[@id=\"partTab\"]/form/div[6]/div/div[1]/div[1]/input"),
            countSelect = new By.ByXPath("//*[@id=\"partTab\"]/form/div[11]/div/div/div[1]/input"),
            deliverySelect = new By.ByXPath("//*[@id=\"partTab\"]/form/div[12]/div[1]/div/div[1]/input"),
            saveButton = new By.ByXPath("//*[@id=\"partTab\"]/form/button"),
            tyresTemplate = new By.ByXPath("//*[@id=\"newUploadTemplateItem\"]/div/div/div[2]/div[2]/ul/li[2]/a"),
            tyresTemplateNameInput = new By.ByXPath("//*[@id=\"item_import_template_tyre_title\"]"),
            tyresFirstLinePlus = new By.ByXPath("//*[@id=\"item_import_template_tyre_firstLine-styler\"]/div[3]"),
            tyresNumberSelect = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[3]/div/div/div[1]/div[2]"),
            tyresManufacturerSelect = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[4]/div/div/div[1]/div[2]"),
            tyresModelSelect = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[5]/div/div/div[1]/div[1]/div[2]"),
            tyresNameInLineSelect = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[6]/div[1]/div/div/div[1]/div[1]/div[2]"),
            tyresMoreInfo = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[2]/div/div/div"),
            tyresShirina = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[1]/div[3]/div[1]/div/div/div[1]/div[1]/div[2]"),
            tyresProfile = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[2]"),
            tyresDiameter = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[1]/div[3]/div[3]/div/div/div[1]/div[1]/div[2]"),
            tyresOptPrice = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[8]/div/div[1]/div[1]/div[2]"),
            tyresRoznicaPrice = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[11]/div/div[1]/div[1]/div[2]"),
            tyresCount = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[13]/div/div/div[1]/div[2]"),
            tyresSaveButton = new By.ByXPath("//*[@id=\"tyreTab\"]/form/button"),
            tyresCloseMoreInfo = new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[1]/label"),
            closeModal = new By.ByXPath("//*[@id=\"newUploadTemplateItem\"]/div/div/div[1]/div");

    public TemplateSettings typeTemplateName(String name) {
        inputText(getElement(templateNameInput), name);
        return this;
    }

    public TemplateSettings clickOnFirstLinePlus(int count) {
        for (int i = 0; i < count; i++) {
            getElement(firstLinePlus).click();
        }
        return this;
    }

    public TemplateSettings chooseNumber(String text) {
        getElement(numberSelect).click();
        clickOnNumber(text);
        return this;
    }

    public TemplateSettings chooseManufacturer(String text) {
        getElement(manufacturerSelect).click();
        clickOnManufacturer(text);
        return this;
    }

    public TemplateSettings choosePartName(String text) {
        getElement(partNameSelect).click();
        clickOnPartName(text);
        return this;
    }

    public TemplateSettings choosePriceForUr(String text) {
        getElement(priceForUrSelect).click();
        clickOnPriceForUr(text);
        return this;
    }

    public TemplateSettings choosePriceForFiz(String text) {
        getElement(priceForFizSelect).click();
        clickOnPriceForFiz(text);
        return this;
    }

    public TemplateSettings chooseCount(String text) {
        getElement(countSelect).click();
        clickOnCount(text);
        return this;
    }

    public TemplateSettings chooseDelivery(String text) {
        getElement(deliverySelect).click();
        clickOnDelivery(text);
        return this;
    }

    public TemplateSettings clickOnSaveButton() {
        getElement(saveButton).click();
        return this;
    }

    private void clickOnNumber(String text) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[3]/div/div/div[1]/div[2]/ul/li[", "]", text);
        element.click();
    }

    private void clickOnManufacturer(String text) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[4]/div/div/div[1]/div[2]/ul/li[", "]", text);
        element.click();
    }

    private void clickOnPartName(String text) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[5]/div/div[1]/div[1]/div[2]/ul/li[", "]", text);
        element.click();
    }

    private void clickOnPriceForUr(String text) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[6]/div/div[1]/div[2]/ul/li[", "]", text);
        element.click();
    }

    private void clickOnPriceForFiz(String text) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[9]/div/div[1]/div[2]/ul/li[", "]", text);
        element.click();
    }

    private void clickOnCount(String text) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[11]/div/div/div[2]/ul/li[", "]", text);
        element.click();
    }

    private void clickOnDelivery(String text) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[12]/div[1]/div/div[2]/ul/li[", "]", text);
        element.click();
    }

    public TemplateSettings typeDelivery(String text) {
        inputText(getElement(deliverySelect), text);
        return this;
    }

    public TemplateSettings clickOnEditTemplate(String templateName) {
        WebElement element = getElementFromSelect("//*[@id=\"newUploadTemplateItem\"]/div/div/div[2]/div[1]/div/div[2]/table/tbody/tr[", "]/td[1]/div[2]", templateName);
        element.click();
        return this;
    }

    public TemplateSettings clickOnDeleteTemplate(String templateName) {
        WebElement element = getElementFromSelect("//*[@id=\"newUploadTemplateItem\"]/div/div/div[2]/div[1]/div/div[2]/table/tbody/tr[", "]/td[1]/div[2]", templateName);
        element.click();
        return this;
    }

    public TemplateSettings clickOnTyreType() {
        getElement(tyresTemplate).click();
        return this;
    }

    public TemplateSettings typeTyresTemplateName(String templateName) {
        inputText(getElement(tyresTemplateNameInput), templateName);
        return this;
    }

    public TemplateSettings clickOnTyresFirstLine(int count) {
        for (int i = 0; i < count; i++) {
            getElement(tyresFirstLinePlus).click();
        }
        return this;
    }

    public TemplateSettings chooseTyresNumber(String text) {
        getElement(tyresNumberSelect).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[3]/div/div/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    public TemplateSettings chooseTyresManufacturer(String text) {
        getElement(tyresManufacturerSelect).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[4]/div/div/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    public TemplateSettings chooseTyresModel(String text) {
        getElement(tyresModelSelect).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[5]/div/div/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    public TemplateSettings chooseTyresNameInLine(String text) {
        getElement(tyresNameInLineSelect).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[6]/div/div/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    public TemplateSettings clickOnMoreInfo() {
        getElement(tyresMoreInfo).click();
        return this;
    }

    public TemplateSettings chooseTyresShirina(String text) {
        getElement(tyresShirina).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[1]/div[3]/div[1]/div/div/div[1]/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    public TemplateSettings chooseTyresProfile(String text) {
        getElement(tyresProfile).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    public TemplateSettings chooseTyresDiameter(String text) {
        getElement(tyresDiameter).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[1]/div[3]/div[3]/div/div/div[1]/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    private TemplateSettings sykaYaEbalKostil() {
        getElement(new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[3]/label")).click();
        return this;
    }

    public TemplateSettings chooseTyresOptPrice(String text) {
        sykaYaEbalKostil();
        getElement(tyresOptPrice).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[8]/div/div[1]/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    public TemplateSettings chooseTyresRoznicaPrice(String text) {
        getElement(tyresRoznicaPrice).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[11]/div/div[1]/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    public TemplateSettings chooseTyresCount(String text) {
        getElement(tyresCount).click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[13]/div/div/div[2]/ul/li[", "]/label", text).click();
        return this;
    }

    public TemplateSettings clickOnTyresSaveButton() {
        getElement(tyresSaveButton).click();
        return this;
    }

    public TemplateSettings closeMoreInfo(){
        getElement(tyresCloseMoreInfo).click();
        return this;
    }

    public TemplateSettings closeModal(){
        getElement(closeModal).click();
        return this;
    }

}
