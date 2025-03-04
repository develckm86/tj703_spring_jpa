package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.entity.Employee;
import com.tj703.l04_spring_jpa.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EntityManager entityManager;
    //EntityManager  영속성 컨텍스트의 엔터티를 호출
    @Transactional
    public void modifyEmpSaveSalariesAndTitles(Employee employee) {
        employeeRepository.save(employee);
        //save: 찾아서 있으면 수정, 없으면 등록

    }




    @Transactional
    public void entityMannagerTest(){
        //비영속 상태
        Optional<Employee> findEmpOpt=employeeRepository.findById(10001);
        //영속 상태
        Employee entityEmp=entityManager.find(Employee.class, 10001);
        System.out.println(findEmpOpt.get()==entityEmp);
        //처음 한번만 찾고 동일한 객체를 조회하면 영속성컨텍스트에 저장된 객체를 반환
        //영속성컨텍스트 덕분에 DB와 매번 Connection 을 생성(통신)하지 않기 때문에 부담이 적다.
        Optional<Employee> findEmpOpt2=employeeRepository.findById(10001);
        System.out.println(findEmpOpt.get()==findEmpOpt2.get());
        entityEmp.setBirthDate(LocalDate.parse("2025-03-04"));
        //기존의 데이터(객체)를 수정후 entityManager.persist()로 유지 시키면 내역이 변경됨
        entityManager.persist(entityEmp); //영속에 저장된 엔터티를 수정한 상태
        //완전히 새로운 데이터(객체)를 만든 후 persist 데이터를 새롭게 등록한다.
        Employee emp=new Employee();
        emp.setId(11);
        emp.setFirstName("John");
        emp.setLastName("Smith");
        emp.setHireDate(LocalDate.parse("2025-03-04"));
        emp.setBirthDate(LocalDate.parse("2025-03-04"));
        emp.setGender("M");
        entityManager.persist(emp); //영속에 새로운 객체를 저장한 상태
        //merge(저장된Entity) : update or delete 로 스키마에 저장된 내역과 영속성 컨텍스트에 등록된 내역을 동일하게 수정
        //detach(저장된Entity) : 영속성 컨텍스트에 저장된 엔터티를 삭제
        //clear() :완전히 초기화

        /*영속성 컨텍스트의 상태
        * Transient 비영속 상태 (영속성 컨텍스트에 아무것도 없는 상태)
        *
        * Persistent 영속 상태 (find로 db에서 찾거나 새로운 객체를 만들어서 추가한 상태)
        *
        * Detached 준영속 상태 (추가되어 있던 객체를 제거한 상태)
        *
        * clear 초기화 (모든 영속성 엔터티를 컨텍스트에서 제거한 상태)
        *
        * */
    }
}
