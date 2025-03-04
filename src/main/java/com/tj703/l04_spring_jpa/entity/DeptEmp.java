package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "dept_emp")
@IdClass(DeptEmpId.class)
public class DeptEmp {
    @Id
    @Column(name = "emp_no")
    private int empNo;
    @Id
    @Column(name = "dept_no", length = 4)
    private String deptNo;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_no",insertable = false, updatable = false)
    private Department department;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "emp_no",insertable = false, updatable = false)
    @ToString.Exclude
    private Employee employee;
}
