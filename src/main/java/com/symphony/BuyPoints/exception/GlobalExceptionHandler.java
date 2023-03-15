package com.symphony.BuyPoints.exception;

import com.symphony.BuyPoints.exception.custom.ChartNameExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static ResponseEntity<Object> getResponseEntity(String message, HttpStatus httpStatus) {
        ExceptionResponse response = new ExceptionResponse(message, LocalDateTime.now());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, httpStatus);
        return entity;
    }

    @ExceptionHandler(value = {ChartNameExistsException.class})
    protected ResponseEntity<Object> handleChartNameExistsExc(ChartNameExistsException ex) {
        ex.printStackTrace();
        return getResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        ex.printStackTrace();
        return getResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleException(Exception ex) {
        ex.printStackTrace();
        return getResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
