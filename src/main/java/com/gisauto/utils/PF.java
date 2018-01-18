package com.gisauto.utils;

import com.gisauto.pageObjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public final class PF {

    private static ArrayList<Object> pagesInstances = new ArrayList<>();

    /**
     * Page factory method creates instance of page class.
     *
     * @param pageObject - class extends BasePage
     * @return - created page, which extends Page
     */
    public static <T extends Page> T getPage(Class<T> pageObject) {
        for (Object a : pagesInstances) {
            if (a != null) {
                if (a.getClass() == pageObject.getClass()) {
                    return (T) a;
                }
            } else pagesInstances.remove(a);
        }

        T page = PageFactory.initElements(Driver.getDriver(), pageObject);
        pagesInstances.add(page);
        return page;
    }

}
