package com.gisauto.pageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YandexMailPage extends Page {

    private By message = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[2]/div[4]/div/div[2]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div/div/a");
    private static Logger logger = LogManager.getRootLogger();

    public YandexMailPage() {
        openPage("https://mail.yandex.ru/u2709/?uid=576159314&login=test-gisauto#inbox");
        if (!driver.getTitle().contains(("Входящие — Яндекс.Почта"))){
            throw new IllegalStateException("This page isn't homepage.");
        }
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

    public void openPage(String url) {
        driver.get(url);
    }

    public boolean isVisible(WebElement webElement) {
        return webElement.isDisplayed();
    }

}
