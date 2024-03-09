package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.interf.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserService userService;
    @GetMapping("/login")
    public UserDTO login(Principal principal){
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class );
        return userDTO ;
    }

    @GetMapping("/logout")
    public String logout(){
        SecurityContextHolder.clearContext();
        return "Logout Successfully";
    }
}