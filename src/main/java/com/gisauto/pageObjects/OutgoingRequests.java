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
            brand = new By.ByXPath("//table//td[@data-name=\"car\"]//p"),
            name = new By.ByXPath("//table//td[@data-name=\"parts\"]//p");

    public OutgoingRequests checkRequest(String partName) {
        Assert.assertEquals("Запрос на " + partName + "не найден",
                partName, getElement(lastRequest).getText());
        return this;
    }

    //Don't use this method yet
    @Deprecated
    public boolean checkDate() {
        List<WebElement> list = getElements(date);
        SimpleDateFormat formatter = new SimpleDateFormat("DD.MM.YY");
        Date date = new Date();
        System.out.println(date);
        try {
            System.out.println(formatter.parse(date.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (WebElement we : list) {
            try {
                if (we.getText().equals(formatter.parseObject(date.toString()))) {
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
