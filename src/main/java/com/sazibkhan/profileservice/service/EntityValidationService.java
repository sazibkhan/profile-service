package com.sazibkhan.profileservice.service;
import com.sazibkhan.profileservice.entity.ProfileEntity;
import com.sazibkhan.profileservice.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class EntityValidationService {

    private final ProfileRepository profileRepository;

    public ProfileEntity validateProfile(Long id) {
        Objects.requireNonNull(id);
        return profileRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(
                        String.format("Profile  not found with id [%s]", id)));
    }


}
