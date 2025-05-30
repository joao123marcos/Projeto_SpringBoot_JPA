package com.CursoJava_JPA_Hibernate.Curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CursoJava_JPA_Hibernate.Curso.entities.Product;
import com.CursoJava_JPA_Hibernate.Curso.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService ProductService;

    
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = ProductService.findAll();
        
        return ResponseEntity.ok().body(list); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = ProductService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
}
