package com.harshini.hibernate.hibernateExcersise.controller;

import com.harshini.hibernate.hibernateExcersise.dto.APIResponse;
import com.harshini.hibernate.hibernateExcersise.dto.StudentCourseResponse;
import com.harshini.hibernate.hibernateExcersise.entity.Course;
import com.harshini.hibernate.hibernateExcersise.entity.Student;
import com.harshini.hibernate.hibernateExcersise.service.StudentCourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody @Valid Student student)
    {
        return  studentCourseService.saveStudentWithCourse(student);
    }

    @GetMapping
    public List<Student> findAllStudent()
    {
        return studentCourseService.findAllStudent();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<APIResponse> findStudentById(@PathVariable Long studentId)
    {
        Student student = studentCourseService.findStudentById(studentId);
        APIResponse<Object> response = APIResponse.builder()
                .status("Success")
                .results(student)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{studentName}")
    public List<Student> findStudentContainingByName(@PathVariable String studentName)
    {
        return studentCourseService.findStudentContainingByName(studentName);
    }

    @GetMapping("/search/{fee}")
    public List<Course> findCourseLessThan(@PathVariable double fee)
    {
        return studentCourseService.findCourseLessThan(fee);
    }

    @GetMapping("/all")
    public List<StudentCourseResponse> getByNameAndCourse()
    {
        return studentCourseService.getByNameAndCourses();
    }

    @GetMapping("/courses")
    public List<Course> findAllCourses()
    {
        return studentCourseService.findAllCourses();
    }

}
