package com.gisauto.stepdefs;

import com.gisauto.pageObjects.gisauto.Profile;
import com.gisauto.pageObjects.gisauto.Reviews;
import com.gisauto.pageObjects.gisauto.SearchByNumberPage;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;

public class TestFeedbackStepDefs {


    @Если("^пользователь нажимает на отзывы$")
    public void пользовательНажимаетНаОтзывы() {
        PF.getPage(Reviews.class).clickOnFeedbackButton();
    }

    @Если("^пользователь нажимает отзывы обо мне$")
    public void пользовательНажимаетОтзывыОбоМне() {
        PF.getPage(Reviews.class).clickOnFeedbackAboutMe();
    }


    @Если("^пользователь нажимает мои отзывы$")
    public void пользовательНажимаетМоиОтзывы() {
        PF.getPage(Reviews.class).clickOnMyFeedback();
    }

    @Если("^пользователь открывает отзывы о магазине$")
    public void пользовательОткрываетОтзывыОМагазине() {
        PF.getPage(Reviews.class).clickOnShopFeedbacksButton();
    }

    @Если("^пользователь нажимает ответить на отзыв$")
    public void пользовательНажимаетОтветитьНаОтзыв() {
        PF.getPage(Reviews.class).clickOnAnswerFeedbackButton();

    }

    @Если("^пользователь вводит текст ответа на отзыв \"([^\"]*)\"$")
    public void пользовательВводитТекстОтветаНаОтзыв(String answer) {
        PF.getPage(Reviews.class).typeFeedbackAnswer(answer);
    }

    @Если("^пользователь нажимает кнопку отправить ответ$")
    public void пользовательНажимаетКнопкуОтправитьОтвет() {
        PF.getPage(Reviews.class).clickOnSendAnswerButton();
    }

    @Если("^пользователь нажимает пожаловаться на отзыв$")
    public void пользовательНажимаетПожаловатьсяНаОтзыв() {
        PF.getPage(Reviews.class).clickOnComplainFeedbackButton();
    }

    @Если("^пользователь нажимает другая причина$")
    public void пользовательНажимаетДругаяПричина() {
        PF.getPage(Reviews.class).clickOnOtherReasonButton();
    }

    @Если("^пользователь вводит текст жалобы \"([^\"]*)\"$")
    public void пользовательВводитТекстЖалобы(String complaint) {
        PF.getPage(Reviews.class).typeComplaintText(complaint);
    }

    @Если("^пользователь нажимает отправить жалобу$")
    public void пользовательНажимаетОтправитьЖалобу() {
        PF.getPage(Reviews.class).clickOnSendComplaintButton();
    }

}
