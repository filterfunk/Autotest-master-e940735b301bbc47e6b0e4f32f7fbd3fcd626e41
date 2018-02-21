package com.gisauto.pageObjects;

import com.gisauto.utils.PF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutoUpload extends PriceUpload {

    private final By emailUploadButton = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[2]/div[2]/ul/li[1]/a/button"),
            ftpUploadButton = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[2]/div[2]/ul/li[3]/a/button"),
            directLinkUploadButton = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[2]/div[2]/ul/li[4]/a/button"),
            emailFileNameInput = new By.ByXPath("//*[@id=\"item_autoload_emailFileName\"]"),
            ftpFileNameInput = new By.ByXPath("//*[@id=\"item_autoload_ftpFileName\"]"),
            emailInput = new By.ByXPath("//*[@id=\"item_autoload_email\"]"),
            shopSelect = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[1]/div/div/div[1]/div[2]"),
            templateSelect = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[2]/div/div/div[1]/div[2]"),
            linkAdressInput = new By.ByXPath("//*[@id=\"item_autoload_sourceLink\"]"),
            createButton = new By.ByXPath("//*[@id=\"save-autoload-button\"]"),
            createTemplate = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[2]/button");

    public AutoUpload typeEmailFileName(String fileName) {
        inputText(getElement(emailFileNameInput), fileName);
        return this;
    }

    public AutoUpload typeFTPFileName(String fileName) {
        inputText(getElement(ftpFileNameInput), fileName);
        return this;
    }

    public AutoUpload typeAutoUploadEmail(String email) {
        getElement(emailInput).clear();
        inputText(getElement(emailInput), email);
        return this;
    }

    public AutoUpload clickOnRefreshRateSelect(boolean isFTP, String refreshRate) {
        String id = isFTP ? "up-by-ftp" : "up-by-link";
        getElement(new By.ByXPath("//*[@id=\"" + id + "\"]/div[2]/div/div/div[1]/input")).click();
        getRefreshRate(id, refreshRate).click();
        return this;
    }

    private WebElement getRefreshRate(String id, String rate) {
        return getElementFromSelect("//*[@id=\"" + id + "\"]/div[2]/div/div/div[2]/ul/li[", "]/label/span", rate);
    }

    public AutoUpload clickOnShopSelect(String shopName) {
        getElement(shopSelect).click();
        getShopFromSelect(shopName).click();
        return this;
    }

    private WebElement getShopFromSelect(String shopName) {
        return getElementFromSelect("//*[@id=\"item-autoload-form\"]/div[6]/div[1]/div/div/div[2]/ul/li[", "]/label/span", shopName);
    }

    public AutoUpload clickOnTemplateSelect(String templateName) {
        getElement(templateSelect).click();
        getTemplateFromSelect(templateName).click();
        return this;
    }

    private WebElement getTemplateFromSelect(String templateName) {
        return getElementFromSelect("//*[@id=\"item-autoload-form\"]/div[6]/div[2]/div/div/div[2]/ul/li[", "]/label/span", templateName);
    }

    public AutoUpload typeLinkAdress(String url) {
        inputText(getElement(linkAdressInput), url);
        return this;
    }

    public AutoUpload clickOnUploadType(String uploadType) {
        if (uploadType.toLowerCase().equals("email")) {
            getElement(emailUploadButton).click();
        } else if (uploadType.toLowerCase().equals("ftp")) {
            getElement(ftpUploadButton).click();
        } else if (uploadType.toLowerCase().equals("link")) {
            getElement(directLinkUploadButton).click();
        } else {
            throw new RuntimeException("Неизвестный тип загрузки - " + uploadType);
        }
        return this;
    }

    public AutoUpload clickOnCreateButton() {
        getElement(createButton).click();
        return this;
    }

    public TemplateSettings clickOnTemplateCreateButton(){
        getElement(createTemplate).click();
        return PF.getPage(TemplateSettings.class);
    }

}
