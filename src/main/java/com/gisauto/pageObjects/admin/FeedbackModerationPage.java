package com.gisauto.pageObjects.admin;

import org.openqa.selenium.By;

/**
 * @autor neradko, created on 20.04.18
 */

public class FeedbackModerationPage extends AdminBasePage {

    public AdminBasePage clickOnAcceptFeedback(String message) {
        int tr = getTr(message);

        getElement(new By.ByXPath("/html/body/div[1]/div[1]/table/tbody/tr[" +
                tr + "]/td[7]/a[1]")).click();
        return this;
    }

    public AdminBasePage clickOnDeclineFeedback(String message) {
        int tr = getTr(message);

        getElement(new By.ByXPath("/html/body/div[1]/div[1]/table/tbody/tr[" +
                tr + "]/td[7]/a[2]")).click();
        return this;
    }

    public AdminBasePage clickOnAcceptComplain(String message) {
        int tr = getTr(message);

        getElement(new By.ByXPath("/html/body/div[1]/div[1]/table/tbody/tr[" +
                tr + "]/td[4]/div/a[2]")).click();
        return this;
    }
    public AdminBasePage clickOnAcceptFeedbackAnswer(String message) {
        int tr = getTr(message);

        getElement(new By.ByXPath("/html/body/div[1]/div[1]/table/tbody/tr[" +
                tr + "]/td[7]/a[1]")).click();
        return this;
    }
    public AdminBasePage clickOnDeclineFeedbackAnswer(String message) {
        int tr = getTr(message);

        getElement(new By.ByXPath("/html/body/div[1]/div[1]/table/tbody/tr[" +
                tr + "]/td[7]/a[2]")).click();
        return this;
    }
}
