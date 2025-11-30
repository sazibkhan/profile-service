package com.sazibkhan.profileservice.controller;

import com.sazibkhan.profileservice.common.ResponseFactory;
import com.sazibkhan.profileservice.dto.RestResponse;
import com.sazibkhan.profileservice.dto.request.ProfileDTO;
import com.sazibkhan.profileservice.dto.response.ProfileRest;
import com.sazibkhan.profileservice.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/profiles")
@AllArgsConstructor
public class ProfileController {

    private  final ProfileService profileService ;

    @PostMapping
    public RestResponse saveProfile(@RequestBody ProfileDTO profileDTO ) {
        profileService.saveProfile(profileDTO);
        return ResponseFactory.saveSuccess();
    }

    @GetMapping
    public RestResponse getAllProfile() {
        return ResponseFactory.responseData(profileService.getProfileList());
    }

    @GetMapping("{id}")
    public ProfileRest getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id);
    }


    @GetMapping("info/{id}")
    public ProfileRest getProfileInformationById(@PathVariable Long id) {
        return profileService.getProfileInformationById(id);
    }





    @PutMapping("{id}")
    public RestResponse updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) {
        profileService.updateProfile(id,profileDTO);
        return  ResponseFactory.updateSuccess();
    }

    @DeleteMapping("{id}")
    public RestResponse deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseFactory.deleteSuccess();
    }

}
