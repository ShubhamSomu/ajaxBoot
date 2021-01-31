package com.example.ajaxBoot.domain.user.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequest {
    @NotBlank(message = "username can't empty!")
    String username;
}
