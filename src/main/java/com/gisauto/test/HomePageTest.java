package com.gisauto.test;

import com.gisauto.pageObjects.HomePage;
import com.gisauto.pageObjects.SearchByNumberPage;
import com.gisauto.utils.ConditionChecker;
import com.gisauto.utils.PF;
import com.gisauto.utils.TargetBrowser;
import com.gisauto.utils.TestMain;

@TargetBrowser(browser = "GoogleChrome")
public class HomePageTest extends TestMain {

    private final String login = "testfiz@test.com", password = "111111";
    private HomePage homePage;
    private SearchByNumberPage searchByNumberPage;

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
        searchByNumberPage = homePage.clickOnSearchByNumber();
        await(2000);
        searchByNumberPage.search();
        await(2000);
        searchByNumberPage.makeBuy();
        //TODO: 11.12.2017 artem.neradko - дописать тест для физ.лица
    }

    public void validate() {
        super.validate();
    }

}
