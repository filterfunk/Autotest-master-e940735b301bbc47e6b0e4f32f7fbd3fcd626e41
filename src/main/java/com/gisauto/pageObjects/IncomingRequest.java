package com.gisauto.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class IncomingRequest extends BasePage {

    private By date = new By.ByXPath("//*[@id=\"inbox-main-table\"]/tbody//td[3]/text()[1]"),
            auto = new By.ByXPath("//*[@id=\"inbox-main-table\"]/tbody//td[5]/p"),
            part = new By.ByXPath("//*[@id=\"inbox-main-table\"]/tbody//td[6]/div/div[2]/p[1]"),
            customer = new By.ByXPath("//*[@id=\"inbox-main-table\"]/tbody//a");


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

    public boolean checkAuto(String text) {
        List<WebElement> list = getElements(auto);
        for (WebElement we : list) {
            if (we.getText().equals(text)) return true;
        }
        return false;
    }

    public boolean checkPart(String text) {
        List<WebElement> list = getElements(part);
        for (WebElement we : list) {
            if (we.getText().equals(text)) return true;
        }
        return false;
    }

    public boolean checkCustomer(String text) {
        List<WebElement> list = getElements(customer);
        for (WebElement we : list) {
            if (we.getText().equals(text)) return true;
        }
        return false;
    }


}
