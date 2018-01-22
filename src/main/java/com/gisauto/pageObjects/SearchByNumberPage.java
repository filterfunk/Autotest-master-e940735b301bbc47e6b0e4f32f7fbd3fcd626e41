package com.gisauto.pageObjects;

import com.gisauto.utils.Driver;
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
            goToCabinet = new By.ByXPath("//*[@id=\"modalProfile\"]/div/div/div[2]/div[2]/div[1]/div[1]/a"),
            searchField = new By.ByXPath("//*[@id=\"app\"]/div[2]/input"),
            checkBox = new By.ByXPath("//*[@id=\"isConsentCheckbox\"]"),
            makeOrderModal = new By.ByXPath("//*[@id=\"modalOrderPart\"]/div/div"),
            name = new By.ByXPath("//*[@id=\"order_search_by_num_item_orderSearchByNum_customerFio\"]"),
            email = new By.ByXPath("//*[@id=\"order_search_by_num_item_orderSearchByNum_customerEmail\"]"),
            phoneNumber = new By.ByXPath("//*[@id=\"order_search_by_num_item_orderSearchByNum_customerPhone\"]"),
            city = new By.ByXPath("//*[@id=\"formMakeSimpleOrder\"]/div[5]/div/div[1]/div[1]/input"),
            firstCity = new By.ByXPath("//*[@id=\"formMakeSimpleOrder\"]/div[5]/div/div[1]/div[2]/ul/li[1]/label/span"),
            orderConfirmationModal = new By.ByXPath("//*[@id=\"modalOrderDone\"]/div");

    public SearchByNumberPage() {
    }

    public SearchByNumberPage clickOnBuyButton(String shopName) {
        int tr = 1;
        WebElement a = null;

        do {
            if (tr != 5) {
                a = getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody/tr["
                        + tr + "]/td[7]/div[2]/span/a/span[1]"));
            }
            tr++;
        } while (!a.getText().equals(shopName));

        getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody/tr["
                + tr + "]/td[6]/div/button")).click();
        return this;
    }

    public SearchByNumberPage search(String number) {
        WebElement input = getElement(searchField);
        inputText(input, number);
        input.sendKeys(Keys.ENTER);
        return this;
    }

    public SearchByNumberPage clickOnSubmittBuyButton() {
        getElement(submittBuyButton).click();
        return this;
    }

    public String getConfirmMessage() {
        return getElement(confirmMessage).getText() + getElement(goToCabinet).getText();
    }

    public SearchByNumberPage clickoOnCheckBox() {
        getElement(checkBox).click();
        return this;
    }

    public boolean isMakeOrderModalVisible(){
        return isVisible(getElement(makeOrderModal));
    }

    public boolean isOrderConfirmationModalVisible(){
        return isVisible(getElement(orderConfirmationModal));
    }

    public SearchByNumberPage typeName(String username){
        inputText(getElement(name), username);
        return this;
    }

    public SearchByNumberPage typeEmail(String mail){
        inputText(getElement(email), mail);
        return this;
    }

    public SearchByNumberPage typePhoneNumber(String phone){
        inputText(getElement(phoneNumber), phone);
        return this;
    }

    public SearchByNumberPage chooseCity(){
        getElement(city).click();
        getElement(firstCity).click();
        return this;
    }
}
