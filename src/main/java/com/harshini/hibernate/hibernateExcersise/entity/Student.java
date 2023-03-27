package com.harshini.hibernate.hibernateExcersise.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="STUDENT_TBL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name cannot be Null or Blank")
    private String name;
    private int age;
    private String dept;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="STUDENT_COURSE_TBL",
               joinColumns = {
                    @JoinColumn(name="student_id",referencedColumnName = "id")
                },
                inverseJoinColumns = {
                     @JoinColumn(name="course_id",referencedColumnName = "id")
                })
    @JsonManagedReference
    private Set<Course> courses;
}
