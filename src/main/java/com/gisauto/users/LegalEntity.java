package com.gisauto.users;

import com.github.javafaker.Faker;

public class LegalEntity extends User {

    private String shopName;

    public LegalEntity (){
        super();
        shopName = Faker.instance().company().name();
        log();
    }

    public String getShopName() {
        return shopName;
    }
}
