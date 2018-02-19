package com.gisauto.pageObjects;

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

    private By submitBuyButton = new By.ByXPath("//*[@id=\"sendShopOrderButton\"]"),
            cartConfirmCheckBox = new By.ByXPath("//*[@id=\"confirmOrderModalCeckbox\"]"),
            sendOrders = new By.ByXPath("//*[@id=\"modalCart\"]/div/div/div[1]/div[2]/div/button[2]"),
            confirmMessage = new By.ByXPath("/html/body/div[6]/div/div/div/div[1]/div[1]/div[2]/div[1]"),
            goToCabinet = new By.ByXPath("//*[@id=\"modalProfile\"]/div/div/div[2]/div[2]/div[1]/div[1]/a"),
            searchField = new By.ByXPath("//*[@id=\"app\"]/div[2]/input"),
            checkBox = new By.ByXPath("//*[@id=\"formMakeSimpleOrder\"]/div[9]/div"),
            makeOrderModal = new By.ByXPath("//*[@id=\"modalOrderPart\"]/div/div"),
            name = new By.ByXPath("//*[@id=\"order_search_by_num_item_orderSearchByNum_customerFio\"]"),
            email = new By.ByXPath("//*[@id=\"order_search_by_num_item_orderSearchByNum_customerEmail\"]"),
            phoneNumber = new By.ByXPath("//*[@id=\"order_search_by_num_item_orderSearchByNum_customerPhone\"]"),
            city = new By.ByXPath("//*[@id=\"formMakeSimpleOrder\"]/div[5]/div/div[1]/div[1]/input"),
            firstCity = new By.ByXPath("//*[@id=\"formMakeSimpleOrder\"]/div[5]/div/div[1]/div[2]/ul/li[1]/label/span"),
            orderConfirmationModal = new By.ByXPath("//*[@id=\"modalOrderDone\"]/div"),
            orderConfirmName = new By.ByXPath("//*[@id=\"confirm_order_name\"]"),
            orderConfirmCity = new By.ByXPath("//*[@id=\"confirmOrderForm\"]/div[2]/div[2]/div/div[1]/div[1]/input"),
            orderConfirmMail = new By.ByXPath("//*[@id=\"confirm_order_email\"]"),
            orderConfirmPhone = new By.ByXPath("//*[@id=\"confirm_order_phone\"]"),
            orderConfirmCheckBox = new By.ByXPath("//*[@id=\"confirmOrderModalCeckbox\"]"),
            orderConfirmSendButton = new By.ByXPath("//*[@id=\"order_confirm_button\"]"),
            orderConfirmFirstCity = new By.ByXPath("//*[@id=\"confirmOrderForm\"]/div[2]/div[2]/div/div[1]/div[2]/ul/li[1]/label"),
            orderConfirmSentModal = new By.ByXPath("//*[@id=\"modalCartDone\"]/div/div/div"),
            closeModalButton = new By.ByXPath("//*[@id=\"modalOrderDone\"]/div/div/div[2]/button");

    public SearchByNumberPage clickOnBuyButton(String shopName) {
        getSellerOrder(shopName).click();
        return this;
    }

    public SearchByNumberPage clickOnSendOrdersButton() {
        getElement(sendOrders).click();
        return this;
    }

    public SearchByNumberPage clickOnCartConfirmCheckBox() {
        getElement(cartConfirmCheckBox).click();
        return this;
    }

    public SearchByNumberPage typeCartName(String name) {
        inputText(getElement(orderConfirmName), name);
        return this;
    }

    public SearchByNumberPage typeCartEmail(String mail) {
        inputText(getElement(orderConfirmMail), mail);
        return this;
    }

    public SearchByNumberPage typeCartPhone(String phone) {
        inputText(getElement(orderConfirmPhone), phone);
        return this;
    }

    public SearchByNumberPage clickOnOrderConfirmFirstCity() {
        getElement(orderConfirmFirstCity).click();
        return this;
    }

    public SearchByNumberPage clickOnOrderConfirSendButton() {
        getElement(orderConfirmSendButton).click();
        return this;
    }

    public SearchByNumberPage clickOnOrderConfirmSelectCity() {
        getElement(orderConfirmCity).click();
        return this;
    }

    public SearchByNumberPage clickOnOrderConfirmCheckBox() {
        getElement(orderConfirmCheckBox).click();
        return this;
    }

    private int getSellerTr(String shopName) {
        int tr = 0;
        WebElement a;
        do {
            tr++;
            try {
                a = getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr["
                        + tr + "]/td[7]/div[" + (1 + tr) + "]/span/a/span[1]"));
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } while (!a.getText().equals(shopName));
        return tr;
    }

    private WebElement getSellerOrder(String shopName) {
        int tr = getSellerTr(shopName);
        switch (tr) {
            case -1:
                return getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr/td[6]/div/button"));
            default:
                return getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr[" + tr + "]/td[6]/div/button"));
        }
    }

    private WebElement getSellerCart(String shopName) {
        int tr = getSellerTr(shopName);
        switch (tr) {
            case -1:
                return getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr/td[6]/div/div[1]"));
            default:
                return getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr[" + tr + "]/td[6]/div/div[1]"));
        }

    }

    public SearchByNumberPage clickOnAddToCart(String shopName) {
        getSellerCart(shopName).click();
        return this;
    }

    public SearchByNumberPage search(String number) {
        WebElement input = getElement(searchField);
        inputText(input, number);
        input.sendKeys(Keys.ENTER);
        return this;
    }

    public SearchByNumberPage clickOnSubmittBuyButton() {
        getElement(submitBuyButton).click();
        return this;
    }

    public SearchByNumberPage clickOnCloseModal() {
        getElement(closeModalButton).click();
        return this;
    }

    public String getConfirmMessage() {
        return getElement(confirmMessage).getText() + getElement(goToCabinet).getText();
    }

    public SearchByNumberPage clickoOnCheckBox() {
        getElement(checkBox).click();
        return this;
    }

    public boolean isMakeOrderModalVisible() {
        return isVisible(getElement(makeOrderModal));
    }

    public boolean isOrderConfirmationModalVisible() {
        return isVisible(getElement(orderConfirmationModal));
    }

    public SearchByNumberPage typeName(String username) {
        inputText(getElement(name), username);
        return this;
    }

    public SearchByNumberPage typeEmail(String mail) {
        inputText(getElement(email), mail);
        return this;
    }

    public SearchByNumberPage typePhoneNumber(String phone) {
        inputText(getElement(phoneNumber), phone);
        return this;
    }

    public SearchByNumberPage chooseCity() {
        getElement(city).click();
        getElement(firstCity).click();
        return this;
    }

    public boolean isOrderCartConfirmSentModalVisible() {
        return isVisible(getElement(orderConfirmSentModal));
    }
}