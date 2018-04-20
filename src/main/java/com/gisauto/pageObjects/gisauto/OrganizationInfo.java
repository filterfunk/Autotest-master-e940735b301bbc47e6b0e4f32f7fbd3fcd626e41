package com.gisauto.pageObjects.gisauto;

import org.openqa.selenium.By;

public class OrganizationInfo extends Profile {

    private By innInput = new By.ByXPath("//*[@id=\"organization_inn\"]"),
            shopNameInput = new By.ByXPath("//*[@id=\"organization_mainShop_shopName\"]"),
            shopPoneInput = new By.ByXPath("//*[@id=\"organization_mainShop_shopPhones_1_shopPhone\"]"),
            shopEmailInput = new By.ByXPath("//*[@id=\"organization_mainShop_shopEmail\"]"),
            shopWebSiteInput = new By.ByXPath("//*[@id=\"organization_mainShop_shopSite\"]"),
            shopCitySelect = new By.ByXPath("//*[@id=\"formSave\"]/div[13]/div[1]/div[1]/div/div/div[1]/input"),
            shopFirstCity = new By.ByXPath("//*[@id=\"formSave\"]/div[13]/div[1]/div[1]/div/div/div[2]/ul/li[1]/label"),
            shopAdress1 = new By.ByXPath("//*[@id=\"organization_mainShop_street\"]"),
            shopAdress2 = new By.ByXPath("//*[@id=\"organization_mainShop_building\"]"),
            shopAdress3 = new By.ByXPath("//*[@id=\"organization_mainShop_office\"]"),
            addShopButton = new By.ByXPath("//*[@id=\"btn_addFilial\"]"),
            newShopNameInput = new By.ByXPath("//*[@id=\"shop_shopName\"]"),
            newShopPhoneInput = new By.ByXPath("//*[@id=\"shop_shopPhones_1_shopPhone\"]"),
            newShopEmailInput = new By.ByXPath("//*[@id=\"shop_shopEmail\"]"),
            newShopAdressSelect = new By.ByXPath("//*[@id=\"modalAddAddress\"]/div[2]/form/div[1]/div[2]/div[1]/div/div/div[1]/div[2]"),
            newShopFirstCity = new By.ByXPath("//*[@id=\"modalAddAddress\"]/div[2]/form/div[1]/div[2]/div[1]/div/div/div[2]/ul/li[1]/label/span"),
            saveNewShopButton = new By.ByXPath("//*[@id=\"saveShop\"]"),
            saveButton = new By.ByXPath("//*[@id=\"organization-form\"]/div[2]/div/div/div/input");

    public OrganizationInfo typeInn(String inn) {
        inputText(getElement(innInput), inn);
        return this;
    }

    public OrganizationInfo typeShopName(String shopName) {
        inputText(getElement(shopNameInput), shopName);
        return this;
    }

    public OrganizationInfo typeShopPhone(String phone) {
        inputText(getElement(shopPoneInput), phone);
        return this;
    }

    public OrganizationInfo typeShopEmail(String mail) {
        inputText(getElement(shopEmailInput), mail);
        return this;
    }

    public OrganizationInfo typeShopWebSite(String site) {
        inputText(getElement(shopWebSiteInput), site);
        return this;
    }

    public OrganizationInfo typeShopStreet(String street) {
        inputText(getElement(shopAdress1), street);
        return this;
    }

    public OrganizationInfo typeShopHouse(String house) {
        inputText(getElement(shopAdress2), house);
        return this;
    }

    public OrganizationInfo typeShopFlat(String flat) {
        inputText(getElement(shopAdress3), flat);
        return this;
    }

    public OrganizationInfo clickOnSelectShopCity() {
        getElement(shopCitySelect).click();
        return this;
    }

    public OrganizationInfo clickOnFirstCity() {
        getElement(shopFirstCity).click();
        return this;
    }

    public OrganizationInfo clickOnSaveButton() {
        getElement(saveButton).click();
        return this;
    }

    public OrganizationInfo chooseCityFromSelect(String cityName) {
//        getCityFromMultiSelect(cityName).click();
        return this;
    }

//    private WebElement getCityFromMultiSelect(String city) {
//        int i = 0;
//        WebElement element;
//        do {
//            i++;
//            element = getElementFromSelect("//*[@id=\\\"formSave\\\"]/div[13]/div[1]/div[1]/div/div/div[2]/ul/li[",
//                    "]/label", city );
//        }
//        while (element.getText().equals(city));
//        return element;
//    }

    public OrganizationInfo clickOnAddShop() {
        getElement(addShopButton).click();
        return this;
    }

    public OrganizationInfo typeNewShopName(String shopName) {
        inputText(getElement(newShopNameInput), shopName);
        return this;
    }

    public OrganizationInfo typeNewShopPhone(String phoneNumber) {
        inputText(getElement(newShopPhoneInput), phoneNumber);
        return this;
    }

    public OrganizationInfo typeNewShopEmail(String email) {
        inputText(getElement(newShopEmailInput), email);
        return this;
    }

    public OrganizationInfo clickOnNewShopAdress() {
        getElement(newShopAdressSelect).click();
        getElement(newShopFirstCity).click();
        return this;
    }

    public OrganizationInfo clickOnSaveNewShopButton() {
        getElement(saveNewShopButton).click();
        return this;
    }

}
