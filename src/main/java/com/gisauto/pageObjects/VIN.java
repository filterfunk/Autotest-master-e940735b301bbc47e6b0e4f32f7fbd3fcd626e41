package com.gisauto.pageObjects;

import com.gisauto.utils.PF;
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
            sendRequest = new By.ByXPath("//*[@id=\"form-submit\"]"),
            dontKnowVinButton = new By.ByXPath("//*[@id=\"step-1\"]/div[7]"),
            brandButton = new By.ByXPath("//*[@id=\"step-1\"]/div[8]/div[1]/div/div[1]/div[1]/input"),
            modelButton = new By.ByXPath("//*[@id=\"step-1\"]/div[8]/div[2]/div/div[1]/div[1]/input"),
            yearInput = new By.ByXPath("//*[@id=\"customer_request_releaseYear\"]"),
            register = new By.ByXPath("//*[@id=\"step_3_reg\"]"),
            passwordInput = new By.ByXPath("//*[@id=\"registration_user_password\"]"),
            individual = new By.ByXPath("//*[@id=\"minFormRegistration\"]/div[2]/div[5]/label"),
            legalEntity = new By.ByXPath("//*[@id=\"minFormRegistration\"]/div[2]/div[6]/label"),
            doneRegister = new By.ByXPath("//*[@id=\"minFormRegistration\"]/div[2]/button"),
            login = new By.ByXPath("//*[@id=\"step_3_auth\"]"),
            loginPassInput = new By.ByXPath("//*[@id=\"password\"]"),
            loginButton = new By.ByXPath("//*[@id=\"formLogin-modal\"]/button");


    List<WebElement> a;

    public VIN() {
        super();
        a = getElements(nextButton);
    }

    public VIN typeVIN(String vin) {
        inputText(getElement(vinInput), vin);
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

    public VIN clickOnDontKnowVinButton() {
        getElement(dontKnowVinButton).click();
        return this;
    }

    public VIN chooseBrand(String text) {
        getElementFromSelect("//*[@id=\"step-1\"]//span[text()=\"",
                "\"]",
                text,
                getElement(brandButton)).click();
        return this;
    }

    public VIN chooseModel(String text) {
        getElementFromSelect("//*[@id=\"step-1\"]//span[text()=\"",
                "\"]",
                text,
                getElement(modelButton)).click();
        return this;
    }

    public VIN typeYear(String year) {
        inputText(getElement(yearInput), year);
        return this;
    }

    public VIN clickOnRegisterVIN() {
        await(1500);
        getElement(register).click();
        return this;
    }

    public VIN chooseFiz() {
        getElement(individual).click();
        return this;
    }

    public Profile clickOnRegisterDone() {
        getElement(doneRegister).click();
        return PF.getPage(Profile.class);
    }

    @Override
    public VIN typePassword(String pass) {
        inputText(getElement(passwordInput), pass);
        return this;
    }

    public VIN clickOnLogIn() {
        getElement(login).click();
        return this;
    }

    public VIN typePasswordLogin(String pass) {
        inputText(getElement(loginPassInput), pass);
        return this;
    }

    public VIN clickOnLoginButton() {
        getElement(loginButton).click();
        return this;
    }
}