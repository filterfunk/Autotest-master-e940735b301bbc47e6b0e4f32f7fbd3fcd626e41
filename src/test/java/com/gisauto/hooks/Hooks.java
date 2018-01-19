package com.gisauto.hooks;

import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import cucumber.api.java.After;
import io.qameta.allure.Attachment;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Hooks {

    /**
     * Делает скриншот и прикрепляет к отчёту Yandex.allure
     *
     * @return массив байт с изображением
     */
    @Attachment
    public static byte[] screenShot() {
        byte[] out = null;

        try {
            BufferedImage screenShot = new Robot().createScreenCapture(
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ImageIO.write(screenShot, "png", bo);
            out = bo.toByteArray();
            bo.close();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    @After
    public void quit() {
//        Assert.assertEquals(false, PF.getPage(HomePage.class).isLoggedIn());
        PF.reset();
        Driver.kill();
    }

}
