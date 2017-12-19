package com.gisauto.pageObjects;

import com.gisauto.utils.TestMain;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Базовый клас PageObject'ов, от которого наследуются все прочие Page.
 * <p>
 * Хранит в себе базовый набор методов для работы с WebElement'ами, присутствующими
 * на каждой странице.
 *
 * @author Neradko Artsiom
 */
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
}
