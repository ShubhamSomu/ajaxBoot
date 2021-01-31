package com.example.ajaxBoot.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ajaxBoot.domain.user.model.User;
import com.example.ajaxBoot.domain.user.request.UserSearchRequest;
import com.example.ajaxBoot.domain.user.response.UserSearchResponse;
import com.example.ajaxBoot.service.UserService;

@RestController
public class SearchController {

    private final UserService userService;

    public SearchController(UserService userService) {
        this.userService = Objects.requireNonNull(userService);
    }

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(
        @Valid @RequestBody UserSearchRequest searchRequest, Errors errors) {

        UserSearchResponse result = new UserSearchResponse();

        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                                .stream().map(x -> x.getDefaultMessage())
                                .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        List<User> users = userService.findByUserNameOrEmail(searchRequest.getUsername());
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);

    }
}