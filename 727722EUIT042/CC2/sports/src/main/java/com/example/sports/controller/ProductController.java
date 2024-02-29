package com.example.sports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.sports.model.Product;
import com.example.sports.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ProductController {
    @Autowired
    UserService pService;
    @PostMapping("/api/product")
    public Product postProduct(@RequestBody Product p) {
        
        return pService.postProduct(p);
    }
    @GetMapping("/api/product")
    public List<Product> getProduct() {
        return pService.getProduct();
    }
     @PutMapping("/api/product/{productId}")
    public Product putProduct(@PathVariable Long productId, @RequestBody Product product) {
    
        return pService.putProduct(product, productId);
    }
    @DeleteMapping("/api/product/{productId}")
    public String deleteProduct(@PathVariable Long productId)
    {
        return pService.deleteProduct(productId);
    }
    @GetMapping("/api/product/sortBy/{field}")
    public List<Product> getProductsWithSorting(@PathVariable String field)
    {
        return pService.getProductsWithSorting(field);
    }  
    @GetMapping("/api/product/{pageNumber}/{pageSize}")
    public List<Product>getProductWithPaging(@PathVariable int pageNumber,@PathVariable int pageSize)
    {
        return pService.getProductsWithPaging(pageNumber, pageSize);
    }
    @GetMapping("/api/product/{pageNumber}/{pageSize}/{field}")
    public List<Product>getProductWithPagingAndSorting(@PathVariable int pageNumber,@PathVariable int pageSize,@PathVariable String field)
    {
        return pService.getProductsWithPagingAndSorting(pageNumber, pageSize, field);
    }
}