package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DeptEmpId {
    @Column(name = "emp_no")
    private int empNo;
    @Column(name = "dept_no", length = 4)
    private String deptNo;

}
