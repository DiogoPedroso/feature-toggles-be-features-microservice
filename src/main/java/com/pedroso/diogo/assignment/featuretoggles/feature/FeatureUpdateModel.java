package com.pedroso.diogo.assignment.featuretoggles.feature;

import java.time.LocalDate;
import java.util.List;

public class FeatureUpdateModel {
    private String displayName;
    private String technicalName;
    private LocalDate expiresOn;
    private String description;
    private boolean inverted;
    private List<String> customerIds;

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTechnicalName() {
        return this.technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public LocalDate getExpiresOn() {
        return this.expiresOn;
    }

    public void setExpiresOn(LocalDate expiresOn) {
        this.expiresOn = expiresOn;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInverted() {
        return this.inverted;
    }

    public boolean getInverted() {
        return this.inverted;
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    public List<String> getCustomerIds() {
        return this.customerIds;
    }

    public void setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
    }

    @Override
    public String toString() {
        return "{" + " displayName='" + getDisplayName() + "'" + ", technicalName='" + getTechnicalName() + "'"
                + ", expiresOn='" + getExpiresOn() + "'" + ", description='" + getDescription() + "'" + ", inverted='"
                + isInverted() + "'" + ", customerIds='" + getCustomerIds() + "'" + "}";
    }

}
