package com.CursoJava_JPA_Hibernate.Curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CursoJava_JPA_Hibernate.Curso.Repositories.ProductRepository;
import com.CursoJava_JPA_Hibernate.Curso.entities.Product;

@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll(){
        return ProductRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = ProductRepository.findById(id);
        return obj.get();
    }
}
