package com.package1.MiniProject.service.serviceImpl;

import com.package1.MiniProject.entity.Department;
import com.package1.MiniProject.error.DepartmentNotFoundException;
import com.package1.MiniProject.repository.DepartRepository;
import com.package1.MiniProject.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository departRepository;

    // Save a new department
    @Override
    public Department saveDepart(Department department) {
        return departRepository.save(department);
    }

    // Get a list of all departments
    @Override
    public List<Department> fetchDepartList() {
        return departRepository.findAll();
    }

    // Get a department by its ID
    @Override
    public Department fetchDepartById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department= departRepository.findById(departmentId);
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department not found/available");
        }
        return department.get();
    }

    // Delete a department by its ID
    @Override
    public void deleteDepartById(Long departmentId) {
        departRepository.deleteById(departmentId);
    }

    // Update a department by its ID
    @Override
    public Department updateDepartById(Long departmentId, Department department) {
        Department db1 = departRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartName()) && !"".equalsIgnoreCase(department.getDepartName())) {
            db1.setDepartName(department.getDepartName());
        }
        if (Objects.nonNull(department.getDepartAddress()) && !"".equalsIgnoreCase(department.getDepartAddress())) {
            db1.setDepartAddress(department.getDepartAddress());
        }
        if (Objects.nonNull(department.getDepartCode()) && !"".equalsIgnoreCase(department.getDepartCode())) {
            db1.setDepartCode(department.getDepartCode());
        }

        return departRepository.save(db1);
    }

    // Get a department by its name (case-insensitive)
    @Override
    public Department fetchDepartByName(String departmentName) {
        return departRepository.findByDepartNameIgnoreCase(departmentName);
    }
}
