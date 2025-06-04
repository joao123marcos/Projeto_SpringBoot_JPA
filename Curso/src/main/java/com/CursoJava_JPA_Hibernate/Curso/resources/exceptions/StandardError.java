package com.CursoJava_JPA_Hibernate.Curso.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", 
                timezone = "GMT")
    private Instant timeStamp;
    private Integer statusError;
    private String error;
    private String messageExceptionError;
    private String pathError;

    public StandardError() {
    }

    public StandardError(Instant timeStamp, Integer statusError, 
     String error, String message, String pathError) {
        this.timeStamp = timeStamp;
        this.statusError = statusError;
        this.error = error;
        this.messageExceptionError = message;
        this.pathError = pathError;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatusError() {
        return statusError;
    }

    public void setStatusError(Integer statusError) {
        this.statusError = statusError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.messageExceptionError;
    }

    public void setMessage(String message) {
        this.messageExceptionError = message;
    }

    public String getPathError() {
        return pathError;
    }

    public void setPathError(String pathError) {
        this.pathError = pathError;
    }
}
