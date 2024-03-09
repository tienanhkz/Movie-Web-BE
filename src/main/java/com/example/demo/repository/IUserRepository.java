package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);

    List<User> findUserByUsernameContaining(String username);

    Optional<User> findByUsername(String currentUsername);

    User findIdByUsername(String username);

    User findUserById(int userId);
}
