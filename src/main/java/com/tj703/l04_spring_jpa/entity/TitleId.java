package com.tj703.l04_spring_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
public class TitleId implements Serializable {
    @Column(name = "emp_no")
    int empNo;
    @Column(name = "title", length = 50)
    String title;
    @Column(name = "from_date")
    LocalDate fromDate;
}
