package com.gisauto.pageObjects;

import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.*;

/**
 * PageObject главной страницы
 * <p>
 * Хранит в себе информацию и набор методов для работы с WebElement'ами, присутствующими
 * на главной странице.
 *
 * @author Neradko Artsiom
 */
public class HomePage extends BasePage {

    private final By searchByNumber = new By.ByXPath("/html/body/div[2]/nav/ul/li[1]/a"),
            vinRequestButton = new By.ByXPath("/html/body/div[2]/nav/ul/li[3]/a/div[1]/div");

    public HomePage() {
        super();
        openPage(System.getenv("HOMEPAGE"));
        Assert.assertEquals("Открытая страница не является главной страницей",
                "Поиск автозапчастей по всей России",
                Driver.getDriver().getTitle());
    }

    public Profile loginAs(String username, String password) {
        typeUsername(username).typePassword(password);
        return submitLogin();
    }

    public Profile loginFromSystemEnv() {
        typeUsername(parseLogin()).typePassword(parsePswd());
        return submitLogin();
    }

    private String parseLogin() {
        String user = System.getenv("SELLER");

        try {
            FileInputStream io = new FileInputStream(System.getProperty("user.dir") + "/logs/users.log");
            BufferedReader reader = new BufferedReader(new InputStreamReader(io));
            String currentLine, login;

            while ((currentLine = reader.readLine()) != null) {
                login = currentLine.startsWith("login") ? currentLine.substring(9, currentLine.length()) : "";
                if (currentLine.equals("shop - " + user)) {
                    return login;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String parsePswd() {
        String user = System.getenv("SELLER");

        try {
            FileInputStream io = new FileInputStream(System.getProperty("user.dir") + "/logs/users.log");
            BufferedReader reader = new BufferedReader(new InputStreamReader(io));
            String currentLine, pswd;

            while ((currentLine = reader.readLine()) != null) {
                pswd = currentLine.startsWith("password") ? currentLine.substring(12, currentLine.length()) : "";
                if (currentLine.equals("shop - " + user)) {
                    return pswd;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SearchByNumberPage clickOnSearchByNumber() {
        getElement(this.searchByNumber).click();
        return PF.getPage(SearchByNumberPage.class);
    }

    @Override
    public Profile submitLogin() {
        try {
            getElement(submit).click();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AssertionError("Не удалось нажать на \"Войти\". Возможно элемент входа скрыт.");
        }
        await(2000);
        return PF.getPage(Profile.class);
    }

    public VIN vinRequestButton() {
        getElement(vinRequestButton).click();
        return PF.getPage(VIN.class);
    }

}
