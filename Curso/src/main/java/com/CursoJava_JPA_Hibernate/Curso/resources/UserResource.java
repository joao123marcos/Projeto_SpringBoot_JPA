package com.CursoJava_JPA_Hibernate.Curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CursoJava_JPA_Hibernate.Curso.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"MariaJose", "mariajose@gmail.com", 
         "35 9 92347064", "AxR256396dd");
        
        return ResponseEntity.ok().body(u); 
    }
    
}
