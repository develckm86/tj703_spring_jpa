package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.SalaryId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SalaryRepositoryTest {
    @Autowired
    private SalaryRepository salaryRepository;
    @Test
    @Transactional
    void findById(){
        SalaryId id=new SalaryId();
        id.setEmpNo(10001);
        id.setFromDate(LocalDate.parse("1986-06-26"));
        System.out.println(salaryRepository.findById(id).get());
    }


    @Test
    @Transactional
    void findByEmpNo() {
        System.out.println(salaryRepository.findByEmpNo(10001).toString());
        //System.out.println(salaryRepository.findByEmpNo(10001).get(0).getSalary());
    }
}