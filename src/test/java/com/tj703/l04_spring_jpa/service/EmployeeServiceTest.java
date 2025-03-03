package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.entity.DeptEmp;
import com.tj703.l04_spring_jpa.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void saveSalaryAndTitleAndDeptEmp() {
        Employee emp=new Employee();
        emp.setId(10001);
        emp.setFirstName("Georgi");
        emp.setLastName("Facello");
        emp.setGender("F");
        emp.setHireDate(LocalDate.parse("1986-06-26"));
        emp.setBirthDate(LocalDate.parse("1953-09-02"));
        DeptEmp deptEmp=new DeptEmp();
        deptEmp.setDeptNo("d001");
        deptEmp.setEmpNo(emp.getId());
        deptEmp.setFromDate(LocalDate.parse("2000-05-25"));
        deptEmp.setToDate(LocalDate.parse("2000-05-26"));
        emp.getDeptEmps().add(deptEmp);
        employeeService.saveSalaryAndTitleAndDeptEmp(emp);

    }
}