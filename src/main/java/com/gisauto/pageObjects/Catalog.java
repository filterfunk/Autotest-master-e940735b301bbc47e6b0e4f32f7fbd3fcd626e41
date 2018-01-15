package com.gisauto.pageObjects;

import org.openqa.selenium.By;

public class Catalog extends BasePage{

    private final By searchInput = new By.ByXPath("//*[@id=\"vehicle_number_vehicleNumber\"]"),
                    trucks = new By.ByXPath("//*[@id=\"titleOri\"]"),
                    moto = new By.ByXPath("//*[@id=\"sticker-scroll\"]/section[2]/ul/li[3]/a"),
                    cars = new By.ByXPath("//*[@id=\"sticker-scroll\"]/section[2]/ul/li[1]/a"),
                    popular = new By.ByXPath("//*[@id=\"heavy-car-tab\"]/div[1]/div[1]"),
                    all = new By.ByXPath("//*[@id=\"heavy-car-tab\"]/div[1]/div[2]"),
                    alfaRomeo = new By.ByXPath("//*[@id=\"light-car-tab\"]/div[2]/div/div[4]/div"),
                    alfaRomeoOriginal = new By.ByXPath("//*[@id=\"light-car-tab\"]/div[2]/div/div[4]/div/div/div[1]/a"),
                    alfaRomeoSurrogate = new By.ByXPath("//*[@id=\"light-car-tab\"]/div[2]/div/div[4]/div/div/div[2]/a");

    public Catalog clickOnAlfaRomeo(){
        getElement(alfaRomeo).click();
        return this;
    }

    public Catalog clickOnSearchInput(){
        getElement(searchInput).click();
        return this;
    }

    public Catalog clickOnTrucks(){
        getElement(trucks).click();
        return this;
    }

    public Catalog clickOnMoto(){
        getElement(moto).click();
        return this;
    }

    public Catalog clickOnCars(){
        getElement(cars).click();
        return this;
    }

    public Catalog clickOnPopular(){
        getElement(popular).click();
        return this;
    }

    public Catalog clickOnAll(){
        getElement(all).click();
        return this;
    }

    public Catalog clickOnAlfaRomeoOriginal(){
        getElement(alfaRomeoOriginal).click();
        return this;
    }

    public Catalog clickOnAlfaRomeoSurrogate(){
        getElement(alfaRomeoSurrogate).click();
        return this;
    }

}
