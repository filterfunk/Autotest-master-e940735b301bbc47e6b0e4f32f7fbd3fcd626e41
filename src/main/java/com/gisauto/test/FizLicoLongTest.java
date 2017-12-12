package com.gisauto.test;

import com.gisauto.pageObjects.HomePage;
import com.gisauto.pageObjects.SearchByNumberPage;
import com.gisauto.utils.ConditionChecker;
import com.gisauto.utils.PF;
import com.gisauto.utils.TargetBrowser;
import com.gisauto.utils.TestMain;

@TargetBrowser(browser = "FireFox")
public class FizLicoLongTest extends TestMain {

    private HomePage homePage;
    private SearchByNumberPage searchByNumberPage;

    public void prepare() {
        homePage = PF.getPage(HomePage.class);
    }

    public void process() {
        homePage.clickOnSelectCity();
        await(1000);
        homePage.clickAny();
        await(1000);
        homePage.clickOnDropDown();
        await(300);
        homePage.loginAs(TEST_EMAIL, TEST_EMAIL_PASSWORD);
        await(2000);
        searchByNumberPage = homePage.clickOnSearchByNumber();
        await(2000);
        searchByNumberPage.search();
        await(2000);
        searchByNumberPage.clickOnBuyButton();
        await(400);
        searchByNumberPage.clickOnSubmittBuyButton();
        await(300);
        ConditionChecker.addCheckString("ваш заказ на прокладка гбц отправлен продавцу\n" +
                "testвы получите на e-mail " + TEST_EMAIL + " уведомления о вашем заказе",
                searchByNumberPage.getConfirmMessage().trim().toLowerCase());
    }

}
