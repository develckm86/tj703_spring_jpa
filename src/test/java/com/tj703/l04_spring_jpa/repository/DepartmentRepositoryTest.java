package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    void findAll() {
        System.out.println(departmentRepository.findAll());
    }
    @Test
    void findById(){
        System.out.println(departmentRepository.findById("d001"));
    }
    //save : 없으면 insert, 있으면  update
    @Test
    void save() {
        Department department = new Department();
        department.setDeptNo("d888");
        department.setDeptName("세이브테스트");
        System.out.println(departmentRepository.save(department));
    }
    @Test
    void saveUpdate() {
        Department department = new Department();
        department.setDeptNo("d999");
        department.setDeptName("업데이트테스트");
        department.setDeptName("업데이트테스트");
        System.out.println(departmentRepository.save(department));
    }
    @Test
    void deleteById() {
        //deleteById 몇개 했냐? 를 반환하지 않음 void
        departmentRepository.deleteById("d889");
    }
}