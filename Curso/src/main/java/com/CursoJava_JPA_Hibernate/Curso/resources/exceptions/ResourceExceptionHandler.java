package com.CursoJava_JPA_Hibernate.Curso.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.CursoJava_JPA_Hibernate.Curso.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    /*Ao invés de ter que colocar try- catch em cada método do meu controller eu crio uma
     * classe para fazer tratamento de exceção e essa anotação diz este método é que fará
     * tratmentos de exceção do tipo resources not found*/
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, 
      HttpServletRequest request){

        String defaultError = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND; //Retorna o código 404
        StandardError erro = new StandardError(Instant.now(), status.value(), defaultError, 
           e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(erro);

    }
    
}
