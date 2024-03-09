package com.example.demo.service;

import com.example.demo.entity.Package;
import com.example.demo.entity.User;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.repository.IPackageRepository;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.interf.IOrderService;
import com.example.demo.service.interf.IPackageService;
import com.example.demo.service.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IPackageService packageService;
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void createOrder(int packageId, int userId) {
        User user = userService.findUserById(userId);
        Package aPackage = packageService.findPackageById(packageId);
        int newCount = user.getCount() + aPackage.getCount();
        user.setCount(newCount);
        userRepository.save(user);
    }
}
