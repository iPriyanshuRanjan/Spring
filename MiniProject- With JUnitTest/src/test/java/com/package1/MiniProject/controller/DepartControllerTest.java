package com.package1.MiniProject.controller;

import com.package1.MiniProject.entity.Department;
import com.package1.MiniProject.error.DepartmentNotFoundException;
import com.package1.MiniProject.service.DepartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartController.class)
class DepartControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartService departService;

    private Department department;

    @BeforeEach
    void setUp() {
        department= Department.builder().departAddress("Patna").departCode("IT-06").departName("IT").
                departmentId(1L).build();
    }

    @Test
    void saveDepart() throws Exception {
        Department inputDept = Department.builder()
                .departAddress("Kerala")
                .departCode("EQ-04")
                .departName("IT")
                .departmentId(1L)
                .build();

        Mockito.when(departService.saveDepart(inputDept))
                .thenReturn(department);
        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                "\n" +
                "  \"departName\": \"IT\",\n" +
                "  \"departAddress\": \"Patna\",\n" +
                "  \"departCode\": \"IT-06\"\n" +
                "}\n"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepById() throws Exception {
        Mockito.when(departService.fetchDepartById(1L)).thenReturn(department);
        mockMvc.perform(get("/getAllDepart/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.departName").value(department.getDepartName()));
    }
}