package com.nagalay.profileservice.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private String fullName;
    private String username;
    private String password;
    private String authority;
    private List<UserRoleDTO> roles;
    private Boolean enabled;


}