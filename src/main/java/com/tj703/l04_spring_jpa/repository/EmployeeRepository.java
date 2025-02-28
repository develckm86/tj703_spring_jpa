package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //메소드 쿼리 규칙
    //find == select
    //by == where
    //LastName == entity 의 필드명을 파스칼 규칙(Employee.lastName)
    //==Select * from employees where last_name=:lastName
    List<Employee> findByLastName(String lastName);
    //매개변수의 타입은 엔터티의 필드와 같아야한다.(규칙!)
    List<Employee> findByHireDate(LocalDate hireDate);

    List<Employee> findByHireDateGreaterThan(LocalDate hireDate);
    //method쿼리가 불가능한 쿼리는 @Query를 작성
    //JPQL == Entity가 테이블이다.
    @Query("SELECT e FROM Employee e " +
            "WHERE CAST(e.hireDate as string) LIKE CONCAT(:hireDateStr,'%') " +
            "ORDER BY e.hireDate DESC")
    List<Employee> findByHireDateStartingWith(String hireDateStr);


}
