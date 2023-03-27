package com.harshini.hibernate.hibernateExcersise.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String msg)
    {
        super(msg);
    }
}
