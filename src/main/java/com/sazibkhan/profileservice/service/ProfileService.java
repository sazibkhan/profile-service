package com.sazibkhan.profileservice.service;

import com.sazibkhan.profileservice.dto.request.ProfileDTO;
import com.sazibkhan.profileservice.dto.response.ProfileRest;

import java.util.List;

public interface ProfileService {

     void saveProfile(ProfileDTO profileDTO);
     void updateProfile(Long id, ProfileDTO profileDTO);
     void deleteProfile(Long id);
     List<ProfileRest> getProfileList();
     ProfileRest getProfileById(Long id);
     ProfileRest getProfileInformationById(Long id);

}
