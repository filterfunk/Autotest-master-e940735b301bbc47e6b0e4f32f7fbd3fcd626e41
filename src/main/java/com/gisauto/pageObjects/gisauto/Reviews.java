package com.gisauto.pageObjects.gisauto;

import com.gisauto.utils.PF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Reviews extends BasePage {


    @FindBy(xpath = "//*[@id=\"topBlock\"]/nav/ul/li[6]/a/span")
    private WebElement feedbackButton;

    @FindBy(xpath = "//*[@id=\"cabinet-reviews\"]//div[@class=\"answer-complain a-like\"]")
    private WebElement complainFeedbackButton;

    @FindBy(xpath = "//*[@id=\"cabinet-reviews\"]/div/div/div/div[5]/form/button")
    private WebElement answerFeedbackButton;

    @FindBy(xpath = "//*[@id=\"mainWin\"]/div[1]/ul/li[1]/a")
    private WebElement feedbackAboutMe;

    @FindBy(xpath = "//*[@id=\"mainWin\"]/div[1]/ul/li[2]/a")
    private WebElement myFeedback;

    @FindBy(xpath = "//*[@id=\"cabinet-reviews\"]/div/div/div/div[5]/form/button")
    private WebElement sendAnswerButton;

    @FindBy(xpath = "//*[@id=\"feedbackClaimForm\"]/div/div[3]/label")
    private WebElement otherReasonButton;

    @FindBy(xpath = "//*[@id=\"feedbackClaimForm\"]/button")
    private WebElement sendComplaintButton;

    @FindBy(xpath = "//*[@id=\"cabinet-reviews\"]/div/div/div/div[5]/form/textarea")
    private WebElement feedbackAnswer;

    @FindBy(xpath = "//*[@id=\"feedback_recipientClaimToModerator\"]")
    private WebElement complaintText;
                     //*[@id="categories-wrapper"]/tbody[2]/tr[1]/td[7]/div[2]/svg/path
    @FindBy(xpath = "//*[@id=\"categories-wrapper\"]/tbody[2]/tr[1]/td[7]/div[2]")
    private WebElement shopFeedbacksButton;


    public Reviews clickOnFeedbackButton() {
        feedbackButton.click();
        return this;

    }

    public Reviews clickOnComplainFeedbackButton() {
        await(2000);
        getElement(new By.ByXPath("//*[@id=\"cabinet-reviews\"]/div/div[" +
                getFeedback(PF.getPage(SearchByNumberPage.class).getAdditioanalFeedback()) +
                "]/div/div[5]/div[2]"))
                .click();
        return this;


    }

    public Reviews clickOnAnswerFeedbackButton() {
        answerFeedbackButton.click();
        await(1000);
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
        await(2000);
        otherReasonButton.click();
        return this;

    }

    public Reviews clickOnSendComplaintButton() {
        sendComplaintButton.click();
        return this;

    }

    public Reviews typeFeedbackAnswer(String feedback) {
        inputText(getElement(new By.ByXPath("// *[@id=\"cabinet-reviews\"]/div/div[" +
                getFeedback(PF.getPage(SearchByNumberPage.class).getAdditioanalFeedback()) + "]/div/div[5]/form/button")), feedback);
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

    private int getFeedback(String message) {
        int div = 0;
        String text;
        do {
            div++;
            text = getElement(new By.ByXPath("//*[@id=\"cabinet-reviews\"]/div/div[" + div + "]/div/div[4]/div")).getText();
        } while (!text.equals(message));
        return div;
    }
}
