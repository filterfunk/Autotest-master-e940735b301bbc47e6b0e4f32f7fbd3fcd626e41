package com.gisauto.test.cases;

import com.gisauto.pageObjects.HomePage;
import com.gisauto.pageObjects.SearchByNumberPage;
import com.gisauto.pageObjects.YandexMailPage;
import com.gisauto.utils.PF;
import com.gisauto.utils.TestMain;
import com.gisauto.utils.annotations.TargetBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@TargetBrowser(browser = "FireFox")
@DisplayName(value = "Длинный тест физ.лица")
public class FizLicoLongTest extends TestMain {

    private HomePage homePage;
    private SearchByNumberPage searchByNumberPage;
    private YandexMailPage yandexMailPage;

    public void prepare() {
        homePage = PF.getPage(HomePage.class);
    }

    @Test
    @DisplayName(value = "Длинный тест физ.лица")
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
        searchByNumberPage.search("079103383BB");
        await(2000);
        searchByNumberPage.clickOnBuyButton("МОЙМАГ");
        await(600);
        searchByNumberPage.clickOnSubmittBuyButton();
        await(600);

        Assert.assertEquals("ваш заказ на прокладка гбц отправлен продавцу\n" +
                        "моймагвы получите на e-mail " + TEST_EMAIL + " уведомления о вашем заказе",
                searchByNumberPage.getConfirmMessage().trim().toLowerCase());

        yandexMailPage = PF.getPage(YandexMailPage.class);
        await(1000);
        yandexMailPage.loginAs(TEST_EMAIL, TEST_EMAIL_PASSWORD);
        await(5000);
        yandexMailPage.clickOnLastMessage();
        await(2000);

        Assert.assertEquals("здравствуйте. вы отправили запрос на запчасть."
                , yandexMailPage.getMessage().trim().toLowerCase());
    }

}
