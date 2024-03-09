package com.example.demo.service;

import com.example.demo.entity.Package;
import com.example.demo.entity.User;
import com.example.demo.form.apackage.CreatePackageForm;
import com.example.demo.form.apackage.UpdatePackageForm;
import com.example.demo.repository.IPackageRepository;
import com.example.demo.service.interf.IPackageService;
import com.example.demo.service.interf.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PackageService implements IPackageService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IPackageRepository packageRepository;
    @Autowired
    private IUserService userService;
    @Override
    public List<Package> findAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public Package findPackageByCount(int count) {
        return packageRepository.findByCount(count);
    }

    @Override
    public void createPackage(CreatePackageForm form) {
        Package package1 = modelMapper.map(form, Package.class);
        packageRepository.save(package1);
    }

    @Override
    public void updatePackage(UpdatePackageForm form, int id) {
        Package package1 = modelMapper.map(form, Package.class);
        packageRepository.save(package1);
    }

    @Override
    public void deletePackage(int id) {
        packageRepository.deleteById(id);
    }

    @Override
    public Package findPackageById(int id) {
        return packageRepository.findById(id).get();
    }

}
