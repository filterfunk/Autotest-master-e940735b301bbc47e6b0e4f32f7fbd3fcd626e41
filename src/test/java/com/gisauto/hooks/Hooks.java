package com.gisauto.hooks;

import com.gisauto.utils.Driver;
import com.gisauto.utils.PF;
import cucumber.api.java.After;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
public final class Hooks {

    @After
    public void quit() {
//        Assert.assertEquals(false, PF.getPage(HomePage.class).isLoggedIn());
        PF.reset();
        Driver.kill();
    }

}
