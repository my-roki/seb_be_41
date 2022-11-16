package com.cafe.response;

import com.cafe.exception.ExceptionCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {
    private List<FieldError> fieldErrors;
    private List<ConstraintViolationError> violationErrors;
    private int status;
    private String message;


    private ErrorResponse(List<FieldError> fieldErrors, List<ConstraintViolationError> violationErrors) {
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
    }

    private ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldError.of(bindingResult), null);
    }

    public static ErrorResponse of(Set<ConstraintViolation<?>> constraintViolations) {
        return new ErrorResponse(null, ConstraintViolationError.of(constraintViolations));
    }

    public static ErrorResponse of(ExceptionCode code) {
        return new ErrorResponse(code.getStatus(), code.getMessage());
    }

    public static ErrorResponse of(HttpStatus status) {
        return new ErrorResponse(status.value(), status.getReasonPhrase());
    }


    @Getter
    public static class FieldError {
        private final String field;
        private final Object rejectedValue;
        private final String defaultMessage;

        private FieldError(String field, Object rejectedValue, String defaultMessage) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.defaultMessage = defaultMessage;
        }

        public static List<FieldError> of(BindingResult bindingResult) {
            List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();

            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue(),
                            error.getDefaultMessage()
                    )).collect(Collectors.toList());
        }
    }

    @Getter
    public static class ConstraintViolationError {
        private final String propertyPath;
        private final Object rejectedValue;
        private final String message;


        private ConstraintViolationError(String propertyPath, Object rejectedValue, String message) {
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.message = message;
        }

        public static List<ConstraintViolationError> of(Set<ConstraintViolation<?>> constraintViolations) {
            return constraintViolations.stream()
                    .map(constraintViolation -> new ConstraintViolationError(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getInvalidValue().toString(),
                            constraintViolation.getMessage()
                    )).collect(Collectors.toList());
        }
    }
}