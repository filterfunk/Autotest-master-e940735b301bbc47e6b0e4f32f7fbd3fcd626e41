package com.gisauto.stepdefs;

import com.gisauto.pageObjects.SearchByNumberPage;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;

public class SearchByNumberStepDefs {

    @Если("^пользователь вводит в поиск \"([^\"]*)\"$")
    public void пользовательВводитВПоиск(String number) {
        PF.getPage(SearchByNumberPage.class).search(number);
    }

    @То("^система редиректит на страницу \"([^\"]*)\"$")
    public void системаРедиректитНаСтраницу(String title){
        PF.getPage(SearchByNumberPage.class).checkTitle(title);
    }

    @Если("^пользователь нажимает заказать у \"([^\"]*)\"$")
    public void пользовательНажимаетЗаказать(String seller){
        PF.getPage(SearchByNumberPage.class).clickOnBuyButton(seller);
    }

    @То("^появляется модалка заказать")
    public void появляетсяМодалкаЗаказать(){
        Assert
                .assertEquals("Модалка заказть видима ", true,
                        PF.getPage(SearchByNumberPage.class).isMakeOrderModalVisible());
    }

    @Если("^пользователь выбирает город вводит \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" нажимает на чекбокс и заказать")
    public void пользовтельВыбираетГородВводитИмяПочтуТелефонНажимаетНаЧекБоксИЗаказать(String name, String email, String number){
        PF.getPage(SearchByNumberPage.class)
                .typeName(name)
                .chooseCity()
                .typeEmail(email)
                .typePhoneNumber(number)
                .clickoOnCheckBox()
                .clickOnSubmittBuyButton();
    }

    @То("^модалка заказать закрывается и появляется модалка с подтверждением")
    public void модалкаЗаказатьЗакрываетсяИПоявляетсяМодалкаСПодтверждением(){
        Assert
                .assertEquals("Модалка заказть закрыта ", true,
                        !PF.getPage(SearchByNumberPage.class).isMakeOrderModalVisible());

        Assert
                .assertEquals("Модалка подтверждения видима", true,
                        PF.getPage(SearchByNumberPage.class).isOrderConfirmationModalVisible());
    }

}
