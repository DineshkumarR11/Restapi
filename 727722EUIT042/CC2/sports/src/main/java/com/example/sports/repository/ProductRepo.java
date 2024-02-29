package com.example.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sports.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{

    
}