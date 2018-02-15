package com.gisauto.users;

import java.util.ArrayList;

public class LegalEntity extends User {

    private String shopName;
    private long inn;
    private ArrayList<String> additionalEmails = new ArrayList<>();

    public LegalEntity() {
        super();
        shopName = faker.company().name();
        Long max = 999999999999L,
                min = 111111111111L;
        inn = faker.number().numberBetween(min, max);
        additionalEmails.add(this.login);
        log();
    }

    public long getInn() {
        return this.inn;
    }

    public String getShopName() {
        return this.shopName;
    }

    public String generateAnotherOneEmail(){
        String newEmail = faker.internet().emailAddress();
        additionalEmails.add(newEmail);
        userLogger.info("Generated new email adress for "
                + name
                + ": "
                + additionalEmails.get(additionalEmails.size() - 1));
        return newEmail;
    }
}
