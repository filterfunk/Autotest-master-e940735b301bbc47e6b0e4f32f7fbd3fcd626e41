package com.gisauto.users;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class User {

    String login, password, city, phoneNumber, name;
    static final Logger userLogger = LogManager.getLogger(User.class);

    public User() {
        name = Faker.instance().name().firstName();
        login = Faker.instance().internet().emailAddress();
        password = Faker.instance().internet().password();
        city = Faker.instance().address().cityName();

        String phone = Faker.instance().phoneNumber().cellPhone();
        while (phone.length() < 13) {
            phone += "0";
        }
        phoneNumber = phone;
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
                (this instanceof LegalEntity ? "\n shop - " + ((LegalEntity) this).getShopName() : ""));
    }

}
