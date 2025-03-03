package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class DeptEmpId implements Serializable {
    @Column(name = "emp_no")
    private int empNo;
    @Column(name = "dept_no", length = 4)
    private String deptNo;

}
