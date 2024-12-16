package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Bank extends PanacheEntity {

    private String name;
    private String countrycode;
    private int checkdigits;
    private int bankcode;
    private String description;

    public Bank() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public int getCheckdigits() {
        return checkdigits;
    }

    public void setCheckdigits(int checkdigits) {
        this.checkdigits = checkdigits;
    }

    public int getBankcode() {
        return bankcode;
    }

    public void setBankcode(int bankcode) {
        this.bankcode = bankcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
