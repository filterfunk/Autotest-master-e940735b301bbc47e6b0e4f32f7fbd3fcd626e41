package com.gisauto.users;

public class LegalEntity extends User {

    private String shopName;
    private long inn;

    public LegalEntity() {
        super();
        shopName = faker.company().name();
        Long max = 999999999999L,
                min = 111111111111L;
        inn = faker.number().numberBetween(min, max);
        log();
    }

    public long getInn() {
        return this.inn;
    }

    public String getShopName() {
        return this.shopName;
    }
}
