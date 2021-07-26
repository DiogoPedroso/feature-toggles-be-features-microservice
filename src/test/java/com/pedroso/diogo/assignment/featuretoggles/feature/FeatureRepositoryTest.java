package com.pedroso.diogo.assignment.featuretoggles.feature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class FeatureRepositoryTest {
    
    @Autowired
    private FeatureRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void itShouldCheckIfFeatureExists() {
        //given
        List<String> users = Arrays.asList("1234", "2345");
        Feature feature = new Feature("feature-1", false, users);
        repository.save(feature);
        String featureName = "feature-1";
        //when
        Optional<Feature> featureFromRepository = repository.findFeatureByTechnicalName(featureName);
        //then
        assertThat(featureFromRepository).isNotEmpty();
    }

    @Test
    void itShouldCheckIfFeatureDoesNotExist() {
        //given
        String featureName = "feature-1";
        //when
        Optional<Feature> featureFromRepository = repository.findFeatureByTechnicalName(featureName);
        //then
        assertThat(featureFromRepository).isEmpty();
    }
}
