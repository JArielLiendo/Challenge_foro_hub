package com.forohub.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new);
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidacionDeExixtencia.class)
    public ResponseEntity errorHandlerValidacionesDeIntegridad(Exception e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }

    //TRATA DATOS DUPLICADOS
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolation(SQLIntegrityConstraintViolationException e) {
        var error = "No se admiten datos duplicados: "+e.getMessage();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);

    }


    private record DatosErrorValidacion (String campo, String error){
        public DatosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }

    }
}
