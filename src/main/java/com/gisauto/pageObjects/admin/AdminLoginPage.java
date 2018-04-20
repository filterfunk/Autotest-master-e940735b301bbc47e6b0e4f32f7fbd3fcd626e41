package com.gisauto.pageObjects.admin;

import com.gisauto.utils.PF;
import org.openqa.selenium.By;

/**
 * @autor neradko, created on 20.04.18
 */

public class AdminLoginPage extends AdminBasePage {

    public AdminLoginPage(){
        openPage("https://admin.beta.gisauto.ru");
    }

    private final By loginInput = new By.ByXPath("//*[@id=\"formLogin\"]//input[@type=\"text\"]"),
            passwordInput = new By.ByXPath("//*[@id=\"formLogin\"]//input[@type=\"password\"]"),
            loginButton = new By.ByXPath("//*[@id=\"formLogin\"]//button");
    private static final String LOGIN = "office@gisauto.ru", PASSWORD = "4C2JY9fa";

    public AdminLoginPage typeLogin(String login){
        inputText(getElement(loginInput), login == null ? LOGIN : login);
        return this;
    }

    public AdminLoginPage typePassword(String password){
        inputText(getElement(passwordInput), password == null ? PASSWORD : password);
        return this;
    }

    public AdminBasePage clickOnLogInButton(){
        getElement(loginButton).click();
        return PF.getPage(AdminBasePage.class);
    }

    public AdminBasePage loginAs(String login, String password){
        return typeLogin(login).typePassword(password).clickOnLogInButton();
    }

}
