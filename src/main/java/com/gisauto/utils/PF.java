package com.gisauto.utils;

import com.gisauto.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public final class PF {

    private static WebDriver driver = TestMain.driver;

    //TODO: 11.12.2017 artem.neradko - написать JavaDoc для всех методов и классов
    /**
     * Page factory method creates instance of page class.
     * @param page - page to create
     * @param <T> - class extends BasePage
     * @return - created page, which extends BasePage
     */
    @SuppressWarnings("unchecked")
    public static <T extends BasePage> T getPage(Class<T> page){
        return PageFactory.initElements(driver, page);
    }

}
