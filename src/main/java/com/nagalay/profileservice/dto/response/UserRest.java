package com.nagalay.profileservice.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRest {

    private String fullName;
    private String username;
    private String authority;
    private List<UserRoleRest> roles;
    private Boolean enabled;

}
