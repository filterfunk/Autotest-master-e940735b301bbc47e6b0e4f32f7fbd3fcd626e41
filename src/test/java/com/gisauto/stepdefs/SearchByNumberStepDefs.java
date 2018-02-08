package com.gisauto.stepdefs;

import com.gisauto.pageObjects.Profile;
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
    public void системаРедиректитНаСтраницу(String title) {
        PF.getPage(SearchByNumberPage.class).checkTitle(title);
    }

    @Если("^пользователь нажимает заказать у \"([^\"]*)\"$")
    public void пользовательНажимаетЗаказать(String seller) {
        PF.getPage(SearchByNumberPage.class).clickOnBuyButton(seller);
    }

    @То("^появляется модалка заказать")
    public void появляетсяМодалкаЗаказать() {
        Assert
                .assertEquals("Модалка заказть видима ", true,
                        PF.getPage(SearchByNumberPage.class).isMakeOrderModalVisible());
    }

    @Если("^пользователь выбирает город вводит \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" нажимает на чекбокс и заказать")
    public void пользовтельВыбираетГородВводитИмяПочтуТелефонНажимаетНаЧекБоксИЗаказать(String name, String email, String number) {
        PF.getPage(SearchByNumberPage.class)
                .typeName(name)
                .chooseCity()
                .typeEmail(email)
                .typePhoneNumber(number)
                .clickoOnCheckBox()
                .clickOnSubmittBuyButton();
    }

    @Если("^пользователь нажимает на чекбокс заказать и закрывает модалку")
    public void пользовательНажимаетНаЧекбоксЗаказатьИЗакрываетМодалку() {
        PF.getPage(SearchByNumberPage.class)
                .clickOnOrderConfirmCheckBox()
                .clickOnSubmittBuyButton()
                .clickOnCloseModal();
    }

    @То("^модалка заказать закрывается и появляется модалка с подтверждением")
    public void модалкаЗаказатьЗакрываетсяИПоявляетсяМодалкаСПодтверждением() {
        Assert
                .assertEquals("Модалка заказть закрыта ", true,
                        !PF.getPage(SearchByNumberPage.class).isMakeOrderModalVisible());

        Assert
                .assertEquals("Модалка подтверждения видима", true,
                        PF.getPage(SearchByNumberPage.class).isOrderConfirmationModalVisible());
    }

    @Если("^пользователь нажимает добавить в корзину у ")
    public void пользовательНажимаетДобавитьВКорзинуУ(String seller) {
        PF.getPage(SearchByNumberPage.class).clickOnAddToCart(seller);
    }

    @Если("^пользователь открывает корзину")
    public void пользовательОткрываетКорзину() {
        PF.getPage(SearchByNumberPage.class).clickOnCart();
    }

    @Если("^пользователь нажимает отправить заказы")
    public void пользовательНажимаетОтправитьЗаказы() {
        PF.getPage(SearchByNumberPage.class).clickOnSubmittBuyButton();
    }

    @Если("^пользователь заполняет поля нажимает на чекбокс и отправить")
    public void пользовательЗаполняетПоляНажимаетНаЧекбоксИОтправить(String name, String email, String phone) {
        PF.getPage(SearchByNumberPage.class)
                .typeCartName(name)
                .clickOnOrderConfirmSelectCity()
                .clickOnOrderConfirmFirstCity()
                .typeCartEmail(email)
                .typeCartPhone(phone)
                .clickOnOrderConfirmCheckBox()
                .clickOnOrderConfirSendButton();
    }

    @То("^появляется модалка с подтверждением")
    public void появляетсяМодалкаСПодтверждением() {
        Assert
                .assertEquals("Модалка подтверждения видима", true,
                        PF.getPage(SearchByNumberPage.class).isOrderCartConfirmSentModalVisible());
    }

    @Если("^пользователь нажимает на профиль")
    public void пользовательНажимаетНаПрофиль() {
        PF.getPage(SearchByNumberPage.class).refreshPage().clickOnProfileButton();
    }

    @Если("^пользователь нажимает на мои запросы")
    public void пользовательНажимаетНаМоиЗапросы() {
        PF.getPage(SearchByNumberPage.class).clickOnOutgoingRequestsFiz();
    }

    @Если("^пользователь нажимает на исходящие запросы")
    public void пользовательНажимаетНаИсходящиеЗапросы() {
        PF.getPage(SearchByNumberPage.class).clickOnOutgoingRequestsUr();
    }

}
