package com.gisauto.pageObjects;

import com.gisauto.utils.FileUploader;
import org.openqa.selenium.By;

public class YandexMailPage extends Page {

    private By message = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[3]/div[4]/div/div[2]/div[3]/div[2]/div[6]/div[1]/div/div/div[2]/div/div[1]/div/div/div"),
            loginButton = new By.ByXPath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/form/div[4]/button[1]"),
            loginField = new By.ByXPath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/form/div[1]/label/input"),
            passwordField = new By.ByXPath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/form/div[2]/label/input"),
            messageField = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[3]/div[4]/div/div[2]/div[3]/div[2]/div[6]/div[1]/div/div[3]/div/p"),
            writePost = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[3]/div[4]/div/div[1]/div[2]/div/div/a"),
            recieverInput = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[3]/div[4]/div/div[2]/div[3]/div[2]/div[6]/div/div[1]/div[2]/div[1]/div/div[1]/label/div[3]/div"),
            themeInput = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[3]/div[4]/div/div[2]/div[3]/div[2]/div[6]/div/div[1]/div[2]/div[1]/div/label/div[3]/input"),
            attach = new By.ByXPath("//*[@id=\"nb-1\"]/body/div[3]/div[4]/div/div[2]/div[3]/div[2]/div[6]/div/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[1]/div[4]/div/label[1]/svg"),
            sendButton = new By.ByXPath("//*[@id=\"nb-31\"]");

    public YandexMailPage() {
        openPage("https://passport.yandex.ru/auth?retpath=https%3A%2F%2Fmail.yandex.ru%2F%3Fconnection_id%3Diface-1513054766675-02035703&backpath=https%3A%2F%2Fmail.yandex.ru%2F%3Fnoretpath%3D1");
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

    public YandexMailPage loginAs(String login, String password) {
        return typeLogin(login).typePassword(password).clickOnSubmittButton();
    }

    public String getMessage() {
        return getElement(messageField).getText();
    }

    public YandexMailPage clickOnWritePost() {
        getElement(writePost).click();
        return this;
    }

    public YandexMailPage typeReciever(String text) {
        inputText(getElement(recieverInput), text);
        return this;
    }

    public YandexMailPage typeTheme(String text) {
        inputText(getElement(themeInput), text);
        return this;
    }

    public YandexMailPage attachFile(String path) {
        getElement(attach).click();
        FileUploader.uploadFile(path);
        return this;
    }

    public YandexMailPage sendPost() {
        getElement(sendButton).click();
        return this;
    }

}
