package com.gisauto.pageObjects;

import org.openqa.selenium.By;

public class YandexMailPage extends Page {

    private By message = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[2]/div[4]/div/div[2]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div/div/a"),
            loginButton = new By.ByXPath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/form/div[4]/button[1]"),
            loginField = new By.ByXPath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/form/div[1]/label/input"),
            passwordField = new By.ByXPath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/form/div[2]/label/input"),
            messageField = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[2]/div[4]/div/div[2]/div[3]/div[2]/div[5]/div[1]/div/div[3]/div");

    public YandexMailPage() {
        openPage("https://passport.yandex.ru/auth?retpath=https%3A%2F%2Fmail.yandex.ru%2F%3Fconnection_id%3Diface-1513054766675-02035703&backpath=https%3A%2F%2Fmail.yandex.ru%2F%3Fnoretpath%3D1");
        if (!driver.getTitle().contains(("Авторизация"))) {
            throw new IllegalStateException("This page isn't yandex mail page.");
        }
    }

    public YandexMailPage clickOnLastMessage() {
        getElement(message).click();
        return this;
    }

    public YandexMailPage typeLogin(String login) {
        getElement(loginField).sendKeys(login);
        return this;
    }

    public YandexMailPage typePassword(String password) {
        getElement(passwordField).sendKeys(password);
        return this;
    }

    public YandexMailPage clickOnSubmittButton() {
        getElement(loginButton).click();
        return this;
    }

    public String getMessage() {
        return getElement(messageField).getText();
    }

}
