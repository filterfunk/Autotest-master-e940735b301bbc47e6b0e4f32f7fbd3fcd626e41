package com.gisauto.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TargetBrowser {

    /**
     * FireFox or Google Chrome
     *
     * @return target browser
     */
    String browser();
}