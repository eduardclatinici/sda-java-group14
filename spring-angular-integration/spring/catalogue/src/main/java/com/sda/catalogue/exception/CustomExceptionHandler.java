package com.sda.catalogue.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleMyNotFoundException(NotFoundException e){
        log.error(e.getMessage(), e.getStackTrace());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldException> validationList = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new FieldException(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        log.info("Validation error list : " + validationList);
        return new ResponseEntity<>(validationList, status);
    }

    @AllArgsConstructor
    @Getter
    @ToString
    private class FieldException {
        private String fieldName;
        private String message;
    }
}
