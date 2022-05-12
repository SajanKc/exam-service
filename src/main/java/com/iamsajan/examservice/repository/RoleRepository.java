package com.iamsajan.examservice.repository;

import com.iamsajan.examservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
