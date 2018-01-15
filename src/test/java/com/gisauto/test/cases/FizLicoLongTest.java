package com.gisauto.test.cases;

import com.gisauto.pageObjects.HomePage;
import com.gisauto.pageObjects.Profile;
import com.gisauto.pageObjects.SearchByNumberPage;
import com.gisauto.pageObjects.YandexMailPage;
import com.gisauto.utils.PF;
import com.gisauto.utils.TestMain;
import com.gisauto.utils.annotations.TargetBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@TargetBrowser(browser = "F")
public class FizLicoLongTest extends TestMain {

    private HomePage homePage;
    private Profile profile;
    private SearchByNumberPage searchByNumberPage;
    private YandexMailPage yandexMailPage;

    public void prepare() {
        homePage = PF.getPage(HomePage.class);
    }

    @Test
    @DisplayName(value = "Длинный тест физ.лица")
    public void process() {
//        homePage.clickOnSelectCity();
//        Assert.assertEquals("Модальное окно расположения открыто",
//                true,
//                homePage.isCityVisible());
//        homePage.clickAny();
//        Assert.assertEquals("Модальное окно расположения скрыто",
//                true,
//                !homePage.isCityVisible());


        profile = ((HomePage) homePage
                .clickOnDropDown())
                .loginAs(TEST_EMAIL, TEST_EMAIL_PASSWORD);

        searchByNumberPage = profile.clickOnSearchByNumber();
        searchByNumberPage
                .search("079103383BB")
                .clickOnBuyButton("Светлый")
                .clickOnSubmittBuyButton();

        Assert.assertEquals("ваш заказ на прокладка гбц отправлен продавцу\n" +
                        "моймагвы получите на e-mail " + TEST_EMAIL + " уведомления о вашем заказе",
                searchByNumberPage.getConfirmMessage().trim().toLowerCase());

        yandexMailPage = PF.getPage(YandexMailPage.class);
        yandexMailPage
                .loginAs(TEST_EMAIL, TEST_EMAIL_PASSWORD)
                .clickOnLastMessage();

        Assert.assertEquals("здравствуйте. вы отправили запрос на запчасть."
                , yandexMailPage.getMessage().trim().toLowerCase());
    }

}
