package com.gisauto.pageObjects;

import com.gisauto.utils.PF;
import org.openqa.selenium.By;

public class Profile extends BasePage {

    private By.ByXPath searchByNumber = new By.ByXPath("/html/body/div[1]/div[1]/nav/ul/li[1]");

    @Override
    public SearchByNumberPage clickOnSearchByNumber(){
        getElement(searchByNumber).click();
        return PF.getPage(SearchByNumberPage.class);
    }

}
