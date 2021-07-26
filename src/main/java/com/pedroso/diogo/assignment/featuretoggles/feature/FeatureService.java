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

    public List<Feature> getFeatures() {
        return featureRepository.findAll();
    }

    public void addNewFeature(Feature feature) {
        featureRepository.save(feature);
    }

    public void updateFeature(Long id, Feature featureUpdate) {
        boolean featureExists = featureRepository.existsById(id);

        if (featureExists) {
            featureUpdate.setId(id);
        } else {
            throw new IllegalStateException("Feature not found");
        }

        featureRepository.save(featureUpdate);
    }

    public void archiveFeature(Long id) {
        Feature feature = featureRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("A Feature with id " + id + "does not exists. Please check id."));

        feature.setArchived(true);

        featureRepository.save(feature);
    }

    public List<Feature> getFeaturesForCustomerById(String id, List<String> technicalNames) {
        List<Feature> featuresByTechnicalName = featureRepository.findByTechnicalNameIn(technicalNames);
        return featuresByTechnicalName;
    }
}
