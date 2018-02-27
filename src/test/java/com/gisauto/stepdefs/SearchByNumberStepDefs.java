package com.gisauto.stepdefs;

import com.gisauto.pageObjects.SearchByNumberPage;
import com.gisauto.users.Individual;
import com.gisauto.users.LegalEntity;
import com.gisauto.users.User;
import com.gisauto.utils.PF;
import com.gisauto.utils.UF;
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

    @Если("^пользователь заполняет поля и нажимает на чекбокс и заказать")
    public void пользовтельВыбираетГородВводитИмяПочтуТелефонНажимаетНаЧекБоксИЗаказать() {
        PF.getPage(SearchByNumberPage.class)
                .typeName(UF.getUser(Individual.class).getName())
                .chooseCity()
                .typeEmail("test.gisauto@yandex.ru")
                .typePhoneNumber(UF.getUser(Individual.class).getPhoneNumber())
                .clickoOnCheckBox()
                .clickOnSubmittBuyButton();
    }

    @Если("^пользователь нажимает на чекбокс заказать и закрывает модалку")
    public void пользовательНажимаетНаЧекбоксЗаказатьИЗакрываетМодалку() {
        PF.getPage(SearchByNumberPage.class)
                .clickOnOrderConfirmCheckBox()
                .clickOnSubmittBuyButton()
                .clickOnCloseModal()
                .refreshPage();
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

    @Если("^пользователь нажимает добавить в корзину у \"([^\"]*)\"$")
    public void пользовательНажимаетДобавитьВКорзинуУ(String seller) {
        PF.getPage(SearchByNumberPage.class).clickOnAddToCart(seller);
    }

    @Если("^пользователь открывает корзину")
    public void пользовательОткрываетКорзину() {
        PF.getPage(SearchByNumberPage.class).clickOnCart();
    }

    @Если("^пользователь нажимает отправить заказы")
    public void пользовательНажимаетОтправитьЗаказы() {
        PF.getPage(SearchByNumberPage.class).clickOnSendOrdersButton();
    }

    @Если("^пользователь заполняет поля нажимает на чекбокс и отправить")
    public void пользовательЗаполняетПоляНажимаетНаЧекбоксИОтправить() {
        PF.getPage(SearchByNumberPage.class)
                .typeCartName(UF.getUser(Individual.class).getName())
                .clickOnOrderConfirmSelectCity()
                .clickOnOrderConfirmFirstCity()
                .typeCartEmail(UF.getUser(Individual.class).getLogin())
                .typeCartPhone(UF.getUser(Individual.class).getPhoneNumber())
                .clickOnOrderConfirmCheckBox()
                .clickOnOrderConfirSendButton();
    }


    @Если("^пользователь нажимает на чекбокс и отправить")
    public void пользовательНажимаетНаЧекбоксИОтправить() {
        PF.getPage(SearchByNumberPage.class)
                .clickOnOrderConfirmCheckBox()
                .clickOnOrderConfirSendButton()
                .clickOnCloseModal();
    }

    @Если("^пользователь нажимает на чекбокс и отправить корзина")
    public void пользовательНажимаетНаЧекбоксИОтправитьКорзина() {
        PF.getPage(SearchByNumberPage.class)
                .clickOnCartConfirmCheckBox()
                .clickOnSendOrdersButton()
                .clickOnCloseModal();
    }

    @То("^появляется модалка с подтверждением")
    public void появляетсяМодалкаСПодтверждением() {
        Assert
                .assertEquals("Модалка подтверждения видима", true,
                        PF.getPage(SearchByNumberPage.class).isOrderCartConfirmSentModalVisible());
    }

    @Если("^пользователь нажимает на профиль")
    public void пользовательНажимаетНаПрофиль() {
        PF.getPage(SearchByNumberPage.class).clickOnProfileButton();
    }

    @Если("^пользователь нажимает на мои запросы")
    public void пользовательНажимаетНаМоиЗапросы() {
        PF.getPage(SearchByNumberPage.class).clickOnOutgoingRequestsFiz();
    }

    @Если("^пользователь нажимает на исходящие запросы")
    public void пользовательНажимаетНаИсходящиеЗапросы() {
        PF.getPage(SearchByNumberPage.class).clickOnOutgoingRequestsUr();
    }

    @То("^в таблице появилось предложение на запчасть \"([^\"]*)\" от \"([^\"]*)\"$")
    public void вТаблицеПоявилосьПредложениеНаЗапчасть(String partNumber, String shopName){
        Assert.assertEquals(
                "Предложение для " + partNumber + "не появилось.",
                true,
                PF.getPage(SearchByNumberPage.class)
                        .checkOrder(UF.getUser(LegalEntity.class).getShopName() + " - " + shopName));
    }

}
