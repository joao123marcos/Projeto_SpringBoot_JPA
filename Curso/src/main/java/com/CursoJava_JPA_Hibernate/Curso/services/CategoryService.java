package com.CursoJava_JPA_Hibernate.Curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CursoJava_JPA_Hibernate.Curso.Repositories.CategoryRepository;
import com.CursoJava_JPA_Hibernate.Curso.entities.Category;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> findAll(){
        return CategoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = CategoryRepository.findById(id);
        return obj.get();
    }
}
