package com.gisauto.pageObjects.admin;

import com.gisauto.pageObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @autor neradko, created on 20.04.18
 */

public class AdminBasePage extends Page {

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul[1]/li[7]/a")
    private WebElement feedbackModerationButton;

    public AdminBasePage clickOnFeedbackModeration() {
        feedbackModerationButton.click();
        return this;
    }

    protected int getTr(String message) {
        int tr = 0;
        String msg;

        do {
            tr++;
            WebElement webElement = getElement(new By.ByXPath("/html/body/div[1]/div[1]/table/tbody/tr["
                    + tr + "]/td[4]"));
            msg = webElement.getText().trim();
        } while (!msg.contains(message));
        return tr;
    }

}