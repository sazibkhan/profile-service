package com.nagalay.profileservice.service;

import com.nagalay.profileservice.dto.request.ProfileDTO;
import com.nagalay.profileservice.dto.response.ProfileRest;
import com.nagalay.profileservice.entity.ProfileEntity;
import com.nagalay.profileservice.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final EntityValidationService entityValidationService;


    public void createProfile(ProfileDTO profileDTO) {
        var profileEntity=new ProfileEntity();
        BeanUtils.copyProperties(profileDTO,profileEntity);
        profileRepository.saveAndFlush(profileEntity);
    }

    public List<ProfileRest> getProfileList() {
        return  profileRepository.findAll().stream()
                .map(itm->{
                    var res=new ProfileRest();
                    BeanUtils.copyProperties(itm,res);
                    return res;
                }).collect(Collectors.toList());
    }

    public ProfileRest getProfileById(Long id) {
        var response=entityValidationService.validateProfile(id);
           var profileEntity=new ProfileRest();
           BeanUtils.copyProperties(profileEntity,response);
        return profileEntity;
    }

    public void updateProfile(Long id, ProfileDTO profileDTO) {
            var profileEntity=entityValidationService.validateProfile(id);
            profileEntity.setName(profileDTO.getName());
            profileEntity.setDesignation(profileDTO.getDesignation());
            profileEntity.setAddress(profileDTO.getAddress());
    }

    public void deleteProfileById(Long id) {
        var profileEntity=entityValidationService.validateProfile(id);
        profileRepository.deleteById(profileEntity.getId());

    }
}
