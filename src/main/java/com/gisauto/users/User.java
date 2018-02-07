package com.gisauto.users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class User {

    String login, password, city, phoneNumber;
    static final Logger userLogger = LogManager.getLogger(User.class);

    public abstract String getLogin();

    public abstract String getPassword();

    public abstract String getCity();

    public abstract String getPhoneNumber();

    protected void log() {
        userLogger.info("Created new legal entity with:\n login - " + login +
                "\n password - " + password +
                "\n city - " + city +
                (this instanceof LegalEntity ? "\n shop - " + ((LegalEntity) this).getShopName() : ""));
    }

}
