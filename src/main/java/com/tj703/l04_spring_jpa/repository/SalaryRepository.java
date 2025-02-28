package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Salary;
import com.tj703.l04_spring_jpa.entity.SalaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, SalaryId> {
    // _ : jap method queryd에서 필드 접근자.
    // empNo가 복합키기 때문에 Salary.id.empNo => id_empNo => Id_EmpNo
    //List<Salary> findById_EmpNo(int empNo);
    List<Salary> findByEmpNo(Integer empNo);
}
