package com.package1.MiniProject.service;

import com.package1.MiniProject.entity.Department;
import com.package1.MiniProject.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartService {

    Department saveDepart(Department department);

    List<Department> fetchDepartList();

    Department fetchDepartById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartById(Long departmentId);

    Department updateDepartById(Long departmentId, Department department);

    Department fetchDepartByName(String departmentName);
}
