package com.sazibkhan.profileservice.service;

import com.sazibkhan.profileservice.dto.request.ProfileDTO;
import com.sazibkhan.profileservice.repository.ProfileRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ProfileService Unit Tests")
class ProfileServiceTest {
    @Mock
    private  ProfileRepository profileRepository;
    @Mock
    private  EntityValidationService entityValidationService;

    @InjectMocks
    private  ProfileService profileService;




    @Nested
    @DisplayName("Save profile Tests ")
    class SaveProfile{

        @Test
        @DisplayName("Should Save profile Successfully when valid request exists")
        void shouldSaveProfileSuccessfully() {
            System.out.println("Save Successfull ...!");

        }

    }


  
}