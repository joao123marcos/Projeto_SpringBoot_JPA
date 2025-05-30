package com.CursoJava_JPA_Hibernate.Curso.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CursoJava_JPA_Hibernate.Curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

