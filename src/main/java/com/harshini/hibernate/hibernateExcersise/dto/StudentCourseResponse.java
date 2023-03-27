package com.harshini.hibernate.hibernateExcersise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseResponse {

    private String name;
    private String courseName;
}
