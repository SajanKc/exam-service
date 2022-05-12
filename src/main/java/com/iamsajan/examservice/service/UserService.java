package com.iamsajan.examservice.service;

import com.iamsajan.examservice.model.User;
import com.iamsajan.examservice.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    List<User> getUsers();

    User getUserbyUsername(String username);

    void deleteUserById(Long id) throws Exception;
}
