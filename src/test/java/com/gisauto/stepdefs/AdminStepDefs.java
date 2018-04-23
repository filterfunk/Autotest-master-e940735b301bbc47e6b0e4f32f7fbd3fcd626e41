package com.gisauto.stepdefs;

import com.gisauto.pageObjects.admin.AdminBasePage;
import com.gisauto.pageObjects.admin.AdminLoginPage;
import com.gisauto.pageObjects.admin.FeedbackModerationPage;
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

    @И("^пользователь нажимает на кнопку принять \"([^\"]*)\"$")
    public void пользовательНажимаетНаКнопкуПринять(String messsage) {
        PF.getPage(FeedbackModerationPage.class).clickOnAcceptFeedback(messsage);
    }

    @И("^пользователь нажимает на кнопку отклонить \"([^\"]*)\"$")
    public void пользовательНажимаетНаКнопкуОтклонить(String messsage) {
        PF.getPage(FeedbackModerationPage.class).clickOnDeclineFeedback(messsage);
    }


}
