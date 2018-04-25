package com.gisauto.pageObjects.admin;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import java.util.Locale;

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

}
