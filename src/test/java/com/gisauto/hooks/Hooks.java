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

    @After
    public void quit() {
//        Assert.assertEquals(false, PF.getPage(HomePage.class).isLoggedIn());
        PF.reset();
        Driver.kill();
    }

}
