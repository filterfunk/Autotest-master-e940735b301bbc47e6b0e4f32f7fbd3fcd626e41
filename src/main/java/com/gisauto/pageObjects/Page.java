package com.gisauto.pageObjects;

import com.gisauto.utils.Driver;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.List;

/**
 * Базовый клас PageObject'ов, от которого наследуются все прочие Page.
 * <p>
 * Хранит в себе базовый набор методов для работы с WebElement'ами, присутствующими
 * на каждой странице.
 *
 * @author Neradko Artsiom
 */
public abstract class Page {

    private static long startTime;
    private static final long WAIT_TIME = 60000;
    static final Logger LOGGER = LogManager.getLogger("PageFactoryLogger");

    public void openPage(String url) {
        Driver.getDriver().get(url);
    }
    public void openMobile(String url) {
        Driver.getMobileDriver().get(url);
    }

    public boolean isPageLoaded(String title) {
        startTime = System.currentTimeMillis();

        do {
            await(1000);
            if (checkTitle(title)) break;
        } while (System.currentTimeMillis() - startTime < 10000 && !checkTitle(title));
        if (System.currentTimeMillis() - startTime > 10000 && !checkTitle(title)) {
            throw new RuntimeException("Страница " + title + " не загрузилась");
        } else return true;
    }

    public boolean isVisible(By by) {
        WebElement a;
        try {
            a = getElement(by);
        } catch (Exception e) {
            return false;
        }
        return a.isDisplayed();
    }

    public void inputText(WebElement textField, String string) {
        try {
            for (int i = 0; i < string.length(); i++) {
                textField.sendKeys(string.charAt(i) + "");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (JavascriptException ex) {
            Driver.kill();
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

    public static WebElement tryFindElement(By xPath) {

        while (!tryGetElement(xPath)) {

            if (System.currentTimeMillis() - startTime > WAIT_TIME) {
                throw new RuntimeException("Не удалось найти элемент по " + xPath
                        + "\nИстекло время ожидания равное " + WAIT_TIME / 1000 + " сек.");
            }

            await(1000);
        }

        return Driver.getDriver().findElement(xPath);
    }

    private static boolean tryGetElement(By xPath) {
        try {
            WebElement webElement = Driver.getDriver().findElement(xPath);
            if (!webElement.isDisplayed()) ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
            return webElement.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public static List<WebElement> getElements(By by) {
        return Driver.getDriver().findElements(by);
    }

    public static void await(long waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement getElementFromSelect(String firstPart, String secondPart, String expectedText, WebElement select) {
        await(100);
        WebElement a = getElementUnsafe(new By.ByXPath(firstPart + expectedText + secondPart));

        if (a != null) {
            while (!a.isDisplayed()) {
                select.sendKeys(Keys.DOWN);
                await(100);
            }
        }

        return a;
    }

    public static WebElement getElementUnsafe(By by) {
        try {
            return Driver.getDriver().findElement(by);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static WebElement getElement(By by) {
        if (by == null) {
            throw new NullPointerException("Получен By равный null!");
        }

        startTime = System.currentTimeMillis();
        WebElement wb;
        long spentTime = System.currentTimeMillis() - startTime;

        wb = tryFindElement(by);

        if (spentTime / 1000 > 1)
            LOGGER.info("Веб элемент " + by.toString() + " был найден за "
                    + (System.currentTimeMillis() - startTime) / 1000 + " сек. \n");
        return wb;
    }

    public boolean checkMobileUrl(String url){
        return url.equals(Driver.getMobileDriver().getCurrentUrl());
    }

    public boolean checkDesktopUrl(String url){
        return url.equals(Driver.getDriver().getCurrentUrl());
    }

}