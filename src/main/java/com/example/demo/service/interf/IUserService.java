package com.example.demo.service.interf;

import com.example.demo.entity.User;
import com.example.demo.form.user.CreateUserForm;
import com.example.demo.form.user.UpdateUserForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    Page<User> findAllUsers(Pageable pageable);

    User findUserByUsername(String username);

    List<User> findUserByUsernameContaining(String username);

    void createUser(CreateUserForm form);

    void updateUser(UpdateUserForm form, int id);

    void deleteUser(int id);

    User findIdByUsername(String username);

    User findUserById(int userId);
}
