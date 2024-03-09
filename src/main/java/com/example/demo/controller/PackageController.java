package com.example.demo.controller;

import com.example.demo.entity.Package;
import com.example.demo.form.apackage.CreatePackageForm;
import com.example.demo.form.apackage.UpdatePackageForm;
import com.example.demo.form.user.UpdateUserForm;
import com.example.demo.service.interf.IPackageService;
import com.example.demo.service.interf.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/packages")
@CrossOrigin("*")
public class PackageController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IPackageService packageService;

    @GetMapping
    public List<Package> getAllPackages(){
        return packageService.findAllPackages();
    }

    @GetMapping("/{count}")
    public Package getPackageByCount(@PathVariable int count){
        return packageService.findPackageByCount(count);
    }

    @PostMapping
    public void createPackage(@RequestBody CreatePackageForm form){
        packageService.createPackage(form);
    }

    @PutMapping("/{id}")
    public void updatePackage(@RequestBody UpdatePackageForm form, @PathVariable int id){
        form.setId(id);
        packageService.updatePackage(form,id);
    }

    @DeleteMapping("/{id}")
    public void deletePackage(@PathVariable int id){
        packageService.deletePackage(id);
    }

}
