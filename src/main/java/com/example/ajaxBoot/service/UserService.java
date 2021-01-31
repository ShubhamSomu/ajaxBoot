package com.example.ajaxBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.ajaxBoot.domain.user.model.User;

@Service
public class UserService {

    private List<User> userList;

    public List<User> findByUserNameOrEmail(String username) {

        List<User> result = userList.stream()
                                    .filter(x -> x.getUsername().equalsIgnoreCase(username))
                                    .collect(Collectors.toList());
        return result;
    }

    // database here
    @PostConstruct
    private void iniDataForTesting() {

        userList = new ArrayList<User>();
        User user1 = new User("shubham", "somu", "somu@gmail.com");
        User user2 = new User("suraj", "sdhakre", "sdhakre@gmail.com");
        User user3 = new User("platy", "peripoo", "peri@gmail.com");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

    }

}
