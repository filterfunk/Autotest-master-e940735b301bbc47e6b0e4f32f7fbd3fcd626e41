package com.gisauto.users;

import com.github.javafaker.Faker;

public class LegalEntity extends User {

    private String login, password, city, shopName, phoneNumber;

    public LegalEntity (){
        login = Faker.instance().internet().emailAddress();
        password = Faker.instance().internet().password();
        city = Faker.instance().address().cityName();
        shopName = Faker.instance().company().name();
        phoneNumber = Faker.instance().phoneNumber().phoneNumber();
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
}