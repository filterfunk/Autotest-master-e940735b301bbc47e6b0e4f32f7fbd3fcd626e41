package com.gisauto.pageObjects;

import com.gisauto.utils.TestMain;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * PageObject страницы поиска по номеру
 * <p>
 * Хранит в себе информацию и набор методов для работы с WebElement'ами, присутствующими
 * на странице поиска по номеру.
 *
 * @author Neradko Artsiom
 */
public class SearchByNumberPage extends BasePage {

    private By submittBuyButton = new By.ByXPath("//*[@id=\"sendShopOrderButton\"]"),
                confirmMessage = new By.ByXPath("/html/body/div[6]/div/div/div/div[1]/div[1]/div[2]/div[1]"),
                goToCabinet = new By.ByXPath("/html/body/div[6]/div/div/div/div[1]/div[1]/div[2]/div[2]");

    public SearchByNumberPage() {
        if (!"Последние запросы поиска по номеру".equals(driver.getTitle())) {
            throw new IllegalStateException("This page isn't search by number page.");
        }
    }

    public SearchByNumberPage clickOnBuyButton() {
        int tr = 1;
        WebElement a;
        do {
            a = getElement(new By.ByXPath("//*[@id=\"tbl\"]/tbody/tr[" + tr + "]/td[6]/div[1]/span/a"));
            tr++;
        } while (!a.getText().equals("TEST"));
        getElement(new By.ByXPath("//*[@id=\"tbl\"]/tbody/tr[" + tr + "]/td[5]/div[2]/div[1]")).click();
        return this;
    }

    public SearchByNumberPage search() {
        WebElement input = getElement(new By.ByXPath("//*[@id=\"app\"]/div[1]/input"));
        inputText(input, "079103383BB");
        input.sendKeys(Keys.ENTER);
        return this;
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

    public SearchByNumberPage clickOnSubmittBuyButton() {
        getElement(submittBuyButton).click();
        return this;
    }

    public String getConfirmMessage(){
        return getElement(confirmMessage).getText() + getElement(goToCabinet).getText();
    }

}
