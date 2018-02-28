package com.gisauto.hooks;

import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import com.gisauto.utils.UF;
import cucumber.api.java.After;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static java.lang.System.gc;


@RunWith(Suite.class)
public final class Hooks {

    @After
    public void quit() {
//        Assert.assertEquals(false, PF.getPage(HomePage.class).isLoggedIn());
        PF.reset();
        UF.reset();
        gc();
        Driver.kill();
    }

}
