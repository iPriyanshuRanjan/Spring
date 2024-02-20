package com.package1.MiniProject.controller;

import com.package1.MiniProject.entity.Department;
import com.package1.MiniProject.error.DepartmentNotFoundException;
import com.package1.MiniProject.service.DepartService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class DepartController {
    @Autowired
    private DepartService departService;

    // SLF4J Logger for logging
    private final Logger LOGGER = LoggerFactory.getLogger(DepartController.class);

    // API endpoint to create a new department
    @PostMapping("/departments")
    public Department saveDepart(@Valid @RequestBody Department department){
        LOGGER.info("Inside Save Department of DepartmentController");
        return departService.saveDepart(department) ;
    }

    // API endpoint to get a list of all departments
    @GetMapping("/getAllDepart")
    public List<Department> getAllDep(){
        return departService.fetchDepartList();
    }

    // API endpoint to get a specific department by ID
    @GetMapping("/getAllDepart/{id}")
    public Department fetchDepById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departService.fetchDepartById(departmentId);
    }

    // API endpoint to delete a department by ID
    @DeleteMapping("depart/{id}")
    public String deleteDepart(@PathVariable("id") Long departmentId){
        departService.deleteDepartById(departmentId);
        return "Department Deleted Successfully !";
    }

    // API endpoint to update a department by ID
    @PutMapping("updateDepart/{id}")
    public Department updateDepartById(@PathVariable("id")Long departmentId, @RequestBody Department department){
        return departService.updateDepartById(departmentId, department);
    }

    // API endpoint to get a department by name
    @GetMapping("/departments/name/{name}")
    public Department fetchDeptByName(@PathVariable("name") String departmentName){
        return departService.fetchDepartByName(departmentName);
    }
}
