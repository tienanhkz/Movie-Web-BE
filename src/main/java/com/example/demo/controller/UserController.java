package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.form.user.CreateUserForm;
import com.example.demo.form.user.UpdateUserForm;
import com.example.demo.service.interf.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserService userService;
    @GetMapping
    public Page<UserDTO> getAllUsers(Pageable pageable){
        Page<User> userPage = userService.findAllUsers(pageable);
        Page<UserDTO> userDTOPage =  userPage.map(user -> modelMapper.map(user,UserDTO.class));
        return userDTOPage;
    }

    @GetMapping("/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) {
        User user = userService.findUserByUsername(username);
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        return userDTO;
    }

    @GetMapping("/search/{username}")
    public List<UserDTO> getUsersByUsernameContaining(@PathVariable String username){
        List<User> users = userService.findUserByUsernameContaining(username);
        List<UserDTO> userDTOs = users.stream().map(user -> modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
        return userDTOs;
    }

    @PostMapping
    public void createUser(@RequestBody CreateUserForm form) {
        userService.createUser(form);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody UpdateUserForm form, @PathVariable int id) {
        form.setId(id);
        userService.updateUser(form,id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
