package com.gisauto.pageObjects;

import org.openqa.selenium.By;

public class VIN extends BasePage {

    private By vinInput = new By.ByXPath("//*[@id=\"customer_request_vin\"]"),
            checkVINButton = new By.ByXPath("//*[@id=\"vin-check\"]"),
            nextButton = new By.ByXPath("//*a[@class=\"btn btn-next nav-btn\"]"),
            partNameInput = new By.ByXPath("//*[@id=\"customer_request_customerRequestElements_0_partName\"]"),
            typeButton = new By.ByXPath("//*[@id=\"part-container/div/div[3]/div[1]/div[1]/input\"]"),
            nameInput = new By.ByXPath("//*[@id=\"customer_request_customerName\"]"),
            emailInput = new By.ByXPath("//*[@id=\"customer_request_customerEmail\"]"),
            cityInput = new By.ByXPath("//*[@id=\"step-3\"]/div/div[1]/div[2]/div/div[1]/div[1]/input\"]");


    public VIN inputVIN(String vin) {
        inputText(getElement(vinInput), vin);
        return this;
    }

    public VIN clickVINCheckButton() {
        getElement(checkVINButton).click();
        return this;
    }

    public VIN clickOnPartType(String text) {
        getElementFromSelect("//*[@id=\"part-container\"]/div/div[3]/div[1]/div[2]/ul/li[2]/label/span[text()=\"",
                "\"]",
                text,
                getElement(typeButton)).click();
        return this;
    }

    public VIN nextButton() {
        getElement(nextButton).click();
        return this;
    }

    public VIN partNameInput(String text) {
        inputText(getElement(partNameInput), text);
        return this;

    }

    public VIN nameInput(String text) {
        inputText(getElement(nameInput), text);
        return this;

    }

    public VIN emailInput(String text) {
        inputText(getElement(emailInput), text);
        return this;
    }

    public VIN cityInput(String text) {
        getElementFromSelect("//*[@id=\"step-3\"]/div/div[1]/div[2]/div/div[1]/div[2]/ul/li[3]/label[text()=\"", "\"]", text, getElement(cityInput)).click();
        return this;
    }
}
