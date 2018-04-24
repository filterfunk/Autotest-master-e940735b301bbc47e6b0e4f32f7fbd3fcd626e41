package com.gisauto.pageObjects.gisauto;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;


    //TODO: описать страницу "Отзывы"

    public class Reviews extends BasePage {

        private final By feedbackButton = new By.ByXPath("//*[@id=\"topBlock\"]/nav/ul/li[6]/a/span"),
                complainFeedbackButton = new By.ByXPath("//*[@id=\"cabinet-reviews\"]/div/div/div/div[5]/div[2]"),
                answerFeedbackButton = new By.ByXPath("//*[@id=\"cabinet-reviews\"]/div/div/div/div[5]/form/button"),
                feedbackAboutMe = new By.ByXPath("//*[@id=\"mainWin\"]/div[1]/ul/li[1]/a"),
                myFeedback = new By.ByXPath("//*[@id=\"mainWin\"]/div[1]/ul/li[2]/a");


    }
