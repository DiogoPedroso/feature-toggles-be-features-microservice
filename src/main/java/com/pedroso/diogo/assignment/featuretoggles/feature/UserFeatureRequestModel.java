package com.pedroso.diogo.assignment.featuretoggles.feature;

import java.util.List;

public class UserFeatureRequestModel {
    private String customerId;
    private List<FeatureRequestModel> features;

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<FeatureRequestModel> getFeatures() {
        return this.features;
    }

    public void setFeatures(List<FeatureRequestModel> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "{" + " customerId='" + getCustomerId() + "'" + ", features='" + getFeatures() + "'" + "}";
    }
}
