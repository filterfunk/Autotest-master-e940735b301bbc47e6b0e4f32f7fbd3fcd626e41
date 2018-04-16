package com.gisauto.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OutgoingRequests extends BasePage {

    private final By lastRequest = new By.ByXPath("//*[@id=\"main-data\"]/div[1]/div[1]/div/div[2]/table[2]/tbody/tr[1]/td[6]/div/div[1]/a"),
            date = new By.ByXPath("//table//td[@data-name=\"created_at\"]"),
            brand = new By.ByXPath("//table//td[@data-name=\"parts\"]//div"),
            name = new By.ByXPath("//table//td[@data-name=\"parts\"]//a\"]");

    public OutgoingRequests checkRequest(String partName) {
        Assert.assertEquals("Запрос на " + partName + "не найден",
                partName, getElement(lastRequest).getText());
        return this;
    }

    public boolean checkDate() {
        List<WebElement> list = getElements(date);
        for (WebElement we : list) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yy");
            Date date = new Date();
            try {
                if (we.getText().equals(formatter.parseObject(String.valueOf(date)))) {
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    public boolean checkBrand(String text) {
        List<WebElement> list = getElements(brand);
        for (WebElement we : list) {
            if (we.getText().equals(text)) return true;
        }
        return false;

    }

    public boolean checkName(String text) {
        List<WebElement> list = getElements(name);
        for (WebElement we : list) {
            if (we.getText().equals(text)) return true;
        }
        return false;

    }
}
