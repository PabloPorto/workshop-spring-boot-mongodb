package com.pabloporto.workshopmongo.resourses.exceptions;

import com.pabloporto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Standarderror> objectedNotFound(ObjectNotFoundException e, HttpServletRequest request){

        HttpStatus status  = HttpStatus.NOT_FOUND;
        Standarderror error = new Standarderror(System.currentTimeMillis(),status.value(),"Não Encontrado",
                e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(error);

    }
}
