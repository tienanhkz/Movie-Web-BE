package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.interf.IOrderService;
import com.example.demo.service.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IUserService userService;
    @PostMapping("/{packageId}")
    public void createOrder(@PathVariable int packageId, Principal principal) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        orderService.createOrder(packageId, user.getId());
    }
}
