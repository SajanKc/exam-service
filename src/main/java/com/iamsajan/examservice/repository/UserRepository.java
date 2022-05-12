package com.iamsajan.examservice.repository;

import com.iamsajan.examservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
