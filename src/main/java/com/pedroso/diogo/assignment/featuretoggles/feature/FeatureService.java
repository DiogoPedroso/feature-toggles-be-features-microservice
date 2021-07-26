package com.pedroso.diogo.assignment.featuretoggles.feature;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {
    private final FeatureRepository featureRepository;

    @Autowired
    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }
    /**
     * Function that returns all features from DB
     * 
     * @return feature List
     */

    public List<Feature> getFeatures() {
        return featureRepository.findAll();
    }

    /**
     * Function that adds new feature
     * 
     */
    public void addNewFeature(Feature feature) {
        featureRepository.save(feature);
    }

    /**
     * Function that updates feature
     * 
     * @param id
     * @param featureUpdate
     */

    public void updateFeature(Long id, Feature featureUpdate) {
        boolean featureExists = featureRepository.existsById(id);

        if (featureExists) {
            featureUpdate.setId(id);
        } else {
            throw new IllegalStateException("Feature not found");
        }

        featureRepository.save(featureUpdate);
    }
    
    /**
     * Function to archive feature
     * 
     * @param id
     * @param featureUpdate
     */

    public void archiveFeature(Long id) {
        Feature feature = featureRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("A Feature with id " + id + "does not exists. Please check id."));

        feature.setArchived(true);

        featureRepository.save(feature);
    }

    /**
     * Function that returns features that customer has access to by technicalName
     * @param id
     * @param technicalNames
     * @return
     */
    public List<Feature> getFeaturesForCustomerById(String id, List<String> technicalNames) {
        List<Feature> featuresByTechnicalName = featureRepository.findByTechnicalNameIn(technicalNames);
        return featuresByTechnicalName;
    }
}
