package com.gisauto.stepdefs;

import com.gisauto.pageObjects.gisauto.SearchByNumberPage;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class TestFeedbackStepDefs {


    @Если("^пользователь нажимает отзывы$")
    public void пользовательНажимаетОтзывы() {
        PF.getPage(SearchByNumberPage.class).clickOnAddFeedbackButton();
    }

    @Если("^пользователь нажимает пожаловаться на отзыв$")
    public void пользовательНажимаетПожаловатьсяНаОтзыв() {
        PF.getPage(SearchByNumberPage.class).clickOnAddFeedbackButton();
    }

    @Если("^пользователь нажимает другая причина$")
    public void пользовательНажимаетДругаяПричина() {
        PF.getPage(SearchByNumberPage.class).clickOnAddFeedbackButton();
    }

    @Если("^пользователь вводит текст жалобы$")
    public void пользовательВводитТекстЖалобы() {
        PF.getPage(SearchByNumberPage.class).clickOnAddFeedbackButton();
    }

    @Если("^пользователь нажимает отправить жалобу$")
    public void пользовательНажимаетОтправитьЖалобу() {
        PF.getPage(SearchByNumberPage.class).clickOnAddFeedbackButton();
    }

}
