package com.tj703.l04_spring_jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TitleRepositoryTest {
    @Autowired
    TitleRepository titleRepository;
    @Test
    @Transactional
    void findByEmpNo() {
        System.out.println(titleRepository.findByEmpNo(10004));
    }
}