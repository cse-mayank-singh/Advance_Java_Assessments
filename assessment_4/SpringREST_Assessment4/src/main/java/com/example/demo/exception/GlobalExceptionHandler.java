package com.example.demo.exception;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PolicyNotFoundException.class)
    public ResponseEntity<?> handlePolicyNotFound(
            PolicyNotFoundException ex,
            HttpServletRequest request) {
        Map<String,Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status",404);
        error.put("error",ex.getMessage());
        error.put("path",request.getRequestURI());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFound(
            CustomerNotFoundException ex,
            HttpServletRequest request) {
        Map<String,Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status",404);
        error.put("error",ex.getMessage());
        error.put("path",request.getRequestURI());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}