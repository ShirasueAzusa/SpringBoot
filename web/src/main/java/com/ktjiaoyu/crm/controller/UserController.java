package com.ktjiaoyu.crm.controller;

import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public record UserController(UserService userService) {

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long usrId) {
        return userService.getUser(usrId);
    }

    @PostMapping("/user")
    public void addUser(User user) {
        userService.addUser(user);
    }

    @PutMapping("/user")
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long usrId) {
        userService.deleteUser(usrId);
    }
}
