package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.entity.Department;
import com.tj703.l04_spring_jpa.entity.DeptEmp;
import com.tj703.l04_spring_jpa.entity.Employee;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void test(){

        Employee entityEmp=entityManager.find(Employee.class, 10001);
        System.out.println(entityEmp);

        Employee entityEmp1=entityManager.find(Employee.class, 10001);
        System.out.println(entityEmp1);

        entityEmp1.setBirthDate(LocalDate.now());
        entityManager.persist(entityEmp1);
        entityManager.flush();
    }


    @Test
    void addEmpDepartment() {
        DeptEmp deptEmp = new DeptEmp();
        deptEmp.setDeptNo("d001");
        deptEmp.setEmpNo(10001);
        deptEmp.setFromDate(LocalDate.parse("2000-01-01"));
        deptEmp.setToDate(LocalDate.parse("2000-12-31"));
        departmentService.addEmpDepartment(deptEmp);
    }
}