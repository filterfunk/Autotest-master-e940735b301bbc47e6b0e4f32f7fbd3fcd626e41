package com.gisauto.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

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
            orderConfirmCheckBox = new By.ByXPath("//*[@class=\"__checkbox\"][@id=\"confirmOrderModalCeckbox\"]"),
            orderConfirmSendButton = new By.ByXPath("//*[@id=\"order_confirm_button\"]"),
            orderConfirmFirstCity = new By.ByXPath("//*[@id=\"confirmOrderForm\"]/div[2]/div[2]/div/div[1]/div[2]/ul/li[1]/label"),
            orderConfirmSentModal = new By.ByXPath("//*[@id=\"modalCartDone\"]/div/div/div"),
            closeModalButton = new By.ByXPath("//*[@id=\"modalOrderDone\"]/div/div/div[2]/button");

    public SearchByNumberPage clickOnBuyButton(String shopName) {
        await(500);
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
                        + tr + "]/td[7]/div[2]/span/a/span[1]"));
            } catch (Exception e) {
                e.printStackTrace();
                return getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr/td[7]/div["
                        + "3]/span/span[1]")).getText().equals(shopName) ? -1 : -2;
            }
        } while (!a.getText().equals(shopName));
        return tr;
    }

    private WebElement getSellerOrder(String shopName) {
        int tr = getSellerTr(shopName);
        switch (tr) {
            case -1:
                return getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr/td[6]/div[2]/button"));
            case -2:
                throw new RuntimeException("Не удалось найти продавца " + shopName);
            default:
                return getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr[" + tr + "]/td[6]/div[2]/button"));
        }
    }

    private WebElement getSellerCart(String shopName) {
        int tr = getSellerTr(shopName);
        switch (tr) {
            case -1:
                return getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr/td[6]/div/div[1]"));
            case -2:
                throw new RuntimeException("Не удалось найти продавца " + shopName);
            default:
                return getElement(new By.ByXPath("//*[@id=\"categories-wrapper\"]/tbody[2]/tr[" + tr + "]/td[6]/div/div[1]"));
        }

    }

    public SearchByNumberPage clickOnAddToCart(String shopName) {
        await(500);
        getSellerCart(shopName).click();
        return this;
    }

    public SearchByNumberPage search(String number) {
        WebElement input = getElement(searchField);
        inputText(input, number);
        await(500);
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

    public boolean checkOrder(String shopName) {
        return isOrderExist(shopName);
    }

    private boolean isOrderExist(String shopName) {
        List<WebElement> list = getElements(new By.ByXPath("//*[@class=\"t-number__more aqualink seller-info\"]"));

        for (WebElement we : list) {
            if (we.getText().equals(shopName)) return true;
        }
        return false;
    }

}