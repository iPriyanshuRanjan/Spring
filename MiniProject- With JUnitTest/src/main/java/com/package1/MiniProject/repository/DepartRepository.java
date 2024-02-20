package com.package1.MiniProject.repository;

import com.package1.MiniProject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartRepository extends JpaRepository<Department, Long> {

    // Find a department by its name (case-sensitive)
    public Department findByDepartName(String departName);

    // Find a department by its name (case-insensitive)
    public Department findByDepartNameIgnoreCase(String departName);

}
