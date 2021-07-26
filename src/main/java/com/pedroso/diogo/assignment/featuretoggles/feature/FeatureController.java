package com.pedroso.diogo.assignment.featuretoggles.feature;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/features")
@CrossOrigin(origins = "*")
public class FeatureController {
    @Autowired
    private FeatureService featureService;

    @Autowired
    private ModelMapper modelMapper;

    
    @GetMapping("/admin/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Feature> getFeatures() {
        return featureService.getFeatures();
    }

    @PostMapping("/admin/create")
    @PreAuthorize("hasRole('ADMIN')")
    public void createFeatureToggle(@RequestBody FeatureUpdateModel featureUpdateDTO) {
        Feature feature = this.convertUpdateToEntity(featureUpdateDTO);
        featureService.addNewFeature(feature);
    }

    @PutMapping("/admin/update/{featureId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateFeatureToggle(@PathVariable("featureId") Long id,
            @RequestBody FeatureUpdateModel featureUpdateDTO) {
        Feature featureUpdate = this.convertUpdateToEntity(featureUpdateDTO);
        featureService.updateFeature(id, featureUpdate);
    }

    @PostMapping("/app/client")
    @PreAuthorize("hasRole('APP')")
    public List<UserFeatureStatusModel> clientFeatureRequest(@RequestBody UserFeatureRequestModel userFeatureRequest) {
        List<String> featureNames = userFeatureRequest.getFeatures().stream().map(FeatureRequestModel::getName)
                .collect(Collectors.toList());
        List<Feature> features = featureService.getFeaturesForCustomerById(userFeatureRequest.getCustomerId(),
                featureNames);
        return convertToUserFeatureStatusDtoList(userFeatureRequest.getCustomerId(), features);
    }

    @PutMapping("/admin/archive/{featureId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void archiveFeature(@PathVariable("featureId") Long id) {
        featureService.archiveFeature(id);
    }

    private List<UserFeatureStatusModel> convertToUserFeatureStatusDtoList(String customerId, List<Feature> features) {
        List<UserFeatureStatusModel> userFeatureStatusDTOList = features.stream()
                .filter(feature -> !feature.isArchived())
                .map(feature -> convertToUserFeatureStatusDto(customerId, feature)).collect(Collectors.toList());
        return userFeatureStatusDTOList;
    }

    private UserFeatureStatusModel convertToUserFeatureStatusDto(String customerId, Feature feature) {
        UserFeatureStatusModel userFeatureStatusDTO = new UserFeatureStatusModel();
        userFeatureStatusDTO.setActive(feature.getCustomerIds().contains(customerId));
        userFeatureStatusDTO.setInverted(feature.isInverted());
        userFeatureStatusDTO.setExpired(feature.getExpiresOn());
        return userFeatureStatusDTO;
    }

    private Feature convertUpdateToEntity(FeatureUpdateModel featureUpdateDTO) {
        Feature feature = modelMapper.map(featureUpdateDTO, Feature.class);
        return feature;
    }
}
