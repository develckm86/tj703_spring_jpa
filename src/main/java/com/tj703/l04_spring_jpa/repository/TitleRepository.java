package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Title;
import com.tj703.l04_spring_jpa.entity.TitleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<Title, TitleId> {
    List<Title> findByEmpNo(int empNo);
}
