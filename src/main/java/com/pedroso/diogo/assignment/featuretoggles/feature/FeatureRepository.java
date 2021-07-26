package com.pedroso.diogo.assignment.featuretoggles.feature;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {

    Optional<Feature> findFeatureByTechnicalName(String technicalName);

    List<Feature> findByTechnicalNameIn(List<String> technicalNames);
}
