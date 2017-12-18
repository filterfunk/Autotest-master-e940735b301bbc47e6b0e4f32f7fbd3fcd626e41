package com.gisauto.test.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
            goToCabinet = new By.ByXPath("/html/body/div[6]/div/div/div/div[1]/div[1]/div[2]/div[2]"),
            searchField = new By.ByXPath("//*[@id=\"app\"]/div[1]/input");

    public SearchByNumberPage() {
        if (!"Последние запросы поиска по номеру".equals(driver.getTitle())) {
            throw new IllegalStateException("Открытая страница не является страницей поиска по номеру");
        }
    }

    @Step(value = "Нажатие на кнопку \"Заказать\"")
    public SearchByNumberPage clickOnBuyButton(String shopName) {
        int tr = 1;
        WebElement a = null;
        do {
            if (tr != 5) {
                a = getElement(new By.ByXPath("//*[@id=\"tbl\"]/tbody/tr[" + tr + "]/td[6]/div[1]/span/a"));
            }
            tr++;
        } while (!a.getText().equals(shopName));
        getElement(new By.ByXPath("//*[@id=\"tbl\"]/tbody/tr[" + tr + "]/td[5]/div[2]/div[1]")).click();
        return this;
    }

    @Step(value = "Поиск")
    public SearchByNumberPage search(String number) {
        WebElement input = getElement(searchField);
        inputText(input, number);
        input.sendKeys(Keys.ENTER);
        return this;
    }

    @Step(value = "Нажатие на кнопку подтверждения заказа")
    public SearchByNumberPage clickOnSubmittBuyButton() {
        getElement(submittBuyButton).click();
        return this;
    }

    @Step(value = "Проверка содержимого сообщения о подтверждении заказа")
    public String getConfirmMessage() {
        return getElement(confirmMessage).getText() + getElement(goToCabinet).getText();
    }

}
