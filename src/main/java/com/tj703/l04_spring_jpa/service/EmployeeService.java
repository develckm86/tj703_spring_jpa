package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.entity.DeptEmp;
import com.tj703.l04_spring_jpa.entity.Employee;
import com.tj703.l04_spring_jpa.entity.Salary;
import com.tj703.l04_spring_jpa.entity.Title;
import com.tj703.l04_spring_jpa.repository.EmployeeRepository;
import com.tj703.l04_spring_jpa.repository.SalaryRepository;
import com.tj703.l04_spring_jpa.repository.TitleRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EntityManager entityManager;
    @Transactional
    public void saveSalaryAndTitleAndDeptEmp(Employee employee){
        //Employee entityEmp=entityManager.find(Employee.class, employee.getId());
        // System.out.println(entityEmp);
        entityManager.merge(employee);
        for (Salary salary : employee.getSalaries()) {


            //entityManager.persist(salary);
        }
        for (DeptEmp deptEmp : employee.getDeptEmps()) {
            //entityManager.persist(deptEmp);
        }
        entityManager.flush();
    }
}
