package com.gisauto.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OutgoingRequests extends BasePage {

    private final By lastRequest = new By.ByXPath("//*[@id=\"main-data\"]/div[1]/div[1]/div/div[2]/table[2]/tbody/tr[1]/td[6]/div/div[1]/a");

    public OutgoingRequests checkRequest(String partName) {
        Assert.assertEquals("Запрос на " + partName + "не найден",
                partName, getElement(lastRequest).getText());
        return this;
    }

}
