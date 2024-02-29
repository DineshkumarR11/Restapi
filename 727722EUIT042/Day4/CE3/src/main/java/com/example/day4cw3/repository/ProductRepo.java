package com.example.day4cw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day4cw3.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
    
}
