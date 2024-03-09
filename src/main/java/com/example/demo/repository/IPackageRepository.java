package com.example.demo.repository;

import com.example.demo.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPackageRepository extends JpaRepository<Package, Integer> {
    Package findByCount(int count);

    java.lang.Package findPackageById(int packageId);
}
