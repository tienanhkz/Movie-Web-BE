package com.example.demo.service.interf;

import com.example.demo.entity.Package;
import com.example.demo.form.apackage.CreatePackageForm;
import com.example.demo.form.apackage.UpdatePackageForm;

import java.util.List;

public interface IPackageService {
    List<Package> findAllPackages();

    Package findPackageByCount(int count);
    void createPackage(CreatePackageForm form);

    void updatePackage(UpdatePackageForm form, int id);

    void deletePackage(int id);

    Package findPackageById(int packageId);
}
