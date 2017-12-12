package com.gisauto.pageObjects;

import com.gisauto.utils.TestMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {

    public WebDriver driver = TestMain.driver;

    public void openPage(String url) {
        driver.get(url);
    }

    /**
     * Поиск элемента, с помощью любого инструмента (name, XPath, CSS и т.д.)
     *
     * @param by <class>By</class> инструмент, с помощью которого осуществляется поиск.
     *           <p>(например <code>new By.ByXPath("//*[@id=\"btnOpenCity\"]")</code>
     * @return найденный WebElement.
     */

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public boolean isVisible(WebElement webElement) {
        return webElement.isDisplayed();
    }
}
