package com.gisauto.utils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public final class FileUploader {

    public static void uploadFile(String path){
        File file = new File(path);
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

}
