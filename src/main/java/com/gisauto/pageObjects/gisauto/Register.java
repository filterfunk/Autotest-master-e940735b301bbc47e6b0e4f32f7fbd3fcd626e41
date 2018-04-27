package com.gisauto.pageObjects.gisauto;

import com.gisauto.utils.PF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register extends BasePage {

    private By organization = new By.ByXPath("//*[@id=\"formRegistration\"]/div/div[1]/div[1]"),
            fizLico = new By.ByXPath("//*[@id=\"formRegistration\"]/div/div[1]/div[2]"),
            email = new By.ByXPath("//*[@id=\"registration_user_username\"]"),
            password = new By.ByXPath("//*[@id=\"registration_user_password_password\"]"),
            passwordConfirm = new By.ByXPath("//*[@id=\"registration_user_password_confirm\"]"),
            orgName = new By.ByXPath("//*[@id=\"registration_organizationName\"]"),
            submittButton = new By.ByXPath("//*[@id=\"formRegistration\"]/div/div[2]/div[9]/div/button");


    @FindBy(xpath = "//*[@id=\"req-agreement\"]")
    private WebElement acceptOfferButton;

    public Register clickOnOrganization() {
        getElement(organization).click();
        return this;
    }

    public Register clickOnFizLico() {
        getElement(fizLico).click();
        return this;
    }

    public Register typeEmail(String eMail) {
        inputText(getElement(email), eMail);
        return this;
    }

    @Override
    public Register typePassword(String pass) {
        inputText(getElement(password), pass);
        return this;
    }

    public Register typePasswordConfirm(String passConfirm) {
        inputText(getElement(passwordConfirm), passConfirm);
        return this;
    }

    public Register typeOrganizationName(String organizationName) {
        inputText(getElement(orgName), organizationName);
        return this;
    }

    public Profile submitt() {
        getElement(submittButton).click();
        return PF.getPage(Profile.class);
    }

    public boolean isFizLicoElementsVisible() {
        return isVisible(email)
                && isVisible(password)
                && isVisible(passwordConfirm)
                && isVisible(submittButton);
    }

    public boolean isOrgElementsVisible() {
        return isVisible(email)
                && isVisible(password)
                && isVisible(passwordConfirm)
                && isVisible(orgName)
                && isVisible(submittButton);
    }

    public Register clickOnAcceptOfferButton() {
        acceptOfferButton.click();
        return this;
    }

}
