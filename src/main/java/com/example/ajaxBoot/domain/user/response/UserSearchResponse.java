package com.example.ajaxBoot.domain.user.response;

import java.util.List;

import com.example.ajaxBoot.domain.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchResponse {
    String msg;
    List<User> result;
}
