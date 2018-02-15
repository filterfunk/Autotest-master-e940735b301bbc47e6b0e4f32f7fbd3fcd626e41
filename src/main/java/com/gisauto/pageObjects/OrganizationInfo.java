package com.gisauto.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrganizationInfo extends BasePage {

    private By innInput = new By.ByXPath("//*[@id=\"organization_inn\"]"),
    shopNameInput = new By.ByXPath("//*[@id=\"organization_mainShop_shopName\"]"),
    shopPoneInput = new By.ByXPath("//*[@id=\"organization_mainShop_shopPhones_0_shopPhone\"]"),
    shopEmailInput = new By.ByXPath("//*[@id=\"organization_mainShop_shopEmail\"]"),
    shopWebSiteInput = new By.ByXPath("//*[@id=\"organization_mainShop_shopSite\"]"),
    shopCitySelect = new By.ByXPath("//*[@id=\"formSave\"]/div[13]/div[1]/div[1]/div/div/div[1]/input"),
    shopFirstCity = new By.ByXPath("//*[@id=\"formSave\"]/div[13]/div[1]/div[1]/div/div/div[2]/ul/li[1]/label"),
    shopAdress1 = new By.ByXPath("//*[@id=\"organization_mainShop_street\"]"),
    shopAdress2 = new By.ByXPath("//*[@id=\"organization_mainShop_building\"]"),
    shopAdress3 = new By.ByXPath("//*[@id=\"organization_mainShop_office\"]"),
    saveButton = new By.ByXPath("//*[@id=\"organization-form\"]/div[2]/div/div/div/input");

    public OrganizationInfo typeInn(String inn){
        inputText(getElement(innInput), inn);
        return this;
    }

    public OrganizationInfo typeShopName(String shopName){
        inputText(getElement(shopNameInput), shopName);
        return this;
    }

    public OrganizationInfo typeShopPhone(String phone){
        inputText(getElement(shopPoneInput), phone);
        return this;
    }

    public OrganizationInfo typeShopEmail(String mail){
        inputText(getElement(shopEmailInput), mail);
        return this;
    }

    public OrganizationInfo typeShopWebSite(String site){
        inputText(getElement(shopWebSiteInput), site);
        return this;
    }


    public OrganizationInfo typeShopStreet(String street){
        inputText(getElement(shopAdress1), street);
        return this;
    }

    public OrganizationInfo typeShopHouse(String house){
        inputText(getElement(shopAdress2), house);
        return this;
    }

    public OrganizationInfo typeShopFlat(String flat){
        inputText(getElement(shopAdress3), flat);
        return this;
    }

    public OrganizationInfo clickOnSelectShopCity(){
        getElement(shopCitySelect).click();
        return this;
    }

    public OrganizationInfo clickOnFirstCity(){
        getElement(shopFirstCity).click();
        return this;
    }

    public OrganizationInfo clickOnSaveButton(){
        getElement(saveButton).click();
        return this;
    }

    public OrganizationInfo chooseCityFromSelect(String cityName){
        getCityFromMultiSelect(cityName).click();
        return this;
    }

    private WebElement getCityFromMultiSelect(String city) {
        int i = 0;
        WebElement element;
        do {
            i++;
            element = getElement(new By.ByXPath("\n" +
                    "        //*[@id=\"formSave\"]/div[13]/div[1]/div[1]/div/div/div[2]/ul/li[" + i + "]/label"));
        }
        while (element.getText().equals(city));
        return element;
    }
}
