package com.gisauto.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VIN extends BasePage {

    private By vinInput = new By.ByXPath("//*[@id=\"customer_request_vin\"]"),
            checkVINButton = new By.ByXPath("//*[@id=\"vin-check\"]"),
            nextButton = new By.ByXPath("//a[@class=\"btn btn-next nav-btn disabled\"]"),
            partNameInput = new By.ByXPath("//*[@id=\"customer_request_customerRequestElements_0_partName\"]"),
            typeButton = new By.ByXPath("//*[@id=\"part-container\"]/div/div[3]/div[1]/div[1]/input"),
            nameInput = new By.ByXPath("//*[@id=\"customer_request_customerName\"]"),
            emailInput = new By.ByXPath("//*[@id=\"customer_request_customerEmail\"]"),
            cityInput = new By.ByXPath("//*[@id=\"step-3\"]/div/div[1]/div[2]/div/div[1]/div[1]/input"),
            sendRequest = new By.ByXPath("//*[@id=\"form-submit\"]");


    List<WebElement> a;

    public VIN typeVIN(String vin) {
        inputText(getElement(vinInput), vin);
        a = getElements(nextButton);
        return this;
    }

    public VIN clickVINCheckButton() {
        getElement(checkVINButton).click();
        return this;
    }

    public VIN clickOnPartType(String text) {
        getElementFromSelect("//*[@id=\"part-container\"]//span[text()=\"",
                "\"]",
                text,
                getElement(typeButton)).click();
        return this;
    }

    public VIN clickOnNextButton() {
        await(500);
        a.get(0).click();
        a.remove(0);
        return this;
    }

    public VIN typePartName(String text) {
        inputText(getElement(partNameInput), text);
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
        await(1000);
        getElementFromSelect("//*[@id=\"step-3\"]//span[text()=\"", "\"]", text, getElement(cityInput)).click();
        return this;
    }
    public VIN clickOnSendRequest() {
        getElement(sendRequest).click();
        return this;
    }
}
