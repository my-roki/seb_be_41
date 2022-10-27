package com.codestates.advice;

import com.codestates.exception.BusinessLogicException;
import com.codestates.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

// 앞으로 Controller 클래스에서 발생하는 예외를 GlobalExceptionAdvice 클래스가 처리하게 됩니다.
@RestControllerAdvice
public class GlobalExceptionAdvice {
    // MethodArgumentNotValidException
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorResponse response = ErrorResponse.of(e.getBindingResult());

        return response;
    }

    // ConstraintViolationException
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
        ErrorResponse response = ErrorResponse.of(e.getConstraintViolations());

        return response;
    }

    // BusinessLogicException
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBusinessLogicException(BusinessLogicException e) {
        System.out.println(e.getExceptionCode().getStatus());
        System.out.println(e.getMessage());

        ErrorResponse response = ErrorResponse.of(e.getExceptionCode());

        return response;
    }
}