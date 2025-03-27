package com.viewnext.practica_spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewnext.practica_spring.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
