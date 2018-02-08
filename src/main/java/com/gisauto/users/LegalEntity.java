package com.gisauto.users;

public class LegalEntity extends User {

    private String shopName;

    public LegalEntity() {
        super();
        shopName = faker.company().name();
        log();
    }

    public String getShopName() {
        return shopName;
    }
}
