package com.iamsajan.examservice.controller;

import com.iamsajan.examservice.model.Role;
import com.iamsajan.examservice.model.User;
import com.iamsajan.examservice.model.UserRole;
import com.iamsajan.examservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@RequestBody User user) throws Exception {
        // Encrypting user password
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        user.setProfile("default.png");
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(11L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return userService.createUser(user, roles);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{username}")
    @ResponseStatus(code = HttpStatus.OK)
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUserbyUsername(username);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUsersById(@PathVariable("id") Long id) throws Exception {
        userService.deleteUserById(id);
    }
}
