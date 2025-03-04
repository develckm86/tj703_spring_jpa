package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Transactional
    public void findAll() {
        Page<Employee>  empPage=(employeeRepository.findAll(Pageable.ofSize(5)));
        System.out.println(empPage.getContent());
        System.out.println(empPage.getPageable());
    }
    @Test
    @Transactional
    public void findById() {
        System.out.println(employeeRepository.findById(10010));
    }

    @Test
    void findByLastName() {
        System.out.println(employeeRepository.findByLastName("Facello"));
    }

    @Test
    void findByHireDate() {
        List<Employee> empList=(employeeRepository.findByHireDate(LocalDate.parse("1986-06-26")));
        System.out.println(empList.size()); //83
        System.out.println(empList);
    }

    @Test
    void findByHireDateGreaterThan() {
        List<Employee> empList=(employeeRepository.findByHireDateGreaterThan(LocalDate.parse("1986-06-26")));
        System.out.println(empList.size()); //246982
        //System.out.println(empList);
    }

    @Test
    void findByHireDateStartingWith() {
        List<Employee> empList= employeeRepository.findByHireDateStartingWith("1986");
        System.out.println(empList.size());
        // Operand of 'like' is of type 'java.time.LocalDate' which is not a string (its JDBC type code is not string-like)
    }

    @Test
    @Transactional
    void findWithSalaryById() {
        //salary가 FetchType.Lazy  지정했기때문에 조인하지 않음
        System.out.println(employeeRepository.findWithSalaryById(10010));
    }
}