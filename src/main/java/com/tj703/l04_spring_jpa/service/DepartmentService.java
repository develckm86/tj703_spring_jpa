package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.entity.Department;
import com.tj703.l04_spring_jpa.entity.DeptEmp;
import com.tj703.l04_spring_jpa.entity.Employee;
import com.tj703.l04_spring_jpa.repository.DepartmentRepository;
import com.tj703.l04_spring_jpa.repository.DeptEmpRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DeptEmpRepository deptEmpRepository;
    private EntityManager entityManager;
    @Transactional
    public boolean addEmpDepartment(DeptEmp deptEmp) {
        boolean result = false;
        entityManager.persist(deptEmp);
        //entityManager.flush();
        return result;
    }


}
