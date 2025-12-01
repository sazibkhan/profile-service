package com.sazibkhan.profileservice.service.impl;

import com.sazibkhan.profileservice.dto.request.ProfileDTO;
import com.sazibkhan.profileservice.dto.response.ProfileRest;
import com.sazibkhan.profileservice.entity.ProfileEntity;
import com.sazibkhan.profileservice.repository.ProfileRepository;
import com.sazibkhan.profileservice.service.EntityValidationService;
import com.sazibkhan.profileservice.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final EntityValidationService entityValidationService;

    @Override
    public void saveProfile(ProfileDTO profileDTO) {
        var profileEntity=new ProfileEntity();
        BeanUtils.copyProperties(profileDTO,profileEntity);
        profileRepository.saveAndFlush(profileEntity);
    }

    @Override
    public List<ProfileRest> getProfileList() {
        return  profileRepository.findAll().stream()
                .map(itm->{
                    var res=new ProfileRest();
                    BeanUtils.copyProperties(itm,res);
                    return res;
                }).collect(Collectors.toList());
    }
    @Override
    public ProfileRest getProfileById(Long id) {
        var profileEntity =entityValidationService.validateProfile(id);
        var response=new ProfileRest();
        BeanUtils.copyProperties(profileEntity,response);
        return response;
    }

    @Override
    public ProfileRest getProfileInformationById(Long id) {
        ProfileEntity profile = entityValidationService.validateProfile(id);

        return ProfileRest.builder()
                .name(profile.getName())
                .build();
    }


    @Override
    public void updateProfile(Long id, ProfileDTO profileDTO) {
        var profileEntity=entityValidationService.validateProfile(id);
        profileEntity.setName(profileDTO.getName());
        profileEntity.setDesignation(profileDTO.getDesignation());
        profileEntity.setAddress(profileDTO.getAddress());
        profileRepository.saveAndFlush(profileEntity);
    }
    @Override
    public void deleteProfile(Long id) {
        var profileEntity=entityValidationService.validateProfile(id);
        profileRepository.deleteById(profileEntity.getId());
    }
}
