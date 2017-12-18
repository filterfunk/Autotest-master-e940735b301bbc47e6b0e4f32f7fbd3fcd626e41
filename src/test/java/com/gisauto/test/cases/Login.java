package com.gisauto.test.cases;

import com.gisauto.test.utils.TestMain;
import com.gisauto.test.utils.annotations.TargetBrowser;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

@TargetBrowser(browser = "FireFox")
public class Login extends TestMain {
    private static final String LOGIN = "test12@test.com",
            PASSWORD = "111111";

    @Override
    public void prepare() {
    }

    public void process() {
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

    }

    public void validate() {

    }

}