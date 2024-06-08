package com.nagalay.profileservice.service;

import com.nagalay.profileservice.dto.request.UserDTO;
import com.nagalay.profileservice.entity.UserEntity;
import com.nagalay.profileservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EntityValidationService entityValidationService;


    public void saveUser(UserDTO userDTO) {
        var user=new UserEntity();
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
    }




}
