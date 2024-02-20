package com.package1.MiniProject.repository;

import com.package1.MiniProject.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartRepositoryTest {
    @Autowired
    private DepartRepository departRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department
                =Department.builder().departName("Computers").departCode("CS-02").departAddress("Delhi").build();
        entityManager.persist(department);
    }

    //Create test case here
    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department
                = departRepository.findById(1L).get();
        assertEquals(department.getDepartName(),"Computers");
    }
}