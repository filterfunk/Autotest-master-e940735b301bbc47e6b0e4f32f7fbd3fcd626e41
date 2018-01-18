package com.gisauto.pageObjects;

import com.gisauto.utils.Driver;
import com.gisauto.utils.TestMain;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Базовый клас PageObject'ов, от которого наследуются все прочие Page.
 * <p>
 * Хранит в себе базовый набор методов для работы с WebElement'ами, присутствующими
 * на каждой странице.
 *
 * @author Neradko Artsiom
 */
public abstract class Page {

    private long startTime;
    private static final long WAIT_TIME = 60000;

    public void openPage(String url) {
        Driver.getDriver().get(url);
    }

    /**
     * Поиск элемента, с помощью любого инструмента (name, XPath, CSS и т.д.)
     *
     * @param xpath <class>By</class> инструмент, с помощью которого осуществляется поиск.
     *              <p>(например <code>new By.ByXPath("//*[@id=\"btnOpenCity\"]")</code>
     * @return найденный WebElement.
     */
    public WebElement getElement(By xpath) {
        startTime = System.currentTimeMillis();
        return tryFindElement(xpath);
    }

    public boolean isVisible(WebElement webElement) {
        return webElement.isDisplayed();
    }

    public void inputText(WebElement textField, String string) {
        for (int i = 0; i < string.length(); i++) {
            textField.sendKeys(string.charAt(i) + "");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Attachment
    public static String getErrorMessage(Exception ex) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ex.getStackTrace().length; i++) {
            sb.append(ex.getStackTrace()[i]);
        }
        return sb.toString();
    }

    public boolean checkTitle(String excpected) {
        return excpected.equals(Driver.getDriver().getTitle());
    }

    public WebElement tryFindElement(By xPath) {
        if (System.currentTimeMillis() - startTime > WAIT_TIME) {
            throw new RuntimeException("Не удалось найти элемент по XPath: " + xPath);
        }

        if (tryGetElement(xPath)) {
            return Driver.getDriver().findElement(xPath);
        } else {
            await(1000);
            tryFindElement(xPath);
        }
        return null;
    }

    private boolean tryGetElement(By xPath) {
        try {
            Driver.getDriver().findElement(xPath);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void await(long waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
