package com.tj703.l04_spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Data //get set toString equals
@Entity
@Table(name = "salaries")
@IdClass(SalaryId.class)
public class Salary {
    //@EmbeddedId
    //private SalaryId id;
    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;
    @Id
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    //@MapsId("empNo")
    @JoinColumn(name = "emp_no")
    @ToString.Exclude
    @JsonBackReference
    private Employee employee;

    //salaries(fk emp_no) join employees
    //FetchType.EAGER : 즉시조회 1개를 조회(pk)할때는 Join, 조회 내역이 여러개일때는 Select fetch 조회
    //FetchType.LAZY : 지연조회(Select fetch 조회), join 하는 내역(employee)의 필드를 참조할때 Select fetch 조회
    //필드를 참조 Trigger : 필드참조, toString, 직렬화(JSON) ...
    //@Test 에서 fetch trigger(toString)을 발생시키면 잘인지 하지 못한다.
    // =>@Transactional 을 정의해서 @Test 가 마지막 지점(view 처럼)인 것을 명시
    //@MapsId("empNo") //emp_no 는 복합키의 empNo 필드를 참조(SalaryId.empNo==employees.emp_no)
}