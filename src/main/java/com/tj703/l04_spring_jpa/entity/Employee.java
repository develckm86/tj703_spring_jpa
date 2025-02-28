package com.tj703.l04_spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer id;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Lob
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;
    //Salary에서 무조건 OneToOne  ManyToOne 을 꼭!! 구현하고 있어야 한다.

    @OneToMany( mappedBy = "employee", fetch = FetchType.LAZY) //Salary.employee
    @ToString.Exclude
    @JsonBackReference
    private List<Salary> salaries;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonBackReference
    private List<Title> titles;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonBackReference
    private List<DeptEmp> deptEmps;

}