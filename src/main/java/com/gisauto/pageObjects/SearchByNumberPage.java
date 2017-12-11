package com.gisauto.pageObjects;

import com.gisauto.utils.TestMain;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchByNumberPage extends BasePage {
    //TODO: 11.12.2017 artem.neradko - написать JavaDoc для всех методов и классов

    WebDriver driver = TestMain.driver;

    public SearchByNumberPage() {
        if (!"Последние запросы поиска по номеру".equals(driver.getTitle())) {
            throw new IllegalStateException("This page isn't homepage.");
        }
    }

    public SearchByNumberPage makeBuy() {
        int tr = 1;
        WebElement a;
        do {
            a = getElement(new By.ByXPath("//*[@id=\"tbl\"]/tbody[2]/tr[" + tr + "]/td[6]/div[1]/span"));
            tr++;
        } while (!a.getText().equals("Test"));
        getElement(new By.ByXPath("//*[@id=\"tbl\"]/tbody/tr[" + tr + "]/td[5]/div[2]/div[1]")).click();
        return this;
    }

    public SearchByNumberPage search(){
        WebElement input = getElement(new By.ByXPath("//*[@id=\"app\"]/div[1]/input"));
        inputText(input,"079103383BB");
        input.sendKeys(Keys.ENTER);
        return this;
    }

    public void inputText(WebElement textField, String string) {
        for (int i = 0; i < string.length(); i++) {
            textField.sendKeys(string.charAt(i) + "");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
