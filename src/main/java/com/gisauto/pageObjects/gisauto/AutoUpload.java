package com.gisauto.pageObjects.gisauto;

import com.gisauto.pageObjects.Page;
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
            shopSelect = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[2]/div/div"),
            templateSelect = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[2]/div/div/div[1]/div[2]"),
            linkAdressInput = new By.ByXPath("//*[@id=\"item_autoload_sourceLink\"]"),
            createButton = new By.ByXPath("//*[@id=\"save-autoload-button\"]"),
            createTemplate = new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[2]/button");

    public AutoUpload typeEmailFileName(String fileName) {
        inputText(Page.getElement(emailFileNameInput), fileName);
        return this;
    }

    public AutoUpload typeFTPFileName(String fileName) {
        inputText(Page.getElement(ftpFileNameInput), fileName);
        return this;
    }

    public AutoUpload typeAutoUploadEmail(String email) {
        Page.getElement(emailInput).clear();
        inputText(Page.getElement(emailInput), email);
        return this;
    }

    public AutoUpload clickOnRefreshRateSelect(boolean isFTP, String refreshRate) {
        String id = isFTP ? "up-by-ftp" : "up-by-link";
        WebElement a = Page.getElement(new By.ByXPath("//*[@id=\"" + id + "\"]/div[2]/div/div/div[1]/input"));
        a.click();
        getRefreshRate(id, refreshRate, a).click();
        return this;
    }

    private WebElement getRefreshRate(String id, String rate, WebElement select) {
        return Page.getElementFromSelect("//*[@id=\"" + id + "\"]/div[2]/div/div/div[2]/ul//span[text()=\"", "\"]", rate, select);
    }

    public AutoUpload clickOnShopSelect(String shopName) {
        Page.getElement(shopSelect).click();
        getShopFromSelect(shopName, Page.getElement(shopSelect)).click();
        return this;
    }

    private WebElement getShopFromSelect(String shopName, WebElement select) {
        return Page.getElementFromSelect("//*[@id=\"item-autoload-form\"]/div[6]/div[1]/div/div/div[2]/ul/li[", "]/label/span", shopName, select);
    }

    public AutoUpload clickOnTemplateSelect(String templateName) {
        Page.await(1000);
        Page.getElement(templateSelect).click();
        Page.getElement(new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[2]/div/div/div[2]/ul/li")).click();
        return this;
    }

    private WebElement getTemplateFromSelect(String templateName, WebElement select) {
        return Page.getElementFromSelect("//*[@id=\"item-autoload-form\"]//span[text()=\"", "\"]", templateName, select);
    }

    public AutoUpload typeLinkAdress(String url) {
        inputText(Page.getElement(linkAdressInput), url);
        return this;
    }

    public AutoUpload clickOnUploadType(String uploadType) {
        if (uploadType.toLowerCase().equals("email")) {
            Page.getElement(emailUploadButton).click();
        } else if (uploadType.toLowerCase().equals("ftp")) {
            Page.getElement(ftpUploadButton).click();
        } else if (uploadType.toLowerCase().equals("link")) {
            Page.getElement(directLinkUploadButton).click();
        } else {
            throw new RuntimeException("Неизвестный тип загрузки - " + uploadType);
        }
        Page.await(500);
        return this;
    }

    public AutoUpload clickOnCreateButton() {
        Page.getElement(createButton).click();

        return this;
    }

    public TemplateSettings clickOnTemplateCreateButton(){
        Page.await(1000);
        Page.getElement(createTemplate).click();
        return PF.getPage(TemplateSettings.class);
    }

}
