package com.tj703.l04_spring_jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeptEmpRepositoryTest {

    @Autowired
    private DeptEmpRepository deptEmpRepository;
    @Test
    void findByEmpNo() {
        System.out.println(deptEmpRepository.findByEmpNo(10010));
    }
}