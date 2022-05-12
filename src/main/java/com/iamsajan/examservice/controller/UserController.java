package com.iamsajan.examservice.controller;

import com.iamsajan.examservice.model.Role;
import com.iamsajan.examservice.model.User;
import com.iamsajan.examservice.model.UserRole;
import com.iamsajan.examservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(30L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return userService.createUser(user, roles);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }
}
