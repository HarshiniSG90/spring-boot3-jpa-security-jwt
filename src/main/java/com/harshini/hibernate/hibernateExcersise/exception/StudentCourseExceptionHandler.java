package com.harshini.hibernate.hibernateExcersise.exception;

import com.harshini.hibernate.hibernateExcersise.dto.APIResponse;
import com.harshini.hibernate.hibernateExcersise.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class StudentCourseExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception)
    {
        APIResponse<?> serviceResponse = new APIResponse<>();
        List<ErrorDTO> errors = new ArrayList<ErrorDTO>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErrorDTO errorDTO = new ErrorDTO(error.getField(),error.getDefaultMessage());
                    errors.add(errorDTO);
                });
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(errors);
        return serviceResponse;
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public APIResponse<?> handleStudentNotFoundException(StudentNotFoundException exception)
    {
        APIResponse<?> apiResponse = new APIResponse<>();
        apiResponse.setStatus("FAILED");
        apiResponse.setErrors(Collections.singletonList(new ErrorDTO("",exception.getMessage())));
        return apiResponse;
    }

}
