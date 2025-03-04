package com.tj703.l04_spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDate;
import java.util.LinkedHashSet;
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

    //@Transient //employees 를 조회해서 영속성 컨텍스트에 저장할때 제외하겠다. => fetch도 제외
    //Salary에서 무조건 OneToOne  ManyToOne 을 꼭!! 구현하고 있어야 한다.
    /*cascade = CascadeType.
    * PERSIST : emp 저장될 때  salaries 도 같이 저장하겠다.
    * MERGE  : emp 수정될 때  salaries 도 같이 수정하겠다.
    * REMOVE : emp 가 삭제될때 salaries 도 같이 삭제하겠다.
    * ALL : emp( 저장,수정,삭제)될 때 salaries도 같이 ( 저장,수정,삭제)하겠다.
    * REFRESH : 부모(emp)의 영속성이 새로고쳐질때 자식(salaries)도 새로고침
    * DETACH :부모(emp)가 영속성에서 제거될 때 자식(salaries)도 제거되겠다.
     * */
    @OneToMany( mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //Salary.employee
    //@ToString.Exclude
    @JsonBackReference
    @OrderBy(value = "salary DESC")
    private Set<Salary> salaries=new LinkedHashSet<>();//미리 만들어놓으면 데이터만 추가 (타입을 보장 받음)
    //HashSet : 순서를 보장하지 않고 중복만제거
    //LinkedHashSet : 순서를 보장하는 Set == List 처럼 사용가능

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@ToString.Exclude
    @JsonBackReference
    @BatchSize(size = 100)
    private Set<Title> titles=new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@ToString.Exclude
    @JsonBackReference
    private Set<DeptEmp> deptEmps=new LinkedHashSet<>();
}