package com.simple_crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple_crud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
 
}
