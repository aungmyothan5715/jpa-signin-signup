package com.example.jpasinginsingup.dao;

import com.example.jpasinginsingup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String name);
}
