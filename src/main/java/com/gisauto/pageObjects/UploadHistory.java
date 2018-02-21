package com.gisauto.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;

public class UploadHistory extends BasePage {

    private static final int dateField = 1, statusField = 2, fileNameField = 3,
            shopNameField = 4, errorEncryptionField = 5;

    public UploadHistory checkUpload(String shopName) {
        String uploadShop = getElement(new By.ByXPath("//*[@id=\"main-data\"]/div/div[1]/div/div[2]/" +
                "table[2]/tbody/tr[1]/td[" + shopNameField + "]")).getText();
        Assert.assertEquals("Неверное название магазина", shopName, uploadShop);
        return this;
    }

}
