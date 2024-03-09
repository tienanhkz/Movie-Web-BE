package com.example.demo.form.user;

import com.example.demo.entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateUserForm {
    private int id;
    private String email;
    private String username;
    private String password;
    private int count;
    private Role role;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;
}
