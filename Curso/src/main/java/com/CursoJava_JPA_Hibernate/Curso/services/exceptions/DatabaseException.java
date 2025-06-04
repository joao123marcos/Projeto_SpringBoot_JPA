package com.CursoJava_JPA_Hibernate.Curso.services.exceptions;

public class DatabaseException extends RuntimeException{
    
    public DatabaseException(String msg){
        super(msg);
    }
}
