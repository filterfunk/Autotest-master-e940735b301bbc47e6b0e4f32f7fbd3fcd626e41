package com.gisauto.hooks;

import com.gisauto.utils.TestMain;
import cucumber.api.java.After;

public class Hooks {

    @After
    public void quit(){
        TestMain.driver.quit();
    }

}
