package com.gisauto.pageObjects.gisauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Warehouse extends BasePage {

    private final long waitTime = 620000;

    public boolean checkManufacturer(String manufacturer) {
        long startTime = System.currentTimeMillis();
        boolean isVisible;

        do {
            isVisible = waitForAnalyze(manufacturer);
        } while (!isVisible && System.currentTimeMillis() - startTime <= waitTime);

        return isVisible;
    }

    private boolean waitForAnalyze(String manufacturer) {
        try {
            List<WebElement> manufacturers = getElements(new By.ByXPath("//*[@id=\"main-data\"]//div[@class=\"visible-data popoverBtn\"]"));
            for (WebElement m : manufacturers) {
                if (m.getText().equals(manufacturer)) {
                    return true;
                }
            }
            return false;
        } finally {
            refreshPage();
        }
    }

}
