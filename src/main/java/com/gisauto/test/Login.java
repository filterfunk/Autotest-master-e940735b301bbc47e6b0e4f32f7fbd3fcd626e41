package com.gisauto.test;

import com.gisauto.utils.TargetBrowser;
import com.gisauto.utils.TestMain;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

@TargetBrowser(browser = "FireFox")
public class Login extends TestMain {
    private static final String LOGIN = "test12@test.com",
            PASSWORD = "111111";

    public void prepare() {

    }


    public void process() {
        openPage("http://gisauto.ru/");
        get(By.className("dropdown-toggle")).click();
        get(By.name("_username")).sendKeys(LOGIN);
        get(By.name("_password")).sendKeys(PASSWORD);
        get(new By.ByXPath("//*[@id=\"formLogin\"]/div[7]/button")).click();

        await(5000);

        get(new By.ByXPath("//*[@id=\"topBlock\"]/nav/ul/li[2]/a/div")).click();
        await(1000);
        get(new By.ByXPath("//*[@id=\"mainWin\"]/div[1]/div[1]/div[2]/button[3]")).click();

        await(300);

        get(new By.ByXPath("//*[@id=\"hand-upload-form\"]/div[1]/div[1]/div[1]")).click();
        File file = new File("/home/artsiom/Загрузки/Telegram Desktop/pidaraisse12344321.csv");
        StringSelection ss = new StringSelection(file.getAbsoluteFile().toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        try {
            Robot robot = new Robot();
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(250);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(50);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        get(new By.ByXPath("//*[@id=\"displayed-firstLine-styler\"]/div[3]")).click();
        await(1000);
        get(new By.ByXPath("//*[@id=\"hand-upload-form\"]/div[1]/div[5]/div[2]/div/div[1]/div[2]")).click();
        await(1000);
        get(new By.ByXPath("//*[@id=\"hand-upload-form\"]/div[1]/div[5]/div[2]/div/div[2]/ul/li[2]/label")).click();
        await(1000);
        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[2]/div/div/div[1]/div[2]")).click();
        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[2]/div/div/div[2]/ul/li[2]/label")).click();

        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[3]/div/div/div[1]/div[2]")).click();
        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[3]/div/div/div[2]/ul/li[1]/label")).click();

        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[4]/div/div/div[1]/div[2]")).click();
        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[4]/div/div/div[2]/ul/li[3]/label")).click();

        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[5]/div/div/div[1]/div[2]")).click();
        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[5]/div/div/div[2]/ul/li[8]/label")).click();

        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[6]/div/div/div[1]/div[2]")).click();
        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[6]/div/div/div[2]/ul/li[5]/label")).click();

        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[7]/div/div/div[1]/div[2]")).click();
        get(new By.ByXPath("//*[@id=\"hand-upload-preview\"]/thead/tr/th[7]/div/div/div[2]/ul/li[4]/label")).click();

//        get(new By.ByXPath("/html/body/div[3]/div[1]/div[6]/div/div/div[2]/div/form/button")).click();
    }

    public void validate() {

    }

}