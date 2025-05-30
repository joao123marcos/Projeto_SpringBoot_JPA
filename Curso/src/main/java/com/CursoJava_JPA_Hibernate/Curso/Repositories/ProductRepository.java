package com.CursoJava_JPA_Hibernate.Curso.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CursoJava_JPA_Hibernate.Curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

