package com.iamsajan.examservice.service.impl;

import com.iamsajan.examservice.model.User;
import com.iamsajan.examservice.model.UserRole;
import com.iamsajan.examservice.repository.RoleRepository;
import com.iamsajan.examservice.repository.UserRepository;
import com.iamsajan.examservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser != null) {
            System.out.println("User is already exits!!!");
            throw new Exception("User already exits!!!");
        } else {
            for (UserRole userRole : userRoles) {
                roleRepository.save(userRole.getRole());
            }
            localUser.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }
        return localUser;
    }
}
