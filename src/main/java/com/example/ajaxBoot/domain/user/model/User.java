package com.example.ajaxBoot.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {

    @NonNull
    String username;
    String password;
    String email;

}
