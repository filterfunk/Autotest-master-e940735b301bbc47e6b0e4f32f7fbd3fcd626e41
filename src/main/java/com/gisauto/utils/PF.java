package com.gisauto.utils;

import com.gisauto.pageObjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public final class PF {

    private static WebDriver driver = TestMain.driver;

    /**
     * Page factory method creates instance of page class.
     *
     * @param page - class extends BasePage
     * @return - created page, which extends Page
     */
    public static <T extends Page> T getPage(Class<T> page) {
        return PageFactory.initElements(driver, page);
    }

}
