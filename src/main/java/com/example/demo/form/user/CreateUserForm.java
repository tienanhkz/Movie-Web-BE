package com.example.demo.form.user;

import lombok.Data;

@Data
public class CreateUserForm {
    private String email;
    private String username;
    private String password;
}
