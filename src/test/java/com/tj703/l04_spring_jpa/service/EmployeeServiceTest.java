package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.entity.Employee;
import com.tj703.l04_spring_jpa.entity.Salary;
import com.tj703.l04_spring_jpa.entity.Title;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EntityManager entityManager;
    @Test
    @Transactional
    void ploxyTest() {
        Employee emp=entityManager.getReference(Employee.class, 10001);
        System.out.println(emp.getClass().getName());
        System.out.println(emp);
        /*
        * 프록시 패턴은 객체에 대한 접근을 제어하기 위한 디자인 패턴
        *  클라이언트가 실제 객체에 접근하는 대신 프록시 객체를 통해 접근하도록 만들고
        *  실제 객체의 접근을 지연시키거나 보호할 수 있습니다.
        *  예)
        *  class Emp{}
        *  class ProxyEmp extends Emp{
        *       @Override
        *       대리로 실행할 함수 재정의
        * }
        *지연 로딩에서 프록시 객체의 역할
        * 1.초기화 지연: Proxy 객체는 Entity 객체를 초기화할 때까지 지연시킵니다.
        *   실제 객체를 사용하는 시점에만 생성이 이루어집니다.
        * 2.자원 절약: 객체가 필요한 시점에만 생성되므로 메모리 사용이나 자원 낭비를 줄일 수 있습니다.
        *  예를 들어, 데이터베이스나 외부 리소스를 사용한 초기화가 비싸다면,
        *  그 객체가 실제로 사용될 때만 초기화하여 성능을 최적화할 수 있습니다.
        * 3.제어된 접근: 프록시 객체가 실제 객체의 생성과 호출을 제어하기 때문에,
        *  로깅, 권한 체크, 캐싱 등의 부가적인 작업을 추가할 수 있습니다.
         */
    }
    @Test
    void entityMannagerTest() {
        employeeService.entityMannagerTest();
    }

    @Test
    void modifyEmpSaveSalariesAndTitles() {
        Employee emp = new Employee();
        emp.setGender("F");
        emp.setFirstName("test");
        emp.setLastName("testtest");
        emp.setBirthDate(LocalDate.parse("2025-03-04"));
        emp.setHireDate(LocalDate.parse("2025-03-04"));
        emp.setId(10001);
        Salary salary = new Salary();
        salary.setSalary(11100);
        salary.setEmpNo(10001);
        salary.setFromDate(LocalDate.parse("2025-03-03"));
        salary.setToDate(LocalDate.parse("2025-03-04"));
        emp.getSalaries().add(salary);

        Title title = new Title();
        title.setTitle("사장");
        title.setEmpNo(10001);
        title.setFromDate(LocalDate.parse("2025-03-03"));
        title.setToDate(LocalDate.parse("2025-03-04"));
        emp.getTitles().add(title);
        Title title2 = new Title();
        title2.setTitle("회장");
        title2.setEmpNo(10001);
        title2.setFromDate(LocalDate.parse("2025-03-05"));
        title2.setToDate(LocalDate.parse("2025-03-06"));
        emp.getTitles().add(title2);



        employeeService.modifyEmpSaveSalariesAndTitles(emp);
    }
}