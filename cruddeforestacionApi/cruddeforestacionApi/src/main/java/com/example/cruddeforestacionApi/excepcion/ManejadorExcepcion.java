package com.example.cruddeforestacionApi.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorExcepcion {


    //le estamos diciendo que hicimos este método para que maneje las excpciones 
    //el signo de interrogacion dice que es genérico 
    @ExceptionHandler(RecursoNoEncontradoExcepcion.class)
    public ResponseEntity<?> manejadorRecursoNoEncontrado(RecursoNoEncontradoExcepcion recursoNoEncontradoExcepcion){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(recursoNoEncontradoExcepcion.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejadorExcepcionGlobal(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
    }
    
}
