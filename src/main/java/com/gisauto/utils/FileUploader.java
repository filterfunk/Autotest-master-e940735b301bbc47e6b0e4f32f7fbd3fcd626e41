package com.gisauto.utils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Клас загрузки файлов. Может быть исползован для загрузки прайсов.
 *
 * @author Neradko Artsiom
 */
public final class FileUploader {

    /**
     * Метод для автоматической загрузки файлов.
     * @param path полный путь к файлу, включая расширение
     */
    public static void uploadFile(String path){
        File file = new File(path);

        StringSelection ss = new StringSelection(file.getAbsoluteFile().toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        try {
            Robot robot = new Robot();
            robot.setAutoDelay(250);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
