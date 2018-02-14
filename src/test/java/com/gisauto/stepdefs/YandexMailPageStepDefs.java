package com.gisauto.stepdefs;

import com.gisauto.pageObjects.YandexMailPage;
import com.gisauto.utils.PF;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.То;
import org.junit.Assert;

public class YandexMailPageStepDefs {

    @Если("^пользователь открывает яндекс почту")
    public void пользовательОткрываетЯндексПочту(){
        PF.getPage(YandexMailPage.class);
    }

    @Если("^пользователь вводит логин \"([^\"]*)\" и пароль \"([^\"]*)\" от яндекс$")
    public void пользовательВводитЛогинИПарольОтЯндекс(String login, String password){
        PF.getPage(YandexMailPage.class).loginAs(login, password);
    }

    @Если("^пользователь нажимает на последнее письмо")
    public void пользовательНажимаетНаПоследнееПисьмо(){
        PF.getPage(YandexMailPage.class).clickOnLastMessage();
    }

    @То("^письмо содержит текст: \"([^\"]*)\"$")
    public void письмоСодержитТекст(String msg){
        Assert
                .assertEquals("Неверный текст письма",
                msg,
                PF.getPage(YandexMailPage.class).getMessage());
    }

}
