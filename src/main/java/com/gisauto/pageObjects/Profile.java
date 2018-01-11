package com.gisauto.pageObjects;

import org.openqa.selenium.By;

public class Profile extends BasePage {

    private final By.ByXPath searchByNumber = new By.ByXPath("/html/body/div[1]/div[1]/nav/ul/li[1]/a");

    public Profile() {
        openPage("https://beta.gisauto.ru/cabinet/wrench/profile");
        if (!checkTitle("Автозапчасти России - Настройки - Мой профиль")) {
            throw new IllegalStateException("Открытая страница не является страницей профиля");
        }
    }

}
