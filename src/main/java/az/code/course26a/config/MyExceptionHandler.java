package az.code.course26a.config;

import az.code.course26a.dto.ResponseModel;
import az.code.course26a.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseModel> handleResourceNotFoundException(NotFoundException ex) {
        // Handle the specific exception and return an appropriate response.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseModel.builder().message("Resource not found: " + ex.getMessage()).build());
    }





}
