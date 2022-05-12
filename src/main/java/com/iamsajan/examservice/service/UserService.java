package com.iamsajan.examservice.service;

import com.iamsajan.examservice.model.User;
import com.iamsajan.examservice.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public List<User> getUsers();
}
