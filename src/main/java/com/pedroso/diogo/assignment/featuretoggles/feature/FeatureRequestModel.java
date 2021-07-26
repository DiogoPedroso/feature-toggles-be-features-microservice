package com.pedroso.diogo.assignment.featuretoggles.feature;

public class FeatureRequestModel {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + "}";
    }
}
