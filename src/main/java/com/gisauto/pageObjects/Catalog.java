package com.gisauto.pageObjects;

import org.openqa.selenium.By;

public class Catalog extends BasePage{

    //Redezign
    private final By searchInput = new By.ByXPath("//*[@id=\"vehicle_number_vehicleNumber\"]"),
                    trucks = new By.ByXPath("//*[@id=\"titleOri\"]"),
                    moto = new By.ByXPath("//*[@id=\"sticker-scroll\"]/section[2]/ul/li[3]/a"),
                    cars = new By.ByXPath("//*[@id=\"sticker-scroll\"]/section[2]/ul/li[1]/a"),
                    popular = new By.ByXPath("//*[@id=\"heavy-car-tab\"]/div[1]/div[1]"),
                    all = new By.ByXPath("//*[@id=\"heavy-car-tab\"]/div[1]/div[2]");

    //TODO: описать страницу "Каталоги запчастей"

}
