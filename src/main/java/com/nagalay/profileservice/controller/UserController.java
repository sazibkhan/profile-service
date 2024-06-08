package com.nagalay.profileservice.controller;


import com.nagalay.profileservice.common.ResponseFactory;
import com.nagalay.profileservice.dto.RestResponse;
import com.nagalay.profileservice.dto.request.UserDTO;
import com.nagalay.profileservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public RestResponse saveUser(@RequestBody UserDTO userDTO ) {
        userService.saveUser(userDTO);
        return ResponseFactory.saveSuccess();
    }





}



