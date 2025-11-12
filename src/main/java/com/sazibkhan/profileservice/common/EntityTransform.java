package com.sazibkhan.profileservice.common;

import com.sazibkhan.profileservice.dto.request.ProfileDTO;
import com.sazibkhan.profileservice.dto.response.ProfileRest;
import com.sazibkhan.profileservice.entity.ProfileEntity;
import org.springframework.beans.BeanUtils;

public class EntityTransform {


    public static ProfileEntity toProfileEntity(ProfileDTO profileDTO) {
        var profile = new ProfileEntity();
        BeanUtils.copyProperties(profileDTO, profile);
        return profile;
    }

    public static ProfileRest toProfileRest(ProfileEntity entity) {
        var res = new ProfileRest();
        BeanUtils.copyProperties(entity, res);
        return res;
    }

}
