package com.package1.MiniProject.service;

import com.package1.MiniProject.entity.Department;
import com.package1.MiniProject.repository.DepartRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartServiceTest {
    @Autowired
    private DepartService departService;
    @MockBean
    private DepartRepository departRepository;


    @BeforeEach
    void setUp() {
        Department department= Department.builder()
                .departName("IT")
                .departAddress("Patna")
                .departCode("PAT-01")
                .departmentId(1L)
                .build();
        Mockito.when(departRepository.findByDepartNameIgnoreCase("IT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get data based on valid department name")
    //@Disabled // for disabling any test case
    public void whenVaidDeptName_thenDeptShouldFound(){
        String departName="IT";
        Department found=
                departService.fetchDepartByName(departName);
        assertEquals(departName,found.getDepartName());

    }
}