package com.harshini.hibernate.hibernateExcersise.service;

import com.harshini.hibernate.hibernateExcersise.dao.CourseRepository;
import com.harshini.hibernate.hibernateExcersise.dao.StudentRepository;
import com.harshini.hibernate.hibernateExcersise.dto.StudentCourseResponse;
import com.harshini.hibernate.hibernateExcersise.entity.Course;
import com.harshini.hibernate.hibernateExcersise.entity.Student;
import com.harshini.hibernate.hibernateExcersise.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public StudentCourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Student saveStudentWithCourse(Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with id "+id));
        return student;
    }

    public List<Student> findStudentContainingByName(String name) {
        System.out.println("HEllo Name :: "+name);
        return studentRepository.findByNameIgnoreCaseContaining(name);
    }

    public List<Course> findCourseLessThan(double fee) {
        return courseRepository.findByFeeLessThan(fee);
    }

    public List<StudentCourseResponse> getByNameAndCourses() {
        return studentRepository.getByNameAndCourses();
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }
}
