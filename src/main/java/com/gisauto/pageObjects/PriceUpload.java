package com.gisauto.pageObjects;

import com.gisauto.utils.FileUploader;
import com.gisauto.utils.PF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PriceUpload extends BasePage {

    private By manualUploadButton = new By.ByXPath("//*[@id=\"mainWin\"]/div[2]/div[1]/div/button[3]"),
            fileUpload = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[1]/div[1]/div/div[1]"),
            shopSelect = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[2]/div/div[1]/div[1]/input"),
            firstLinePlus = new By.ByXPath("//*[@id=\"item_import_template_firstLine-styler\"]/div[3]"),
            deviderSelect = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[3]/div[3]/div[2]/div/div[1]/div[1]/input"),
            firstDevider = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[3]/div[3]/div[2]/div/div[1]/div[2]/ul/li[1]"),
            secondDevider = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[3]/div[3]/div[2]/div/div[1]/div[2]/ul/li[2]"),
            thirdDevider = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[3]/div[3]/div[2]/div/div[1]/div[2]/ul/li[3]"),
            templateSelect = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[4]/div[1]/div/div[1]/input"),
            firstTemplate = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[4]/div[1]/div/div[2]/ul/li[1]"),
            createTemplateButton = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[4]/div[1]/button"),
            currencySelect = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/div[4]/div[2]/div[1]/div[1]/div[1]/input"),
            saveButton = new By.ByXPath("//*[@id=\"parts-hand\"]/div/form/button"),
            createUpolad = new By.ByXPath("//*[@id=\"mainWin\"]/div[2]/div[1]/div/button[1]"),
            templateSettings = new By.ByXPath("//*[@id=\"mainWin\"]/div[2]/div[1]/div/button[2]");

    public AutoUpload clickOnCreateUpload() {
        getElement(createUpolad).click();
        return PF.getPage(AutoUpload.class);
    }

    public PriceUpload clickOnManualUploadButton() {
        getElement(manualUploadButton).click();
        return this;
    }

    public PriceUpload clickOnFileUpload(String file) {
        getElement(fileUpload).click();
        FileUploader.uploadFile(file);
        return this;
    }

    public PriceUpload clickOnShopSelect() {
        getElement(shopSelect).click();
        return this;
    }

    public PriceUpload clickOnShop(String shopName) {
        getShopFromSelector(shopName).click();
        return this;
    }

    public PriceUpload clickOnFirstLinePlus(int times) {
        for (int i = 0; i < times; i++)
            getElement(firstLinePlus).click();
        return this;
    }

    public PriceUpload clickOnDeviderSelect() {
        getElement(deviderSelect).click();
        return this;
    }

    public PriceUpload clickOnFirstDevider() {
        getElement(firstDevider).click();
        return this;
    }

    public PriceUpload clickOnSecondDevider() {
        getElement(secondDevider).click();
        return this;
    }

    public PriceUpload clickOnThirdDevider() {
        getElement(thirdDevider).click();
        return this;
    }

    public PriceUpload clickOnTemplateSelect() {
        getElement(templateSelect).click();
        return this;
    }

    public PriceUpload clickOnFirstTemplate() {
        getElement(firstTemplate).click();
        return this;
    }

    public PriceUpload clickOnCreateTemplateButton() {
        getElement(createTemplateButton).click();
        return this;
    }

    public PriceUpload clickOnCurrencySelect() {
        getElement(currencySelect).click();
        return this;
    }

    public PriceUpload clickOnSaveButton() {
        getElement(saveButton).click();
        return this;
    }

    private WebElement getShopFromSelector(String shopName) {
        int i = 0;
        WebElement element = null;
        do {
            i++;
            element = getElement(new By.ByXPath("\"//*[@id=\\\"parts-hand\\\"]/div/form/div[2]/div/div[1]/div[2]/ul/li[" + i + "]\""));
        }
        while (element.getText().equals(shopName));
        return element;
    }

    public TemplateSettings clickOnTemplateSettings() {
        getElement(templateSettings).click();
        return PF.getPage(TemplateSettings.class);
    }

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
                createButton = new By.ByXPath("//*[@id=\"save-autoload-button\"]");

        public AutoUpload typeEmailFileName(String fileName) {
            inputText(getElement(emailFileNameInput), fileName);
            return this;
        }

        public AutoUpload typeFTPFileName(String fileName) {
            inputText(getElement(ftpFileNameInput), fileName);
            return this;
        }

        public AutoUpload typeAutoUploadEmail(String email) {
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
            int li = 0;

            do {
                li++;
                WebElement a = getElement(new By.ByXPath("//*[@id=\"" + id + "\"]/div[2]/div/div/div[2]/ul/li[" + li + "]/label/span"));
                if (a.getText().equals(rate)) return a;
            } while (li <= 3);

            throw new RuntimeException("Невозможно найти частоту обновления " + rate);
        }

        public AutoUpload clickOnShopSelect(String shopName) {
            getElement(shopSelect).click();
            getShopFromSelect(shopName).click();
            return this;
        }

        private WebElement getShopFromSelect(String shopName) {
            int li = 0;

            do {
                li++;
                WebElement a = getElement(new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[1]/div/div/div[2]/ul/li[" + li + "]/label/span"));
                if (a.getText().equals(shopName)) return a;
            } while (li <= 15);

            throw new RuntimeException("Невозможно найти магазин " + shopName);
        }

        public AutoUpload clickOnTemplateSelect(String templateName) {
            getElement(templateSelect).click();
            getTemplateFromSelect(templateName).click();
            return this;
        }

        private WebElement getTemplateFromSelect(String templateName) {
            int li = 0;

            do {
                li++;
                WebElement a = getElement(new By.ByXPath("//*[@id=\"item-autoload-form\"]/div[6]/div[2]/div/div/div[2]/ul/li[" + li + "]/label/span"));
                if (a.getText().equals(templateName)) return a;
            } while (li <= 2);

            throw new RuntimeException("Невозможно найти шаблон " + templateName);
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

    }

}
