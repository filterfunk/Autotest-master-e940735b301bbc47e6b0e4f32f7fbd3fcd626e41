package com.gisauto.users;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public abstract class User {

    String login, password, city, phoneNumber, name;
    static final Logger userLogger = LogManager.getLogger("UserFactoryLogger");
    final Faker faker = Faker.instance(new Locale("Ru"));

    public User() {
        name = faker.name().firstName();
        login = faker.internet().emailAddress();
        password = faker.internet().password();
        city = faker.address().cityName();
        phoneNumber = faker.phoneNumber().phoneNumber();
    }

    public String getName() {
        return this.name;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getCity() {
        return this.city;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    protected void log() {
        userLogger.info("Created new " + this.getClass().toString() + " with:\n login - " + login +
                "\n password - " + password +
                "\n city - " + city +
                "\n name - " + name +
                "\n phoneNumber - " + phoneNumber +
                (this instanceof LegalEntity ? "\n shop - " + ((LegalEntity) this).getShopName() : "") +
                "\n inn - " + ((LegalEntity) this).getInn());
    }

}
