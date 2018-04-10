package com.gisauto.pageObjects;

import org.openqa.selenium.By;

public class VIN extends BasePage {

    private By vinInput = new By.ByXPath("//*[@id=\"customer_request_vin\"]"),
            checkVINButton = new By.ByXPath("//*[@id=\"vin-check\"]"),
            checkNextButton = new By.ByXPath("//*a[@class=\"btn btn-next nav-btn\"]"),
            partNameInput = new By.ByXPath("//*[@id=\"customer_request_customerRequestElements_0_partName\"]");


    public VIN inputVIN(String vin) {
        inputText(getElement(vinInput), vin);
        return this;
    }

    public VIN clickVINCheckButton() {
        getElement(checkVINButton).click();
        return this;
    }


}
