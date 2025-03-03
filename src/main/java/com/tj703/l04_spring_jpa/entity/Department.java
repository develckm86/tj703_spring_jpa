package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity //해당 dto 로 table 을 맵핑
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "dept_no",columnDefinition = "CHAR(4)")
    String deptNo;
    @Column(name= "dept_name",length = 40)
    String deptName;
}
