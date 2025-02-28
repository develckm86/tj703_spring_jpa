package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

}
