package com.tj703.l04_spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "titles")
@IdClass(TitleId.class)
public class Title {
    @Id
    @Column(name = "emp_no")
    int empNo;
    @Id
    @Column(name = "title", length = 50)
    String title;
    @Id
    @Column(name = "from_date")
    LocalDate fromDate;
    @Column(name = "to_date")
    LocalDate toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no")
    @ToString.Exclude
    @JsonBackReference//객체를 문자열 json으로 바꾸는 것을 하지마라 {"empNo":10004, "firstName":"jone"...}
    private Employee employee;

}
