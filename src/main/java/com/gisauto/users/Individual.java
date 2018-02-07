package com.gisauto.users;

import com.github.javafaker.Faker;

public class Individual extends User {

    public Individual (){
        login = Faker.instance().internet().emailAddress();
        password = Faker.instance().internet().password();
        city = Faker.instance().address().cityName();
        log();
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
