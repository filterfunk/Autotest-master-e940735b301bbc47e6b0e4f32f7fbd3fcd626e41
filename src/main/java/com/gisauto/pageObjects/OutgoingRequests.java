package com.gisauto.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OutgoingRequests extends BasePage {

    public OutgoingRequests checkRequest(String partName) {
        Assert.assertEquals("Запрос на " + partName + "не найден",
                true, getRequest(partName));
        return this;
    }

    private boolean getRequest(String text) {
        int i = 1;
        WebElement element;
        do {
            if (i > 10) {
                return false;
            }
            i++;
            element = getElement(new By.ByXPath("//*[@id=\"main-data\"]/div[1]/div[1]/div/div[2]/table[2]/tbody/tr[" + i + "]/td[6]"));
        } while (!element.getText().equals(text));
        return true;
    }

}
