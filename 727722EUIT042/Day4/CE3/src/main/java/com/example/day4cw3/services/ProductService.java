package com.example.day4cw3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw3.model.Product;
import com.example.day4cw3.repository.ProductRepo;

@Service
public class ProductService {
    public ProductRepo productRepo;
    public ProductService(ProductRepo productRepo)
    {
        this.productRepo=productRepo;
    }
    public boolean saveProduct(Product product)
    {
        try{
            productRepo.save(product);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Product> getProducts()
    {
        return productRepo.findAll();
    }
    public Product getProductById(int id)
    {
        Optional<Product> obj = productRepo.findById(id);
        return obj.orElse(new Product());
    }
}
