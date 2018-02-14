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
            saveButton = new By.ByXPath("//*[@id=\"partTab\"]/form/button");

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

    public TemplateSettings chooseManufacturer(String text){
        getElement(manufacturerSelect).click();
        clickOnManufacturer(text);
        return this;
    }

    public TemplateSettings choosePartName(String text){
        getElement(partNameSelect).click();
        clickOnPartName(text);
        return this;
    }

    public TemplateSettings choosePriceForUr(String text){
        getElement(priceForUrSelect).click();
        clickOnPriceForUr(text);
        return this;
    }

    public TemplateSettings choosePriceForFiz(String text){
        getElement(priceForFizSelect).click();
        clickOnPriceForFiz(text);
        return this;
    }

    public TemplateSettings chooseCount(String text){
        getElement(countSelect).click();
        clickOnCount(text);
        return this;
    }

    public TemplateSettings chooseDelivery(String text){
        getElement(deliverySelect).click();
        clickOnDelivery(text);
        return this;
    }

    public TemplateSettings clickOnSaveButton(){
        getElement(saveButton).click();
        return this;
    }

    private void clickOnNumber(String text) {
        int i = 1;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"partTab\"]/form/div[3]/div/div/div[1]/div[2]/ul/li[" + i + "]"));
        } while (!element.getText().equals(text));
        element.click();
    }

    private void clickOnManufacturer(String text) {
        int i = 1;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"partTab\"]/form/div[4]/div/div/div[1]/div[2]/ul/li[" + i + "]"));
        } while (!element.getText().equals(text));
        element.click();
    }

    private void clickOnPartName(String text) {
        int i = 1;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"partTab\"]/form/div[5]/div/div[1]/div[1]/div[2]/ul/li[" + i + "]"));
        } while (!element.getText().equals(text));
        element.click();
    }

    private void clickOnPriceForUr(String text) {
        int i = 1;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"partTab\"]/form/div[6]/div/div[1]/div[2]/ul/li[" + i + "]"));
        } while (!element.getText().equals(text));
        element.click();
    }

    private void clickOnPriceForFiz(String text) {
        int i = 1;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"partTab\"]/form/div[9]/div/div[1]/div[2]/ul/li[" + i + "]"));
        } while (!element.getText().equals(text));
        element.click();
    }

    private void clickOnCount(String text) {
        int i = 1;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"partTab\"]/form/div[11]/div/div/div[2]/ul/li[" + i + "]"));
        } while (!element.getText().equals(text));
        element.click();
    }

    private void clickOnDelivery(String text) {
        int i = 1;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"partTab\"]/form/div[12]/div[1]/div/div[2]/ul/li[" + i + "]"));
        } while (!element.getText().equals(text));
        element.click();
    }

    public TemplateSettings typeDelivery(String text){
        inputText(getElement(deliverySelect), text);
        return this;
    }

    public TemplateSettings clickOnEditTemplate(String templateName){
        int i = 1;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"newUploadTemplateItem\"]/div/div/div[2]/div[1]/div/div[2]/table/tbody/tr[" + i + "]/td[1]/div[2]"));
        } while (!element.getText().equals(templateName));
        getElement(new By.ByXPath("//*[@id=\\\"newUploadTemplateItem\\\"]/div/div/div[2]/div[1]/div/div[2]/table/tbody/tr[" + i + "]/td[2]/div/div[1]/button")).click();
        return this;
    }

    public TemplateSettings clickOnDeleteTemplate(String templateName){
        int i = 1;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"newUploadTemplateItem\"]/div/div/div[2]/div[1]/div/div[2]/table/tbody/tr[" + i + "]/td[1]/div[2]"));
        } while (!element.getText().equals(templateName));
        getElement(new By.ByXPath("//*[@id=\"newUploadTemplateItem\"]/div/div/div[2]/div[1]/div/div[2]/table/tbody/tr[" + i + "]/td[2]/div/div[2]/button")).click();
        return this;
    }

}
