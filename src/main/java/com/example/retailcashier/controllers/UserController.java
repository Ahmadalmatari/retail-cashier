package com.example.retailcashier.controllers;

import com.example.retailcashier.models.User;
import com.example.retailcashier.servieces.UserService;
import com.example.retailcashier.servieces.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService UserService) {
        this.userService = UserService;
    }

    @GetMapping
    public User findUserById(@RequestParam Long id) {

        log.debug("Find User By Id");
        return userService.getUser(id);
    }

    @PostMapping
    public String createUser(@RequestBody UserDto user) {

        log.debug("Create New User");
        return userService.createNewUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody UserDto userDto) {

        log.debug("Update User");
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        log.debug("Delete User");
        return userService.deleteUser(id);
    }
}
