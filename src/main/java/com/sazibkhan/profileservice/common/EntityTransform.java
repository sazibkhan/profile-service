package com.sazibkhan.profileservice.common;

import com.sazibkhan.profileservice.dto.response.ProfileRest;
import com.sazibkhan.profileservice.entity.ProfileEntity;
import org.springframework.beans.BeanUtils;

public class EntityTransform {

    public static ProfileRest toProfileRest(ProfileEntity entity) {
        var res = new ProfileRest();
        BeanUtils.copyProperties(entity, res);
        return res;
    }

}
