package com.gisauto.pageObjects.gisauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Reviews extends BasePage {


    @FindBy(xpath = "//*[@id=\"categories-wrapper\"]/tbody[2]/tr[1]/td[7]/div[2]/svg/path")
    private WebElement feedbackButton;

    @FindBy(xpath = "//*[@id=\"cabinet-reviews\"]/div/div/div/div[5]/div[2]")
    private WebElement complainFeedbackButton;

    @FindBy(xpath = "//*[@id=\"cabinet-reviews\"]/div/div/div/div[5]/form/button")
    private WebElement answerFeedbackButton;

    @FindBy(xpath = "//*[@id=\"mainWin\"]/div[1]/ul/li[1]/a")
    private WebElement feedbackAboutMe;

    @FindBy(xpath = "//*[@id=\"mainWin\"]/div[1]/ul/li[2]/a")
    private WebElement myFeedback;

    @FindBy(xpath = "//*[@id=\"cabinet-reviews\"]/div/div/div/div[5]/form/button")
    private WebElement sendAnswerButton;

    @FindBy(xpath = "//*[@id=\"feedbackClaimForm\"]/div/div[3]/span")
    private WebElement otherReasonButton;

    @FindBy(xpath = "//*[@id=\"feedbackClaimForm\"]/button")
    private WebElement sendComplaintButton;

    @FindBy(xpath = "//*[@id=\"cabinet-reviews\"]/div/div/div/div[5]/form/textarea")
    private WebElement feedbackAnswer;

    @FindBy(xpath = "//*[@id=\"feedback_recipientClaimToModerator\"]")
    private WebElement complaintText;

    @FindBy(xpath = "//*[@id=\"categories-wrapper\"]/tbody[2]/tr[1]/td[7]/div[2]/svg/path")
    private WebElement shopFeedbacksButton;


    public Reviews clickOnFeedbackButton() {
        feedbackButton.click();
        return this;

    }

    public Reviews clickOnComplainFeedbackButton() {
        complainFeedbackButton.click();
        return this;


    }

    public Reviews clickOnAnswerFeedbackButton() {
        answerFeedbackButton.click();
        return this;

    }

    public Reviews clickOnFeedbackAboutMe() {
        feedbackAboutMe.click();
        return this;

    }

    public Reviews clickOnMyFeedback() {
        myFeedback.click();
        return this;

    }

    public Reviews clickOnSendAnswerButton() {
        sendAnswerButton.click();
        return this;

    }

    public Reviews clickOnOtherReasonButton() {
        otherReasonButton.click();
        return this;

    }

    public Reviews clickOnSendComplaintButton() {
        sendComplaintButton.click();
        return this;

    }

    public Reviews typeFeedbackAnswer(String feedback) {
        inputText(feedbackAnswer, feedback);
        return this;
    }


    public Reviews typeComplaintText(String complaint) {
        inputText(complaintText, complaint);
        return this;
    }

    public Reviews clickOnShopFeedbacksButton() {
        shopFeedbacksButton.click();
        return this;
    }
}
