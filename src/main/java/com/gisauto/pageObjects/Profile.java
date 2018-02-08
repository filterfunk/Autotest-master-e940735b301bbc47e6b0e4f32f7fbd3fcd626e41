package com.gisauto.pageObjects;

import com.gisauto.utils.PF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Profile extends BasePage {

    private By.ByXPath searchByNumber = new By.ByXPath("/html/body/div[1]/div[1]/nav/ul/li[1]"),
            sunameInput = new By.ByXPath("//*[@id=\"user_profile_form_userProfile_lastName\"]"),
            nameInput = new By.ByXPath("//*[@id=\"user_profile_form_userProfile_firstName\"]"),
            secondNameInput = new By.ByXPath("//*[@id=\"user_profile_form_userProfile_middleName\"]"),
            phoneInput = new By.ByXPath("//*[@id=\"user_profile_form_userProfile_phone\"]"),
            citySelect = new By.ByXPath("//*[@id=\"formSaveReg\"]/div[1]/div[1]/fieldset/div[5]/div/div/div[1]/div[1]/input"),
            firstCity = new By.ByXPath("//*[@id=\"formSaveReg\"]/div[1]/div[1]/fieldset/div[5]/div/div/div[1]/div[2]/ul/li[1]/label/span"),
            saveButton = new By.ByXPath("//*[@id=\"submit-btn\"]"),
            orgInfo = new By.ByXPath("//*[@id=\"mainWin\"]/div[1]/ul/li[2]/a"),
            incomingRequests = new By.ByXPath("//*[@id=\"topBlock\"]/nav/ul/li[3]/a");

    @Override
    public SearchByNumberPage clickOnSearchByNumber() {
        getElement(searchByNumber).click();
        return PF.getPage(SearchByNumberPage.class);
    }

    public Profile clickOnIncomingRequests(){
        getElement(incomingRequests).click();
        return this;
    }

    public Profile typeSurName(String surname) {
        inputText(getElement(sunameInput), surname);
        return this;
    }

    public Profile typeName(String name) {
        inputText(getElement(nameInput), name);
        return this;
    }

    public Profile typeSecondName(String secondName) {
        inputText(getElement(secondNameInput), secondName);
        return this;
    }

    public Profile typePhone(String number) {
        inputText(getElement(phoneInput), number);
        return this;
    }

    public Profile clickOnCitySelect() {
        getElement(citySelect).click();
        return this;
    }

    public Profile clickOnFirstCity() {
        getElement(firstCity).click();
        return this;
    }

    public Profile clickOnSaveButton() {
        getElement(saveButton).click();
        return this;
    }

    public OrganizationInfo clickOnOrgInfo() {
        getElement(orgInfo).click();
        return PF.getPage(OrganizationInfo.class);
    }

}
