package com.gisauto.stepdefs;

import com.gisauto.pageObjects.admin.AdminBasePage;
import com.gisauto.pageObjects.admin.AdminLoginPage;
import com.gisauto.pageObjects.admin.FeedbackModerationPage;
import com.gisauto.pageObjects.gisauto.SearchByNumberPage;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;

public class AdminStepDefs {

    @Если("^пользователь заходит в админку$")
    public void пользовательЗаходитВАдминку() {
        PF.getPageForce(AdminLoginPage.class).loginAs(null, null);
    }

    @И("^пользователь нажимает на модерацию отзывов$")
    public void пользовательНажимаетНаМодерациюОтзывов() {
        PF.getPage(AdminBasePage.class).clickOnFeedbackModeration();
    }

    @И("^пользователь нажимает на кнопку принять$")
    public void пользовательНажимаетНаКнопкуПринять() {
        PF.getPage(FeedbackModerationPage.class)
                .clickOnAcceptFeedback(PF.getPage(SearchByNumberPage.class).getAdditioanalFeedback());
    }

    @И("^пользователь нажимает на кнопку отклонить$")
    public void пользовательНажимаетНаКнопкуОтклонить() {
        PF.getPage(FeedbackModerationPage.class)
                .clickOnDeclineFeedback(PF.getPage(SearchByNumberPage.class).getAdditioanalFeedback());
    }


}
