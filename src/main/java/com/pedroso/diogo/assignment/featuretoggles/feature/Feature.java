package com.pedroso.diogo.assignment.featuretoggles.feature;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Feature {
    @Id
    @GeneratedValue
    private Long id;

    private String displayName;

    @Column(unique = true, nullable = false)
    private String technicalName;

    private LocalDate expiresOn;

    private String description;

    @Column(columnDefinition = "boolean default false")
    private boolean inverted;

    @Column(nullable = false)
    @ElementCollection
    private List<String> customerIds;

    @Column(columnDefinition = "boolean default false")
    private boolean archived;

    public Feature() {
    }

    public Feature(String displayName, String technicalName, LocalDate expiresOn, String description, boolean inverted,
            List<String> customerIds) {
        this.displayName = displayName;
        this.technicalName = technicalName;
        this.expiresOn = expiresOn;
        this.description = description;
        this.inverted = inverted;
        this.customerIds = customerIds;
    }

    public Feature(String technicalName, boolean inverted, List<String> customerIds) {
        this.technicalName = technicalName;
        this.inverted = inverted;
        this.customerIds = customerIds;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    public List<String> getCustomerIds() {
        return this.customerIds;
    }

    public void setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
    }

    public boolean isArchived() {
        return this.archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", displayName='" + getDisplayName() + "'" + ", technicalName='"
                + getTechnicalName() + "'" + ", expiresOn='" + getExpiresOn() + "'" + ", description='"
                + getDescription() + "'" + ", inverted='" + isInverted() + "'" + ", customerIds='" + getCustomerIds()
                + "'" + ", archived='" + isArchived() + "'" + "}";
    }
}
