package com.harshini.hibernate.hibernateExcersise.dao;

import com.harshini.hibernate.hibernateExcersise.entity.Course;
import com.harshini.hibernate.hibernateExcersise.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {


    List<Course> findByFeeLessThan(double fee);
}
