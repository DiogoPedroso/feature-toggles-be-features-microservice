package com.pedroso.diogo.assignment.featuretoggles.feature;

import java.time.LocalDate;

public class UserFeatureStatusModel {
    private String name;
    private boolean active;
    private boolean inverted;
    private boolean expired;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isInverted() {
        return this.inverted;
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    public boolean isExpired() {
        return this.expired;
    }

    public void setExpired(LocalDate expiresOn) {
        if (expiresOn != null) {
            this.expired = expiresOn.isAfter(LocalDate.now());
        } else {
            this.expired = false;
        }
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", active='" + isActive() + "'" + ", inverted='" + isInverted() + "'"
                + ", expired='" + isExpired() + "'" + "}";
    }

}
