package com.harshini.hibernate.hibernateExcersise.dao;

import com.harshini.hibernate.hibernateExcersise.dto.StudentCourseResponse;
import com.harshini.hibernate.hibernateExcersise.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByNameIgnoreCaseContaining(String name);

    @Query("SELECT new com.harshini.hibernate.hibernateExcersise.dto.StudentCourseResponse(stud.name,course.title) FROM Student stud JOIN stud.courses course")
    public  List<StudentCourseResponse> getByNameAndCourses();
}
