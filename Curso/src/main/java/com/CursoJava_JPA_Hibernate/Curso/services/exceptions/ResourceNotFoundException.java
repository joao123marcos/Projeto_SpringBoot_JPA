package com.CursoJava_JPA_Hibernate.Curso.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found for id: "+id);
    }
    
}
//Essa classe vai apenas gerar a mensagem padrão para exceções do tipo ResourceNotFound