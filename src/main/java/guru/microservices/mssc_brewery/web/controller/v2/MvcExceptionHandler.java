package guru.microservices.mssc_brewery.web.controller.v2;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> handleContraintViolationException(ConstraintViolationException e){
        return new ResponseEntity<>(e.getConstraintViolations().stream()
                .map(c -> c.getPropertyPath()+" : "+c.getMessage())
                .toList(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<ObjectError>> handleBindException(BindException e){
        return new ResponseEntity<>(e.getAllErrors(), HttpStatus.BAD_REQUEST);
    }

}
