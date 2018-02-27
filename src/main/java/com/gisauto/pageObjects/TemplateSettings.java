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
        await(300);
        getElement(numberSelect).click();
        clickOnNumber(text, getElement(numberSelect));
        return this;
    }

    public TemplateSettings chooseManufacturer(String text) {
        await(300);
        getElement(manufacturerSelect).click();
        clickOnManufacturer(text, getElement(manufacturerSelect));
        return this;
    }

    public TemplateSettings choosePartName(String text) {
        await(300);
        getElement(partNameSelect).click();
        clickOnPartName(text, getElement(partNameSelect));
        return this;
    }

    public TemplateSettings choosePriceForUr(String text) {
        await(300);
        getElement(priceForUrSelect).click();
        clickOnPriceForUr(text, getElement(priceForUrSelect));
        return this;
    }

    public TemplateSettings choosePriceForFiz(String text) {
        await(300);
        getElement(priceForFizSelect).click();
        clickOnPriceForFiz(text, getElement(priceForFizSelect));
        return this;
    }

    public TemplateSettings chooseCount(String text) {
        await(300);
        getElement(countSelect).click();
        clickOnCount(text, getElement(countSelect));
        return this;
    }

    public TemplateSettings chooseDelivery(String text) {
        await(300);
        getElement(deliverySelect).click();
        clickOnDelivery(text, getElement(deliverySelect));
        return this;
    }

    public TemplateSettings clickOnSaveButton() {
        await(300);
        getElement(saveButton).click();
        return this;
    }

    private void clickOnNumber(String text, WebElement select) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[3]//span[text()=\"", "\"]", text, select);
        element.click();
    }

    private void clickOnManufacturer(String text, WebElement select) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[4]//span[text()=\"", "\"]", text, select);
        element.click();
    }

    private void clickOnPartName(String text, WebElement select) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[5]//span[text()=\"", "\"]", text, select);
        element.click();
    }

    private void clickOnPriceForUr(String text, WebElement select) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[6]//span[text()=\"", "\"]", text, select);
        element.click();
    }

    private void clickOnPriceForFiz(String text, WebElement select) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[9]//span[text()=\"", "\"]", text, select);
        element.click();
    }

    private void clickOnCount(String text, WebElement select) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[11]//span[text()=\"", "\"]", text, select);
        element.click();
    }

    private void clickOnDelivery(String text, WebElement select) {
        WebElement element = getElementFromSelect("//*[@id=\"partTab\"]/form/div[9]//span[text()=\"", "\"]", text, select);
        element.click();
    }

    public TemplateSettings typeDelivery(String text) {
        inputText(getElement(deliverySelect), text);
        return this;
    }

    public TemplateSettings clickOnTyreType() {
        await(300);
        getElement(tyresTemplate).click();
        return this;
    }

    public TemplateSettings typeTyresTemplateName(String templateName) {
        await(300);
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
        await(300);
        WebElement select = getElement(tyresNumberSelect);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[3]//span[text()=\"", "\"]", text, select).click();
        return this;
    }

    public TemplateSettings chooseTyresManufacturer(String text) {
        await(300);
        WebElement select = getElement(tyresManufacturerSelect);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[4]//span[text()=\"", "\"]", text, select).click();
        return this;
    }

    public TemplateSettings chooseTyresModel(String text) {
        await(300);
        WebElement select = getElement(tyresModelSelect);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[5]//span[text()=\"", "\"]", text, select).click();
        return this;
    }

    public TemplateSettings chooseTyresNameInLine(String text) {
        await(300);
        WebElement select = getElement(tyresNameInLineSelect);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[6]//span[text()=\"", "\"]", text, select).click();
        return this;
    }

    public TemplateSettings clickOnMoreInfo() {
        await(300);
        getElement(tyresMoreInfo).click();
        return this;
    }

    public TemplateSettings chooseTyresShirina(String text) {
        await(300);
        WebElement select = getElement(tyresShirina);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[1]/div[3]/div[1]/div/div/div[1]/div[2]/ul/li[", "]/label", text, select).click();
        return this;
    }

    public TemplateSettings chooseTyresProfile(String text) {
        await(300);
        WebElement select = getElement(tyresProfile);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/ul/li[", "]/label", text, select).click();
        return this;
    }

    public TemplateSettings chooseTyresDiameter(String text) {
        await(300);
        WebElement select = getElement(tyresDiameter);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[6]/div[3]/div[1]/div[3]/div[3]/div/div/div[1]/div[2]/ul/li[", "]/label", text, select).click();
        return this;
    }

    private TemplateSettings sykaYaEbalKostil() {
        getElement(new By.ByXPath("//*[@id=\"tyreTab\"]/form/div[3]/label")).click();
        return this;
    }

    public TemplateSettings chooseTyresOptPrice(String text) {
        await(300);
        sykaYaEbalKostil();
        WebElement select = getElement(tyresOptPrice);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[8]//span[text()=\"", "]/label", text, select).click();
        return this;
    }

    public TemplateSettings chooseTyresRoznicaPrice(String text) {
        await(300);
        WebElement select = getElement(tyresRoznicaPrice);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[11//span[text()=\"", "]/label", text, select).click();
        return this;
    }

    public TemplateSettings chooseTyresCount(String text) {
        await(300);
        WebElement select = getElement(tyresCount);
        select.click();
        getElementFromSelect("//*[@id=\"tyreTab\"]/form/div[13]//span[text()=\"", "]/label", text, select).click();
        return this;
    }

    public TemplateSettings clickOnTyresSaveButton() {
        await(300);
        getElement(tyresSaveButton).click();
        return this;
    }

    public TemplateSettings closeMoreInfo() {
        await(300);
        getElement(tyresCloseMoreInfo).click();
        return this;
    }

    public TemplateSettings closeModal() {
        getElement(closeModal).click();
        return this;
    }

}
