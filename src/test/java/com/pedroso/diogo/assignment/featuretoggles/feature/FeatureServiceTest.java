package com.pedroso.diogo.assignment.featuretoggles.feature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FeatureServiceTest {

    @Mock
    private FeatureRepository featureRepository;
    private FeatureService featureService;

    @BeforeEach
    void setUp() {
        featureService = new FeatureService(featureRepository);
    }

    @Test
    void canGetAllFeatures() {
        // when
        featureService.getFeatures();
        // then
        verify(featureRepository).findAll();
    }

    @Test
    void canAddFeature() {
        // given
        List<String> users = Arrays.asList("1234", "2345");
        Feature feature = new Feature("feature-1", false, users);

        // when
        featureService.addNewFeature(feature);

        // then
        ArgumentCaptor<Feature> featureArgumentCaptor = ArgumentCaptor.forClass(Feature.class);

        verify(featureRepository).save(featureArgumentCaptor.capture());

        Feature capturedFeature = featureArgumentCaptor.getValue();

        assertThat(capturedFeature).isEqualTo(feature);
    }

    
}
