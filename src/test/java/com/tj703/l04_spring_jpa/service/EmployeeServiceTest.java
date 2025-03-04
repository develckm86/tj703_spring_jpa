package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.entity.Employee;
import com.tj703.l04_spring_jpa.entity.Salary;
import com.tj703.l04_spring_jpa.entity.Title;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;
    @Test
    void entityMannagerTest() {
        employeeService.entityMannagerTest();
    }

    @Test
    void modifyEmpSaveSalariesAndTitles() {
        Employee emp = new Employee();
        emp.setGender("F");
        emp.setFirstName("test");
        emp.setLastName("testtest");
        emp.setBirthDate(LocalDate.parse("2025-03-04"));
        emp.setHireDate(LocalDate.parse("2025-03-04"));
        emp.setId(10001);
        Salary salary = new Salary();
        salary.setSalary(11100);
        salary.setEmpNo(10001);
        salary.setFromDate(LocalDate.parse("2025-03-03"));
        salary.setToDate(LocalDate.parse("2025-03-04"));
        emp.getSalaries().add(salary);

        Title title = new Title();
        title.setTitle("사장");
        title.setEmpNo(10001);
        title.setFromDate(LocalDate.parse("2025-03-03"));
        title.setToDate(LocalDate.parse("2025-03-04"));
        emp.getTitles().add(title);
        Title title2 = new Title();
        title2.setTitle("회장");
        title2.setEmpNo(10001);
        title2.setFromDate(LocalDate.parse("2025-03-05"));
        title2.setToDate(LocalDate.parse("2025-03-06"));
        emp.getTitles().add(title2);



        employeeService.modifyEmpSaveSalariesAndTitles(emp);
    }
}