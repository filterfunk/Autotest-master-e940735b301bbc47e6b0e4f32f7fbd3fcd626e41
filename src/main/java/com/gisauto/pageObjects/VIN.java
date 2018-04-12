package com.gisauto.pageObjects;

import org.openqa.selenium.By;

public class VIN extends BasePage {

    private By vinInput = new By.ByXPath("//*[@id=\"customer_request_vin\"]"),
            checkVINButton = new By.ByXPath("//*[@id=\"vin-check\"]"),
            next1Button = new By.ByXPath("//*[@id=\"step-1\"]/div[8]/a\"]"),
            next2Button = new By.ByXPath("//*[@id=\"step-2\"]/a[2]"),
            next3Button = new By.ByXPath("//*[@id=\"form-submit\"]"),
            partNameInput = new By.ByXPath("//*[@id=\"customer_request_customerRequestElements_0_partName\"]"),
            typeButton = new By.ByXPath("//*[@id=\"part-container/div/div[3]/div[1]/div[1]/input\"]"),
            nameInput = new By.ByXPath("//*[@id=\"customer_request_customerName\"]"),
            emailInput = new By.ByXPath("//*[@id=\"customer_request_customerEmail\"]"),
            cityInput = new By.ByXPath("//*[@id=\"step-3\"]/div/div[1]/div[2]/div/div[1]/div[1]/input\"]");


    public VIN typeVIN(String vin) {
        inputText(getElement(vinInput), vin);
        return this;
    }

    public VIN clickVINCheckButton() {
        getElement(checkVINButton).click();
        return this;
    }

    public VIN clickOnNext1Button() {
        getElement(next1Button).click();
        return this;

    }

    public VIN typePartName(String text) {
        inputText(getElement(partNameInput), text);
        return this;

    }

    public VIN clickOnPartType(String text) {
        getElementFromSelect("//*[@id=\"part-container\"]/div/div[3]/div[1]/div[2]/ul/li[2]/label/span[text()=\"",
                "\"]",
                text,
                getElement(typeButton)).click();
        return this;
    }


    public VIN clickOnNext2Button() {
        getElement(next2Button).click();
        return this;

    }

    public VIN typeName(String text) {
        inputText(getElement(nameInput), text);
        return this;

    }

    public VIN typeEmail(String text) {
        inputText(getElement(emailInput), text);
        return this;
    }

    public VIN chooseCity(String text) {
        getElementFromSelect("//*[@id=\"step-3\"]/div/div[1]/div[2]/div/div[1]/div[2]/ul/li[3]/label[text()=\"", "\"]", text, getElement(cityInput)).click();
        return this;
    }

    public VIN clickOnNext3Button() {
        getElement(next3Button).click();
        return this;

    }

}
