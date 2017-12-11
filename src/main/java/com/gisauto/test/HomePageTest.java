package com.gisauto.test;

import com.gisauto.pageObjects.HomePage;
import com.gisauto.utils.PF;
import com.gisauto.utils.TargetBrowser;
import com.gisauto.utils.TestMain;
import org.junit.Assert;

@TargetBrowser(browser = "FireFox")
public class HomePageTest extends TestMain {

    private final String login = "testfiz@test.com", password = "111111";
    private HomePage homePage;


    public void prepare() {
        homePage = PF.getPage(HomePage.class);
    }

    public void test() {
        homePage.clickOnSelectCity();
        await(1000);
        homePage.clickAny();
        await(1000);
        homePage.clickOnDropDown();
        homePage.loginAs(login, password);
        await(2000);
    }

    public void validate() {
        Assert.assertEquals("Wrong page.",
                "Автозапчасти России - Настройки - Мой профиль",
                driver.getTitle());
    }

}
